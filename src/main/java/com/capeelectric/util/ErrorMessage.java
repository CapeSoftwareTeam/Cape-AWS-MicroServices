package com.capeelectric.util;

public class ErrorMessage {

	private String message;
	private String details;
	private String statusCode;
	public ErrorMessage() {
		super();
	}
	
	
	public ErrorMessage(String message, String details, String statusCode) {
		super();
		this.message = message;
		this.details = details;
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	
	
}
