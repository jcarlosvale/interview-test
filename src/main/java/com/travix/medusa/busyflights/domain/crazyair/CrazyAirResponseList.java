package com.travix.medusa.busyflights.domain.crazyair;

import java.util.ArrayList;
import java.util.List;

/**
 * New class
 * Represents a List of Crazy Air Responses
 * @author Joao Carlos
 *
 */
public class CrazyAirResponseList {
	private List<CrazyAirResponse> responses = new ArrayList<CrazyAirResponse>();

	public CrazyAirResponseList() {
		super();
	}

	public CrazyAirResponseList(List<CrazyAirResponse> responses) {
		super();
		this.responses = responses;
	}

	public List<CrazyAirResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<CrazyAirResponse> responses) {
		this.responses = responses;
	}
	
	public void addResponse(CrazyAirResponse response) {
		this.responses.add(response);
	}

	@Override
	public String toString() {
		return "CrazyAirResponseList [responses=" + responses + "]";
	}
}
