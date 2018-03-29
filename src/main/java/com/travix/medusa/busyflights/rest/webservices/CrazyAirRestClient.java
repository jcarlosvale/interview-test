package com.travix.medusa.busyflights.rest.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponseList;

/**
 * CrazyAir WS Rest Client
 * @author joao
 *
 */
@Component
public class CrazyAirRestClient {

	@Autowired
	private RestTemplate restTemplate;

	public CrazyAirResponseList retrieveData(CrazyAirRequest crazyAirRequest) {
		return restTemplate.postForObject("http://localhost:8080/crazy",
				crazyAirRequest,CrazyAirResponseList.class);
	}
}
