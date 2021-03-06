package com.travix.medusa.busyflights.domain.busyflights;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a List of Buys Flights, merge responses of CrazyAir and ToughJet
 * @author Joao Carlos
 *
 */
public class BusyFlightsResponseList {

	private List<BusyFlightsResponse> responses = new ArrayList<BusyFlightsResponse>();

	public List<BusyFlightsResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<BusyFlightsResponse> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "BusyFlightsResponseList [responses=" + responses + "]";
	}

	public BusyFlightsResponseList(List<BusyFlightsResponse> responses) {
		super();
		this.responses = responses;
	}

	public BusyFlightsResponseList() {
		super();
	}

	public void add(BusyFlightsResponse busyFlightsResponse) {
		this.responses.add(busyFlightsResponse);
	}

}
