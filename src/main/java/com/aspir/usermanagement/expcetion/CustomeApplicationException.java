package com.aspir.usermanagement.expcetion;

public class CustomeApplicationException extends RuntimeException{

	public CustomeApplicationException() {
		
		super();
		
	}
	public CustomeApplicationException(String message) {
		
		super(message);
	}
	public CustomeApplicationException(String message, Throwable cause) {
		
		super(message,cause);
	
	}
	
	
}
