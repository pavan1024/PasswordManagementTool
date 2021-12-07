package com.epam.pmt.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.epam.pmt.entities.*;

@Component
@Primary
public class AccountsDBOperationsImpl implements AccountsDBOperations {
	EntityManagerFactory factory;
	EntityManager manager;

	public boolean createAccount(Account account) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
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

	public String readPassword(String url) {
		String password = "";
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {
			Account account = accounts.get(0);
			password = account.getPassword();
		} catch (IndexOutOfBoundsException | IllegalStateException ex) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return password;
	}

	public List<Account> displayByGroup(String groupName) {
		List<Account> groupAccounts = null;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		List<Account> accounts = manager.find(Master.class, master.getUsername()).getAccounts().stream()
				.filter(i -> i.getGroupName().equals(groupName)).collect(Collectors.toList());

		try {
			Query query = manager.createQuery("select u from Account u where u.groupName=?1");
			query.setParameter(1, groupName);
			groupAccounts = query.getResultList();
		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return groupAccounts;
	}

	public boolean deleteAccount(String url) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
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
	public boolean updateAccountUserName(String url, String newUserName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1, url);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {

			if (!accounts.isEmpty()) {
				accounts.stream().forEach(i -> i.setUserName(newUserName));
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

	public boolean updateAccountPassword(String url, String newPassword) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
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

	public boolean checkIfURLExists(String url) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Account account = manager.find(Account.class, url);
		if (account.getUrl().equals(url)) {
			status = true;
		}
		return status;

	}

	@Transactional
	public boolean checkIfGroupExists(String groupName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1, groupName);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		if (!accounts.isEmpty()) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean modifyGroup(String groupName, String newGroupName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1, groupName);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();

		try {
			if (!accounts.isEmpty()) {
				accounts.stream().forEach(i -> i.setGroupName(newGroupName));
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

	public boolean deleteGroup(String groupName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query = manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1, groupName);
		query.setParameter(2, master);
		List<Account> accounts = query.getResultList();
		try {
			if (!accounts.isEmpty()) {
				for (int i = 0; i < accounts.size(); i++) {
					manager.getTransaction().begin();
					manager.remove(accounts.get(i));
					manager.getTransaction().commit();
				}
				status = true;
			}

		} catch (IllegalStateException e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}

		return status;

	}

}
