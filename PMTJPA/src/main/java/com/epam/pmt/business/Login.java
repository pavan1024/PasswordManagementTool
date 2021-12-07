package com.epam.pmt.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epam.pmt.dao.MasterOperations;
import com.epam.pmt.db.MasterProvider;
import com.epam.pmt.db.SingletonEntityManager;
import com.epam.pmt.db.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Master;

public class Login {
	static EntityManagerFactory factory;
	static EntityManager manager;
	public static boolean login(String userName, String password) {
		boolean found = false;
		factory=SingletonEntityManagerFactory.getEntityManagerFactory();
		manager=factory.createEntityManager();
			if(password.equals(manager.find(Master.class, userName).getPassword())) {
			MasterProvider.setMaster(userName,password);
			found = true;
			}
		return found;
	}
	public static boolean checkIfUserNameExists(String userName) {
		return MasterOperations.checkIfMasterExists(userName);
	}

}
