package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class BusyFlightsRequest {

	@Size(min=3,max=3,message="Origin should have 3 characters")
	private String origin;
	
    @Size(min=3,max=3,message="Destination should have 3 characters")
    private String destination;
    
    @Size(min=8,message="Departure data should have at least 8 characters")
    private String departureDate;
    
    @Size(min=8,message="Departure data should have at least 8 characters")
    private String returnDate;
    
    @Max(value=4,message="Number of Passengers should have max 4 passengers")
    @Min(value=1,message="Number of Passengers should have min 1 passenger")
    private int numberOfPassengers;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
}
