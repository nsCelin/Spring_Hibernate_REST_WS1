package com.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable,T>{

	private final Class<T> persistentClass; 
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	protected void persist(T entity){
		getSession().persist(entity);
	}
}
