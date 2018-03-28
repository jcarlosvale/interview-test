package com.travix.medusa.busyflights.rest.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.services.BusyFlightsService;

@RestController
public class BusyFlightsController {

	@Autowired
	private BusyFlightsService busyFlightsService;

	@PostMapping("/flights")
	public List<BusyFlightsResponse> retrieveBusyFlightsResponses(
			@RequestBody BusyFlightsRequest busyFlightsRequest) {
		return busyFlightsService.findAndSortByFare(busyFlightsRequest);
	}
}
