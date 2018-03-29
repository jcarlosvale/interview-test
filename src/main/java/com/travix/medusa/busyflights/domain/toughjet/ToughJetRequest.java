package com.travix.medusa.busyflights.domain.toughjet;

/**
 * Created methods equals, hashcode, toString 
 * @author joao
 *
 */
public class ToughJetRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((inboundDate == null) ? 0 : inboundDate.hashCode());
		result = prime * result + numberOfAdults;
		result = prime * result + ((outboundDate == null) ? 0 : outboundDate.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
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
		ToughJetRequest other = (ToughJetRequest) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (inboundDate == null) {
			if (other.inboundDate != null)
				return false;
		} else if (!inboundDate.equals(other.inboundDate))
			return false;
		if (numberOfAdults != other.numberOfAdults)
			return false;
		if (outboundDate == null) {
			if (other.outboundDate != null)
				return false;
		} else if (!outboundDate.equals(other.outboundDate))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ToughJetRequest [from=" + from + ", to=" + to + ", outboundDate=" + outboundDate + ", inboundDate="
				+ inboundDate + ", numberOfAdults=" + numberOfAdults + "]";
	}
    
    
}
