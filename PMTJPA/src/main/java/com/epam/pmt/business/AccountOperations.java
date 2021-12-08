package com.epam.pmt.business;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.AccountDAO;
import com.epam.pmt.dao.MasterProvider;
import com.epam.pmt.dao.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;

@Component
public class AccountOperations {
	@Autowired
	AccountDAO accountDAO;
	@Autowired
	SingletonEntityManagerFactory singletonEntityManagerFactory;
	@Autowired
	MasterProvider masterProvider;
	EntityManagerFactory factory;
	EntityManager manager;
	
	public boolean checkIfGroupExists(String groupname) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = masterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.groupname=?1 and a.master=?2");
		query.setParameter(1, groupname);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		if (!accounts.isEmpty())
			status = true;
		return status;
	}
	
	public boolean createAccount(String url, String username, String password, String groupname) {
		Account account = new Account();
		account.setUrl(url);
		account.setUserName(username);
		account.setPassword(password);
		account.setGroupName(groupname);
		return accountDAO.createAccount(account);

	}
	
	public String readPassword(String url) {
		String password="";
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {
			password = accountDAO.readPassword(accounts.get(0));
		} catch (IndexOutOfBoundsException | IllegalStateException ex) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return password;
	}
	
	public boolean checkUrl(String url) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = masterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		if (!accounts.isEmpty())
			status = true;
		return status;
	}

	
	
	public boolean deleteAccount(String url) {
		return accountDAO.deleteAccount(url);
	}

	public boolean deleteGroup(String groupname) {
		return accountDAO.deleteGroup(groupname);
	}
	

	public boolean updateUsername(String url, String newUsername) {
		return this.accountDAO.updateAccountUsername(url, newUsername);

	}

	public boolean updatePassword(String url, String newPassword) {
		return this.accountDAO.updateAccountPassword(url, newPassword);

	}

	public boolean updateGroupName(String currentGroupname, String newGroupname) {
		return this.accountDAO.modifyGroup(currentGroupname, newGroupname);
	}

	public List<Account> groupDetails(String groupname) {
		return this.accountDAO.displayByGroup(groupname);
	}
}
