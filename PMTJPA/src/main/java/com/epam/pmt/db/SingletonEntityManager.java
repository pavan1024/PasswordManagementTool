package com.epam.pmt.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class SingletonEntityManager {
	static EntityManager entityManager;
	private SingletonEntityManager() {
		
	}
	public static EntityManager getEntityManager() {
		if(entityManager==null){
			entityManager=SingletonEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	}
	return entityManager;
	}
}
