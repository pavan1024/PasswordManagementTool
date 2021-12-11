package com.epam.pmt.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.MasterOperations;
import com.epam.pmt.entities.Master;

@Component
public class Login {
	@Autowired
	MasterOperations masterOperations;
	@Autowired
	SingletonEntityManagerFactory singletonEntityManagerFactory;
	EntityManagerFactory factory;
	EntityManager manager;

	public boolean login(String userName, String password) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		if (password.equals(manager.find(Master.class, userName).getPassword())) {
			MasterProvider.setMaster(userName, password);
			status = true;
		}
		return status;
	}

	public boolean checkIfUserNameExists(String userName) {
		return masterOperations.checkIfMasterExists(userName);
	}

}
