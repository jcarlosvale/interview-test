package com.travix.medusa.busyflights.domain.toughjet;

import java.util.ArrayList;
import java.util.List;

public class ToughJetResponseList {

	private List<ToughJetResponse> responses = new ArrayList<ToughJetResponse>();

	public List<ToughJetResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ToughJetResponse> responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "ToughJetResponseList [responses=" + responses + "]";
	}

	public ToughJetResponseList(List<ToughJetResponse> responses) {
		super();
		this.responses = responses;
	}

	public ToughJetResponseList() {
		super();
	}
	
}
