package com.travix.medusa.busyflights.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.rest.webservices.CrazyAirRestClient;
import com.travix.medusa.busyflights.rest.webservices.ToughJetRestClient;

@Component
public class BusyFlightsService {

	@Autowired
	private CrazyAirRestClient crazyAirRestClient;
	
	@Autowired
	private ToughJetRestClient toughJetRestClient;

	
	public List<BusyFlightsResponse> findAndSortByFare(BusyFlightsRequest busyFlightsRequest) {
		
		return new ArrayList<BusyFlightsResponse>();

	}
}
