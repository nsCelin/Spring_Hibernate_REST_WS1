package com.daoImpl;

import java.util.List;

import org.hibernate.query.Query;
/*import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ResetPasswordDAO;
import com.entity.Register;

@Repository
@Transactional
public class ResetPasswordDAOImpl extends GenericDAOImpl implements ResetPasswordDAO {

	public Register checkUserExists(String email){
		return getSession().get(Register.class, email);
	}
	
	public void updatePassword(String newPassword, String email){
		getSession().get(Register.class, email).setPassword(newPassword);
	}
	
	public void saveToken(String hashcode, String email){
		getSession().get(Register.class, email).setResettoken(hashcode);
	}
	
	public String retrieveEmail(String token){
		//Register reg= getSession().get(Register.class, token);
		Query query = getSession().createQuery("from Register where resettoken = :token");
		query.setParameter("token", token);
		List<Register> list= query.list(); 
		
		Register regis =null;
		if(!list.isEmpty() && list.size()>0)
			regis =list.get(0);
		return regis.getEmail();
	}
}
