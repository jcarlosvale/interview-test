package com.travix.medusa.busyflights.rest.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponseList;

/**
 * New Class
 * ToughJet WS Rest Client
 * @author joao
 *
 */
@Component
public class ToughJetRestClient {
	@Autowired
	private RestTemplate restTemplate;

	public ToughJetResponseList retrieveData(ToughJetRequest toughJetRequest) {
		return restTemplate.postForObject("http://localhost:8080/tough",
				toughJetRequest,ToughJetResponseList.class);
	}

}
