package com.travix.medusa.busyflights.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Component
public class BusyFlightsService {

	public List<BusyFlightsResponse> findAndSortByFare(BusyFlightsRequest busyFlightsRequest) {
//		BusyFlightsRequestDTO busyFlightsRequestDTO = new BusyFlightsRequestDTO(busyFlightsRequest);
		return null;
	}

}
