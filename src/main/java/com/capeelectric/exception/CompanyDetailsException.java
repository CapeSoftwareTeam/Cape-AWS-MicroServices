package com.capeelectric.exception;

/**
 * 
 * @author capeelectricsoftware
 *
 */
public class CompanyDetailsException  extends Throwable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;

	public CompanyDetailsException() {
		
	}
	public CompanyDetailsException(String message) {
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
