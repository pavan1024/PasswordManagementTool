package com.epam.pmt.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;
@Component
public class SingletonEntityManagerFactory {
	EntityManagerFactory entityManagerFactory;

	private SingletonEntityManagerFactory() {
	}

	public EntityManagerFactory getEntityManagerFactory() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("pmt-database");
		}
		return entityManagerFactory;
	}

}
