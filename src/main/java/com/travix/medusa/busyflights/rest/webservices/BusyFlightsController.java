package com.travix.medusa.busyflights.rest.webservices;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponseList;
import com.travix.medusa.busyflights.services.BusyFlightsService;

/**
 * New Class
 * Main WS Rest Controller  
 * @author joao
 *
 */
@RestController
public class BusyFlightsController {

	@Autowired
	private BusyFlightsService busyFlightsService;

	/**
	 * The method post was chosen because it is not idempotent.
	 * @param busyFlightsRequest
	 * @return
	 */
	@PostMapping("/flights")
	public BusyFlightsResponseList retrieveBusyFlightsResponses(
			@Valid @RequestBody BusyFlightsRequest busyFlightsRequest) {
		return busyFlightsService.findAndSortByFare(busyFlightsRequest);
	}
}
