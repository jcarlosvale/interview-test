package com.travix.medusa.busyflights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponseList;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseList;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
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
