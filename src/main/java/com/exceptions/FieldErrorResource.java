package com.exceptions;

public class FieldErrorResource {
	
	private String resource;
	private String field;
	private String code;
	private String message;
	
	public void setResource(String resource){
		this.resource = resource;
	}
	
	public String getResource(){
		return resource;
	}
	
	public void setField(String field){
		this.field = field;
	}
	
	public String getField(){
		return field;
	}
	
	public void setCode(String code){
		this.code =code;
	}
	
	public String getCode(){
		return code;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String setMessage(){
		return message;
	}
}
