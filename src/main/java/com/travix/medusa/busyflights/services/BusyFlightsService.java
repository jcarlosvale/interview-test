package com.travix.medusa.busyflights.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponseList;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseList;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponseList;
import com.travix.medusa.busyflights.rest.webservices.CrazyAirRestClient;
import com.travix.medusa.busyflights.rest.webservices.ToughJetRestClient;

/**
 * New Class 
 * Main Service responsible by retrieve data of WS Rest Clients, sort
 * the response and send to User through our WS Rest Service.
 * 
 * @author joao
 *
 */
@Component
public class BusyFlightsService {

	@Autowired
	private CrazyAirRestClient crazyAirRestClient;

	@Autowired
	private ToughJetRestClient toughJetRestClient;

	/**
	 * Main method
	 * Convert the BusyFlightsRequest in CrazyAirRequest and ToughJetRequest,
	 * Populate the Responses List and fill an BusyFlightsResponseList
	 * Sort BusyFlightsResponseList by fare and return to the WS Rest Service
	 * @param busyFlightsRequest
	 * @return
	 */
	public BusyFlightsResponseList findAndSortByFare(BusyFlightsRequest busyFlightsRequest) {

		CrazyAirRequest crazyAirRequest = BusyFlightsDataConvertService.convertToCrazyAirRequest(busyFlightsRequest);
		ToughJetRequest toughJetRequest = BusyFlightsDataConvertService.convertToToughJetRequest(busyFlightsRequest);

		CrazyAirResponseList crazyAirRequestList = crazyAirRestClient.retrieveData(crazyAirRequest);
		ToughJetResponseList toughJetResponseList = toughJetRestClient.retrieveData(toughJetRequest);

		BusyFlightsResponseList busyFlightsResponseList = new BusyFlightsResponseList();

		addBusyFlighsResponseFromCrazyAirResponseList(busyFlightsResponseList, crazyAirRequestList);
		addBusyFlighsResponseFromToughJetResponseList(busyFlightsResponseList, toughJetResponseList);

		busyFlightsResponseList.getResponses()
				.sort((response1, response2) -> (int) (response1.getFare() * 100) - (int) (response2.getFare() * 100));

		return busyFlightsResponseList;
	}

	/**
	 * Add ToughJet Responses in a BusyFlightsResponseList
	 * @param busyFlightsResponseList
	 * @param toughJetResponseList
	 */
	private void addBusyFlighsResponseFromToughJetResponseList(BusyFlightsResponseList busyFlightsResponseList,
			ToughJetResponseList toughJetResponseList) {
		if (toughJetResponseList == null)
			return;
		for (ToughJetResponse toughJetResponse : toughJetResponseList.getResponses()) {
			busyFlightsResponseList.add(BusyFlightsDataConvertService.convertToBusyFlightsResponse(toughJetResponse));
		}
	}

	/**
	 * Add CrazyAir Responses in a BusyFlightsResponseList
	 * @param busyFlightsResponseList
	 * @param crazyAirRequestList
	 */
	private void addBusyFlighsResponseFromCrazyAirResponseList(BusyFlightsResponseList busyFlightsResponseList,
			CrazyAirResponseList crazyAirRequestList) {
		if (crazyAirRequestList == null)
			return;
		for (CrazyAirResponse crazyAirResponse : crazyAirRequestList.getResponses()) {
			busyFlightsResponseList.add(BusyFlightsDataConvertService.convertToBusyFlightsResponse(crazyAirResponse));
		}
	}
}
