package com.capeelectric.exception;

/**
 * 
 * @author capeelectricsoftware
 *
 */
public class ForgotPasswordException extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	
	public ForgotPasswordException() {}
	public ForgotPasswordException(String message) {
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
