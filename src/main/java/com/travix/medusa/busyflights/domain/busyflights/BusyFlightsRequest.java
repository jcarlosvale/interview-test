package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * Created equals, hashcode, toString and validations of the fields.
 * @author Joao Carlos
 *
 */
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + numberOfPassengers;
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BusyFlightsRequest other = (BusyFlightsRequest) obj;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (numberOfPassengers != other.numberOfPassengers)
			return false;
		if (origin == null) {
			if (other.origin != null)
				return false;
		} else if (!origin.equals(other.origin))
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BusyFlightsRequest [origin=" + origin + ", destination=" + destination + ", departureDate="
				+ departureDate + ", returnDate=" + returnDate + ", numberOfPassengers=" + numberOfPassengers + "]";
	}
}
