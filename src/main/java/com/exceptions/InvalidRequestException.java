package com.exceptions;

import org.springframework.validation.Errors;

public class InvalidRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L; // check on its value
	private Errors errors;

	public InvalidRequestException(String message, Errors errors){
			super(message); // Only then in exception (e) this value can be read, else it will be null. As e refers to super class
			this.errors = errors;
	}
	
	public Errors getErrors(){
		return errors;
	}
}
