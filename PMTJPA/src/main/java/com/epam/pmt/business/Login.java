package com.epam.pmt.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.stereotype.Component;

import com.epam.pmt.dao.MasterOperations;
import com.epam.pmt.dao.MasterProvider;
import com.epam.pmt.dao.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Master;

@Component
public class Login {
	static EntityManagerFactory factory;
	static EntityManager manager;

	public boolean login(String userName, String password) {
		boolean found = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		if (password.equals(manager.find(Master.class, userName).getPassword())) {
			MasterProvider.setMaster(userName, password);
			found = true;
		}
		return found;
	}

	public boolean checkIfUserNameExists(String userName) {
		return MasterOperations.checkIfMasterExists(userName);
	}

}
