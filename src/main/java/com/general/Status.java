package com.general;

import java.util.List;

public class Status {
	
	private List<String> status;
	
	public Status(){
		
	}
	
	public Status(List<String> statuses){
		this.status = statuses;
	}
	
	
	public List<String> getStatus(){
	 	return status;
	}
	
	public void setStatus(List<String> status){
		this.status =status;
	}
}
