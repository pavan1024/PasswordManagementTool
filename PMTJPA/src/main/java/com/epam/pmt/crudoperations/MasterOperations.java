package com.epam.pmt.crudoperations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epam.pmt.db.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;

public class MasterOperations {

	static EntityManagerFactory factory;
	static EntityManager manager;
	
	public static boolean createMaster(String userName,String password) {
		boolean status=false;
		factory=SingletonEntityManagerFactory.getEntityManagerFactory();
		manager=factory.createEntityManager();
		Master master=new Master();
		master.setUsername(userName);
		master.setPassword(password);
		List<Account> accounts=new ArrayList<>();
		master.setAccounts(accounts);
		
		try {
			manager.getTransaction().begin();
			manager.merge(master);
			manager.getTransaction().commit();
			status = true;
		} catch (Exception e) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		
		return status;
		
	}
	
	public static boolean checkIfMasterExists(String userName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		try {
		Master account = manager.find(Master.class, userName);
			if (account.getUsername().equals(userName)) {
				status = true;
			}
		}
		catch(Exception e) {
			System.out.println("Register an Account before Login");
		}
		return status;
	}
	
}
