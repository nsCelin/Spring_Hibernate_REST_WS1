package com.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LoginUserDAO;
import com.inputs.LoginUser;
import com.entity.Register;
import com.exceptions.CustomerNotFoundException;
import com.general.Session;
import com.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginUserDAO loginUserDAOImpl;
	
	byte[] sessionIdentifier;
	
	@Override
	public Session processInput(LoginUser loginUser) throws CustomerNotFoundException{
		Session aSession = null;
		
		Register registeredUserfromDB =loginUserDAOImpl.retrieveLoginUserDetails(loginUser.getEmail()); 
		
		if (registeredUserfromDB==null)
			throw new CustomerNotFoundException("User not found");
		
		if ((registeredUserfromDB.getEmail()!=""&&registeredUserfromDB.getEmail().equals(loginUser.getEmail()))&&
				(registeredUserfromDB.getEmail()!=""&&registeredUserfromDB.getPassword().equals(loginUser.getPassword())))
			aSession = new Session();
		
		if(aSession!=null)
		saveSession(aSession.getSessionID());
		
		return aSession;
	}
	
	public void saveSession(byte[] sessionID){
		loginUserDAOImpl.save();
		sessionIdentifier = sessionID;
		System.out.println("sessionID"+ sessionID);
	}
	
	public byte[] getSessionIdentifier(){
		return sessionIdentifier;
	}
	}

