package com.controller;


import com.exceptions.CustomerNotFoundException;
import com.exceptions.InvalidRequestException;
import com.general.Status;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;



@ControllerAdvice
public class ExceptionHandlerController {
	
	private static final Logger logger= LoggerFactory.getLogger(ExceptionHandlerController.class);
	
	@ExceptionHandler({InvalidRequestException.class})
	@ResponseBody
	protected  Status handleInvalidRequest(RuntimeException e, WebRequest request){
		InvalidRequestException invalidRequestException = (InvalidRequestException)e;
		List<String> errorMessages = new ArrayList();
				
		List<FieldError> fieldErrors =invalidRequestException.getErrors().getFieldErrors();
		for(FieldError fieldError :fieldErrors){
			logger.debug("ObjectName :" +fieldError.getObjectName() +"Field :" +fieldError.getField() +"Code  :"+fieldError.getCode()+
					"DefaultMessage :"+fieldError.getDefaultMessage());
			errorMessages.add(fieldError.getDefaultMessage());
		}
		
		return null;
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	protected Status handleUserNotFoundException(CustomerNotFoundException e){
		logger.debug("User is not found in DB exception. The exception is" +e.getMessage());
		return null;
	}
}
