package com.capeelectric.exception;
/**
 * 
 * @author capeelectricsoftware
 *
 */
public class ApplicationTypesException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ApplicationTypesException() {

	}
	public ApplicationTypesException(String message) {
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




