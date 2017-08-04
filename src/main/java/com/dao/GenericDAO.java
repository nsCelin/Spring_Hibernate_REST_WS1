package com.dao;

//public interface  GenericDAO<PK extends Serializable,T> {
public interface  GenericDAO {
	void persist(Object entity);
}
