package com.exceptions;

import java.util.List;

public class ErrorResource {
	
	private String code;
	private String message;
	List<FieldErrorResource> fieldErrors;
	
	public ErrorResource(){
		
	}
	
	public ErrorResource(String code,String message){
		this.code = code;
		this.message = message;
	}
	
	public List<FieldErrorResource> getFieldErrors(){
		return fieldErrors;
	}
	
	public void setFieldErrors(List<FieldErrorResource> fieldErrors){
		this.fieldErrors = fieldErrors;
	}
	
	public void setCode(String code){
		this.code=code;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	
	public String getMessage(){
		return message;
	}
}
