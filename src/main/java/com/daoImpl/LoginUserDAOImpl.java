package com.daoImpl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Register;
import com.daoImpl.GenericDAOImpl;
import com.dao.LoginUserDAO;

@Repository
@Transactional 
public class LoginUserDAOImpl extends GenericDAOImpl implements LoginUserDAO{
	
	public void save(){
		System.out.println("save");
	}
	
	public Register retrieveLoginUserDetails(String email){
		return getSession().get(Register.class, email);
	}
}
