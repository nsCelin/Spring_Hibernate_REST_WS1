package com.exceptions;

public class CustomerNotFoundException extends RuntimeException{
	
	public CustomerNotFoundException(){		
	}
	
	public CustomerNotFoundException(String message){
		super(message);
	}
	
}
