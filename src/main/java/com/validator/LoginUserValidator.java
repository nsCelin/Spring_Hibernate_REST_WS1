package com.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.inputs.LoginUser;

//@Component
public class LoginUserValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz){
		return LoginUser.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors e){
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "email", "email.mandatory", "Please provide a valid username");	
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "password", "password.mandatory", "Please provide a valid password");
	}
}
