package com.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.RegisterDAO;
import com.entity.Register;


@Repository
@Transactional 
public class RegisterDAOImpl extends GenericDAOImpl implements RegisterDAO {

@Autowired
private SessionFactory sessionFactory;
		

	/*public void save(Register register){
		
		//sessionFactory.getCurrentSession().persist(register);
		Session session= sessionFactory.openSession();
		Transaction transaction=null;
		try{
	
			transaction =session.beginTransaction();
			session.persist(register);
			transaction.commit();
			
		}catch(Exception e){
			
			if(transaction!=null)
				transaction.rollback();
			throw e;
			
		}finally{
			
		sessionFactory.close();
		}
		
	}*/

	public void save(Register register){
		persist(register);
	}
	
	public Register checkUserExists(String email){
		return getSession().get(Register.class, email);
	}
	
}
