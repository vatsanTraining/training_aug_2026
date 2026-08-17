package com.example.demo.exceptions;

// unchecked exception
//public class InvalidCodeException extends RuntimeException {
//
//}


// checked Exception
public class InvalidCodeException extends Exception {

	
	private static final long serialVersionUID = 1L;
	
	private String message;
	private String code;
	public InvalidCodeException(String message, String code) {
		super();
		this.message = message;
		this.code = code;
	}
	@Override
	public String getMessage() {

		
		return this.code + this.message;
		
	}
	
	
	
	
	
}
