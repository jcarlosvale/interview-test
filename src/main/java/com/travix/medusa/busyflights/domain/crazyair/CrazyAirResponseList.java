package com.travix.medusa.busyflights.domain.crazyair;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public String toString() {
		return "CrazyAirResponseList [responses=" + responses + "]";
	}
}
