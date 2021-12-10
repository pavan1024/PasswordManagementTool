package com.epam.pmt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.MasterProvider;
import com.epam.pmt.business.SingletonEntityManagerFactory;
import com.epam.pmt.entities.*;

@Component
@Primary
public class AccountDaoImpl implements AccountDao{
	EntityManagerFactory factory;
	EntityManager manager;
	@Autowired
	SingletonEntityManagerFactory singletonEntityManagerFactory;

	String jpqlQuery= "select a from Account a where a.url=?1 and a.master=?2";
	@Override
	public boolean createAccount(Account account) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		List<Account> list = manager.find(Master.class, MasterProvider.getMaster().getUsername()).getAccounts();
		Master master = MasterProvider.getMaster();
		list.add(account);
		master.setAccounts(list);
		try {
			manager.getTransaction().begin();
			manager.merge(master);
			manager.getTransaction().commit();
			status = true;
		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return status;

	}
	


	@Override
	public boolean deleteAccount(String url) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, url);
		query.setParameter(2, MasterProvider.getMaster());
		List<Account> accounts = query.getResultList();
		Account account = accounts.get(0);
		try {
			if (account != null) {
				manager.getTransaction().begin();
				manager.remove(account);
				manager.getTransaction().commit();
				status = true;
			}
		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();

		} finally {

			manager.close();
		}
		return status;

	}

	@Override
	public boolean updateAccountUsername(String url, String newUsername) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {

			if (!accounts.isEmpty()) {
				accounts.stream().forEach(i -> i.setUserName(newUsername));
				master.setAccounts(accounts);
				manager.getTransaction().begin();
				manager.merge(master);
				manager.getTransaction().commit();
				status = true;
			}
		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return status;
	}
	
	@Override
	public boolean updateAccountPassword(String url, String newPassword) {
		boolean status = false;
		factory = singletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery(jpqlQuery);
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {

			if (!accounts.isEmpty()) {
				accounts.stream().forEach(i -> i.setPassword(newPassword));
				master.setAccounts(accounts);
				manager.getTransaction().begin();
				manager.merge(master);
				manager.getTransaction().commit();
				status = true;
			}
		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return status;
	}
	@Override
	public String readPassword(Account account) {
		return account.getPassword();
	}


}
