package com.epam.pmt.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonEntityManagerFactory {
	static EntityManagerFactory entityManagerFactory;

	private SingletonEntityManagerFactory() {

	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("pmt-database");
		}
		return entityManagerFactory;
	}

}
