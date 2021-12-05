package com.epam.pmt.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.epam.pmt.db.MasterProvider;
import com.epam.pmt.db.SingletonEntityManagerFactory;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;

public class JPAImpl implements AccountsDBOperations {
	EntityManagerFactory factory;
	EntityManager manager;
	@Override
	public boolean createAccount(Account account) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		List<Account> list = manager.find(Master.class, MasterProvider.getMaster().getUsername()).getAccounts();
		list.add(account);
		master.setAccounts(list);
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

	@Transactional
	public String readPassword(String url) {
		String password="";
		factory=SingletonEntityManagerFactory.getEntityManagerFactory();
		manager=factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1,url);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();
		try {
		Account account=accounts.get(0);
		password=account.getPassword();
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		return password;
	}
	
	@Transactional
	public List<Account> displayByGroup(String groupName) {
		List<Account> groupAccounts = null;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		List<Account> accounts = manager.find(Master.class, master.getUsername()).getAccounts().stream()
				.filter(i -> i.getGroupName().equals(groupName)).collect(Collectors.toList());

		try {
//			accounts.stream().forEach(i -> System.out.println("URL : " + i.getUrl() + ", GroupName : "
//					+ i.getGroupName() + ", Username : " + i.getUserName() + ", Password : " + i.getPassword()));
			
			Query query=manager.createQuery("select u from Account u where u.groupName=?1");
			query.setParameter(1, groupName);
			groupAccounts=query.getResultList();
		} catch (Exception e) {
			if (manager != null) {
				manager.getTransaction().rollback();
			}
		} finally {
			if (manager != null) {
				manager.close();
			}
		}
		return groupAccounts;
	}
	
	
	@Transactional
	public boolean deleteAccount(String url) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Query query=manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1, url);
		query.setParameter(2, MasterProvider.getMaster());
		List<Account> accounts= query.getResultList();
		Account account=accounts.get(0);
		try {
			if (account != null) {
				manager.getTransaction().begin();
				manager.remove(account);
				manager.getTransaction().commit();
				status = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + status);
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

	
	
	
	@Transactional
	public boolean updateAccountPassword(String url, String newPassword) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1,url);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();
		try {
			accounts.stream().forEach(i->i.setPassword(newPassword));
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
	@Transactional
	public boolean checkIfURLExists(String url) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Account account = manager.find(Account.class, url);
		if(account.getUrl().equals(url)){
			status =true;
		}
		return status;

	}
	
	@Transactional
	public boolean checkIfGroupExists(String groupName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master = MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1, groupName);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();	
		if(accounts.size()>0){
			status =true;
		}
		return status;
	}


	
	@Transactional
	public boolean deleteGroup(String groupName) {
		boolean status=false;
		factory=SingletonEntityManagerFactory.getEntityManagerFactory();
		manager=factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1, groupName);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();
		try {
			if(accounts.size()>0) {
			for(int i=0;i<accounts.size();i++) {
				manager.getTransaction().begin();
				manager.remove(accounts.get(i));
				manager.getTransaction().commit();
				}
			status=true;
			}
			
			
		}
		catch(Exception e) {
			if(manager!=null) {
				manager.getTransaction().rollback();
			}
		}
		finally {
			if (manager != null) {
				manager.close();
			}
		}
		
		return status;
		
	}

	@Override
	public boolean updateAccountUserName(String url, String newUserName) {
		boolean status = false;
		factory = SingletonEntityManagerFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.url=?1 and a.master=?2");
		query.setParameter(1,url);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();
		try {
			accounts.stream().forEach(i->i.setUserName(newUserName));
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

	@Override
	public boolean modifyGroup(String groupName, String newGroupName) {
		boolean status =false;
		factory=SingletonEntityManagerFactory.getEntityManagerFactory();
		manager=factory.createEntityManager();
		Master master=MasterProvider.getMaster();
		Query query=manager.createQuery("select a from Account a where a.groupName=?1 and a.master=?2");
		query.setParameter(1,groupName);
		query.setParameter(2, master);
		List<Account> accounts=query.getResultList();
		
		
		try {
			accounts.stream().forEach(i->i.setGroupName(newGroupName));
			manager.getTransaction().begin();
			manager.merge(master);
			manager.getTransaction().commit();			
			status = true;
		} catch (IllegalStateException e) {
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




}
