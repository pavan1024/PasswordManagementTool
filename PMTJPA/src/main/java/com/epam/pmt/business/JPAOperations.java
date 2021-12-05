package com.epam.pmt.business;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.JPAImpl;
import com.epam.pmt.db.MasterProvider;
import com.epam.pmt.db.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;

public class JPAOperations {
	EntityManagerFactory factory;
	EntityManager manager;
	JPAImpl jpa=new JPAImpl();
	public boolean createAccount(String url,String userName,String password,String groupName) {
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		List<Account> list = manager.find(Master.class, MasterProvider.getMaster().getUsername()).getAccounts();
		Master master = MasterProvider.getMaster();
		Account account=new Account();
		account.setUrl(url);
		account.setUserName(userName);
		account.setPassword(password);
		account.setGroupName(groupName);
		list.add(account);
		master.setAccounts(list);
		jpa.createAccount(account);
		return true;
	}
	public String readPassword(String url) {
		
		return jpa.readPassword(url);
	}

	public List<Account> displayByGroup(String groupName) {
		return jpa.displayByGroup(groupName);
	}

	public boolean deleteAccount(String url) {
		return jpa.deleteAccount(url);
	}

	public boolean updateAccountUserName(String url,String newUserName) {
		return jpa.updateAccountUserName(url, newUserName);
	}

	public boolean updateAccountPassword(String url,String newPassword) {
		return jpa.updateAccountPassword(url, newPassword);
	}
	public boolean modifyGroup(String groupName, String newGroupName) {
		return jpa.modifyGroup(groupName, newGroupName);
	}

	public boolean deleteGroup(String groupName) {
		return jpa.deleteGroup(groupName);
	}

	public boolean checkIfURLExists(String url) {
		return jpa.checkIfGroupExists(url);
	}

	public boolean checkIfGroupExists(String groupName) {
		return jpa.checkIfGroupExists(groupName);
	}
	
}
