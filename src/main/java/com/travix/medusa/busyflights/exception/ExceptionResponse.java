package com.travix.medusa.busyflights.exception;

import java.util.Date;

/**
 * New Class
 * An Exception Response Bean to represent exceptions 
 * @author joao
 *
 */
public class ExceptionResponse {
	
	private Date timestamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}
