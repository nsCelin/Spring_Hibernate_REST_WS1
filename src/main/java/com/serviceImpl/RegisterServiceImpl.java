package com.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RegisterDAO;
import com.entity.Register;
import com.general.Status;
import com.inputs.RegisterInput;
import com.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

Status registerStatus=new Status();

@Autowired
private RegisterDAO registerDAOImpl;
		
	public Status registerNewUser(RegisterInput registerInput){
		
		List<String> a = new ArrayList();
		
		if 	(checkUserExists(registerInput.getEmail())==null){
			//registerDAOImpl.save(register);
			Register register= new Register();
			register.setEmail(registerInput.getEmail());
			register.setFirstname(registerInput.getFirstName());
			register.setLastname(registerInput.getLastName());
			register.setPassword(registerInput.getPassword());
			register.setPhonenumber(registerInput.getPhoneNumber());
			registerDAOImpl.save(register);
			registerStatus.setStatus(a);
			//registerStatus.setStatus("User Registered Successfully");
			
		}else 
			//registerStatus.setStatus("User is already Registered");
			registerStatus.setStatus(a);
			return registerStatus;
			
		}
	
	public Register checkUserExists(String email){
		
		return registerDAOImpl.checkUserExists(email);
	}
	
}
