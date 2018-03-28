package com.travix.medusa.busyflights.domain.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class BusyFlightsRequestDTO {

    @Size(min=3,max=3,message="Origin should have 3 characters")
	private String origin;
    
    @Size(min=3,max=3,message="Destination should have 3 characters")
    private String destination;
    
    @Future
    private LocalDate departureDate;
    
    @Future
    private LocalDate returnDate;
    
    @Size(min=1,max=4,message="Number of Passengers should have between 1-4 passengers")
    private int numberOfPassengers;
	
	public BusyFlightsRequestDTO(BusyFlightsRequest busyFlightsRequest) {
		this.origin = busyFlightsRequest.getOrigin();
		this.destination = busyFlightsRequest.getDestination();
		this.setDepartureDate(busyFlightsRequest.getDepartureDate());
		this.setReturnDate(busyFlightsRequest.getReturnDate());
		this.numberOfPassengers = busyFlightsRequest.getNumberOfPassengers();
	}

	private void setReturnDate(String returnDate) {
		this.returnDate = LocalDate.parse(returnDate, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	private void setDepartureDate(String departureDate) {
		this.departureDate = LocalDate.parse(departureDate, DateTimeFormatter.ISO_LOCAL_DATE);
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	@Override
	public String toString() {
		return "BusyFlightsRequestDTO [origin=" + origin + ", destination=" + destination + ", departureDate="
				+ departureDate + ", returnDate=" + returnDate + ", numberOfPassengers=" + numberOfPassengers + "]";
	}
}
