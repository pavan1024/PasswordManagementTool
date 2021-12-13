package com.epam.pmt.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.MasterDao;
import com.epam.pmt.entities.Master;

@Component
public class MasterOperations {
	@Autowired
	MasterDao masterDao;
	@Autowired
	SingletonFactory singletonFactory;
	@Autowired
	Validation validation;
	EntityManagerFactory factory;
	EntityManager manager;

	public boolean createMaster(String username, String password) {
		boolean status = false;
		Master master = new Master();
		master.setUsername(username);
		master.setPassword(password);
		status = masterDao.createMaster(master);
		return status;

	}

	public boolean checkIfMasterExists(String username) {
		boolean status = false;
		factory = singletonFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		try {
			Master account = manager.find(Master.class, username);
			if (account.getUsername().equals(username)) {
				status = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return status;
	}

	public boolean login(String username, String password) {
		boolean status = false;
		factory = singletonFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		if (password.equals(manager.find(Master.class, username).getPassword())) {
			MasterProvider.setMaster(username, password);
			status = true;
		}
		return status;
	}

	public boolean registerAccount(String username, String password) {
		boolean status = false;
		if (validation.isValidPassword(password)) {
			this.createMaster(username, password);
			status = true;
		}
		return status;
	}

}
