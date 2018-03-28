package com.travix.medusa.busyflights.domain.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class BusyFlightsRequestDTOTests {

	@Test
	public void creatingBusyFlightsRequestDTOTest() {
		BusyFlightsRequest request = new BusyFlightsRequest();
		request.setOrigin("RIO");
		request.setDestination("NYC");
		request.setDepartureDate("2018-05-01");
		request.setReturnDate("2018-06-01");
		request.setNumberOfPassengers(1);
		
		BusyFlightsRequestDTO dto = new BusyFlightsRequestDTO(request);
		
		assertNotNull(dto);
		assertEquals(dto.getOrigin(),request.getOrigin());
	}
}
