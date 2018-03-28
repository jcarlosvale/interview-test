package com.travix.medusa.busyflights.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponseList;
import com.travix.medusa.busyflights.domain.busyflights.enums.Supplier;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseList;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponseList;
import com.travix.medusa.busyflights.rest.webservices.CrazyAirRestClient;
import com.travix.medusa.busyflights.rest.webservices.ToughJetRestClient;

@Component
public class BusyFlightsService {

	@Autowired
	private CrazyAirRestClient crazyAirRestClient;

	@Autowired
	private ToughJetRestClient toughJetRestClient;

	public BusyFlightsResponseList findAndSortByFare(BusyFlightsRequest busyFlightsRequest) {

		CrazyAirRequest crazyAirRequest = convertToCrazyAirRequest(busyFlightsRequest);
		ToughJetRequest toughJetRequest = convertToToughJetRequest(busyFlightsRequest);
		
		CrazyAirResponseList crazyAirRequestList = crazyAirRestClient.retrieveData(crazyAirRequest);
		ToughJetResponseList toughJetResponseList = toughJetRestClient.retrieveData(toughJetRequest);
		
		BusyFlightsResponseList busyFlightsResponseList = new BusyFlightsResponseList();
		
		addBusyFlighsResponseFromCrazyAirResponseList(busyFlightsResponseList,crazyAirRequestList);
		addBusyFlighsResponseFromToughJetResponseList(busyFlightsResponseList,toughJetResponseList);
		
		busyFlightsResponseList.getResponses().sort(
				(response1,response2)->(int)(response2.getFare()*100)-(int)(response1.getFare()*100));
		return busyFlightsResponseList;
	}

	private void addBusyFlighsResponseFromToughJetResponseList(BusyFlightsResponseList busyFlightsResponseList,
			ToughJetResponseList toughJetResponseList) {
		for(ToughJetResponse toughJetResponse: toughJetResponseList.getResponses()) {
			busyFlightsResponseList.add(convertToBusyFlightsResponse(toughJetResponse));
		}
	}

	private BusyFlightsResponse convertToBusyFlightsResponse(ToughJetResponse toughJetResponse) {
		double fare = toughJetResponse.getBasePrice() + toughJetResponse.getTax();
		
		fare = fare * (1-toughJetResponse.getDiscount());
		
		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
		busyFlightsResponse.setSupplier(Supplier.ToughJet);
		busyFlightsResponse.setFare(fare);
		busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
		busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
		busyFlightsResponse.setDepartureDate(toughJetResponse.getOutboundDateTime());
		busyFlightsResponse.setArrivalDate(toughJetResponse.getInboundDateTime());
		
		return busyFlightsResponse;
	}

	private void addBusyFlighsResponseFromCrazyAirResponseList(BusyFlightsResponseList busyFlightsResponseList,
			CrazyAirResponseList crazyAirRequestList) {
		for (CrazyAirResponse crazyAirResponse : crazyAirRequestList.getResponses()) {
			busyFlightsResponseList.add(convertToBusyFlightsResponse(crazyAirResponse));
		}
	}

	private BusyFlightsResponse convertToBusyFlightsResponse(CrazyAirResponse crazyAirResponse) {
		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
		busyFlightsResponse.setSupplier(Supplier.CrazyAir);
		busyFlightsResponse.setFare(crazyAirResponse.getPrice());
		busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
		busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
		busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate());
		busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate());
		
		return busyFlightsResponse;
	}

	private ToughJetRequest convertToToughJetRequest(BusyFlightsRequest busyFlightsRequest) {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
		toughJetRequest.setTo(busyFlightsRequest.getDestination());
		toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
		toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
		toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
		
		return toughJetRequest;
	}

	private CrazyAirRequest convertToCrazyAirRequest(BusyFlightsRequest busyFlightsRequest) {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
		crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
		crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
		crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
		crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());

		return crazyAirRequest;
	}

}
