package com.travix.medusa.busyflights.domain.toughjet;

/**
 * Created methods equals, hashcode, toString and constructors 
 * @author joao
 *
 */
public class ToughJetResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private String outboundDateTime;
    private String inboundDateTime;
    
    public ToughJetResponse() {
		super();
	}

	public ToughJetResponse(String carrier, double basePrice, double tax, double discount, String departureAirportName,
			String arrivalAirportName, String outboundDateTime, String inboundDateTime) {
		super();
		this.carrier = carrier;
		this.basePrice = basePrice;
		this.tax = tax;
		this.discount = discount;
		this.departureAirportName = departureAirportName;
		this.arrivalAirportName = arrivalAirportName;
		this.outboundDateTime = outboundDateTime;
		this.inboundDateTime = inboundDateTime;
	}

	public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalAirportName == null) ? 0 : arrivalAirportName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(basePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
		result = prime * result + ((departureAirportName == null) ? 0 : departureAirportName.hashCode());
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((inboundDateTime == null) ? 0 : inboundDateTime.hashCode());
		result = prime * result + ((outboundDateTime == null) ? 0 : outboundDateTime.hashCode());
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ToughJetResponse other = (ToughJetResponse) obj;
		if (arrivalAirportName == null) {
			if (other.arrivalAirportName != null)
				return false;
		} else if (!arrivalAirportName.equals(other.arrivalAirportName))
			return false;
		if (Double.doubleToLongBits(basePrice) != Double.doubleToLongBits(other.basePrice))
			return false;
		if (carrier == null) {
			if (other.carrier != null)
				return false;
		} else if (!carrier.equals(other.carrier))
			return false;
		if (departureAirportName == null) {
			if (other.departureAirportName != null)
				return false;
		} else if (!departureAirportName.equals(other.departureAirportName))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (inboundDateTime == null) {
			if (other.inboundDateTime != null)
				return false;
		} else if (!inboundDateTime.equals(other.inboundDateTime))
			return false;
		if (outboundDateTime == null) {
			if (other.outboundDateTime != null)
				return false;
		} else if (!outboundDateTime.equals(other.outboundDateTime))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToughJetResponse [carrier=" + carrier + ", basePrice=" + basePrice + ", tax=" + tax + ", discount="
				+ discount + ", departureAirportName=" + departureAirportName + ", arrivalAirportName="
				+ arrivalAirportName + ", outboundDateTime=" + outboundDateTime + ", inboundDateTime=" + inboundDateTime
				+ "]";
	}
    
    
}
