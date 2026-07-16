package com.aspir.usermanagement.expcetion;

public class EmailException extends RuntimeException{
	
	public EmailException() {
		super();
	}
	
	public EmailException(String message) {
		super(message);
		
	}
	
	public EmailException(String message , Throwable cause) {
		super(message, cause);
	}

}
