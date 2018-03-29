package com.travix.medusa.busyflights.services;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.busyflights.enums.Supplier;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

/**
 * New Class
 * An util service class to convert data between BusyFlightsResponse,
 * ToughJetResponse, CrazyAirResponse, BusyFlightsRequest, ToughJetRequest, CrazyAirRequest
 * 
 * @author joao
 *
 */
public class BusyFlightsDataConvertService {

	/**
	 * Convert ToughJetResponse in BusyFlightsResponse
	 * @param toughJetResponse
	 * @return
	 */
	public static BusyFlightsResponse convertToBusyFlightsResponse(ToughJetResponse toughJetResponse) {
		double fare = toughJetResponse.getBasePrice() + toughJetResponse.getTax();

		fare = fare * (1 - toughJetResponse.getDiscount());

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

	/**
	 * Convert CrazyAirResponse in BusyFlightsResponse
	 * @param crazyAirResponse
	 * @return
	 */
	public static BusyFlightsResponse convertToBusyFlightsResponse(CrazyAirResponse crazyAirResponse) {
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

	/**
	 * Convert BusyFlightsRequest in ToughJetRequest
	 * @param busyFlightsRequest
	 * @return
	 */
	public static ToughJetRequest convertToToughJetRequest(BusyFlightsRequest busyFlightsRequest) {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
		toughJetRequest.setTo(busyFlightsRequest.getDestination());
		toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
		toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
		toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());

		return toughJetRequest;
	}

	/**
	 * Convert BusyFlightsRequest in CrazyAirRequest
	 * @param busyFlightsRequest
	 * @return
	 */
	public static CrazyAirRequest convertToCrazyAirRequest(BusyFlightsRequest busyFlightsRequest) {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
		crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
		crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
		crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
		crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());

		return crazyAirRequest;
	}
}
