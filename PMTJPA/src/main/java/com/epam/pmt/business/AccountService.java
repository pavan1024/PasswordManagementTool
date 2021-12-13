package com.epam.pmt.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.AccountDao;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;
import com.epam.pmt.factory.SingletonFactory;

@Component
public class AccountService {
	@Autowired
	AccountDao accountDao;
	@Autowired
	SingletonFactory singletonFactory;
	Master master = MasterProvider.getMaster();
	EntityManagerFactory factory;
	EntityManager manager;
	
	public boolean createAccount(String url, String username, String password, String groupname) {
		Account account = new Account();
		account.setUrl(url);
		account.setUserName(username);
		account.setPassword(password);
		account.setGroupname(groupname);
		return accountDao.createAccount(account);

	}
	
	
	public String readPassword(String url) {
		List<Account> accounts=accountDao.getAll().stream().filter(i->i.getUrl().equals(url)).collect(Collectors.toList());
		return accountDao.readPassword(accounts.get(0));
	}
	
	public boolean checkUrl(String url) {
		boolean status = false;
		factory = singletonFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();	
		Account account=manager.find(Account.class, url);
		try {
			if(account!=null) {
				status =true;
			}
		}catch(IllegalStateException e) {
			e.getStackTrace();
		}finally {
			manager.close();
		}
		return status;
	}

	
	
	public boolean deleteAccount(String url) {
		List<Account> accounts=accountDao.getAll().stream().filter(i->i.getUrl().equals(url)).collect(Collectors.toList());
		return accountDao.deleteAccount(accounts.get(0));
	}
	

	public boolean updateUsername(String url, String newUsername) {
		List<Account> accounts=accountDao.getAll().stream().filter(i->i.getUrl().equals(url)).collect(Collectors.toList());
		accounts.stream().forEach(i->i.setUserName(newUsername));
		master.setAccounts(accounts);
		return this.accountDao.updateAccount(accounts.get(0));

	}

	public boolean updatePassword(String url, String newPassword) {
		List<Account> accounts=accountDao.getAll().stream().filter(i->i.getUrl().equals(url)).collect(Collectors.toList());
		accounts.stream().forEach(i->i.setPassword(newPassword));
		master.setAccounts(accounts);
		return this.accountDao.updateAccount(accounts.get(0));

	}
}
