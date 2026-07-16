package com.aspir.usermanagement.expcetion;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(){
		super();
	}
	
	public UserNotFoundException(String massage) {
		super(massage);
	}
	public UserNotFoundException(String massage , Throwable cause) {
		
		super(massage,cause);
	}
}
