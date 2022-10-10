package com.capeelectric.exception;

public class FinalReportException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String message;

	public FinalReportException() {
	}

	public FinalReportException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}