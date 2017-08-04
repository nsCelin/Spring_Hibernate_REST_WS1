package com.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.general.Status;
import com.inputs.Email;
import com.inputs.LoginUser;
import com.inputs.RegisterInput;
import com.exceptions.InvalidRequestException;
import com.general.Session;
import com.service.LoginService;
import com.service.RegisterService;
import com.service.ResetPassword;

@RestController
public class Controller {
	
	@Autowired
	private LoginService loginServiceImpl;
	
	@Autowired
	private RegisterService registerServiceImpl;
	
	@Autowired
	private ResetPassword resetPasswordImpl;
	
	Status status;
	
	Session session;
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
		
	/*Seesion ID is returned*/
	@RequestMapping(value="/login", method=RequestMethod.POST,headers="Accept=application/json")
	public Session loginFunction(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) throws InvalidRequestException{	
		logger.debug("Entering the loginFunction method. The LoginUser object is" ,loginUser.toString());	
		
		if(bindingResult.hasErrors())
			throw new InvalidRequestException("Invalid", bindingResult);
		
		session =loginServiceImpl.processInput(loginUser);			
		return session;
	}
		
	@RequestMapping(value="/register", method=RequestMethod.POST,headers="Accept=application/json")
	/*public Status registerForm(@Valid @RequestBody Register register){*/
	public Status registerForm(@Valid @RequestBody RegisterInput registerInput, BindingResult result){
		logger.debug("Entering the Register method");
		//comparing two arrays
		//if(Arrays.equals(user.getSessionID(),loginService.getSessionIdentifier()))
		/*if(result.hasErrors()){
			status = new Status();
			  status.setStatus("Validation Failed");
		}
			
		else*/
		status = registerServiceImpl.registerNewUser(registerInput);	
		
		return status;
	}
	
	//This method can take a single parameter Email
	@RequestMapping(value="/reset", method=RequestMethod.POST,headers="Accept=application/json")
	public Status resetPassword(@RequestBody Email email){
					status= resetPasswordImpl.resetPassword(email);
			
		return status;
	}
		
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	//public void resetPasswordPage(@RequestBody User user){
		public String resetPasswordPage(@RequestParam(required = true, value = "inputPassword") String newPassword, 
				  @RequestParam(required = true, value = "inputPassword1") String confirmNewPassword,
				  @RequestParam(required = true, value = "token") String token){
		resetPasswordImpl.updateForgetPassword(newPassword,confirmNewPassword,token);
		return "Registered Successfully";
	}	

}
