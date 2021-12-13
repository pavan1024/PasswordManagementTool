package com.epam.pmt.business;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.GroupDao;
import com.epam.pmt.entities.Account;
import com.epam.pmt.entities.Master;
@Component
public class GroupService {
	@Autowired
	GroupDao groupDao;
	@Autowired
	SingletonFactory singletonFactory;
	EntityManagerFactory factory;
	EntityManager manager;

	Master master = MasterProvider.getMaster();
	public boolean checkIfGroupExists(String groupname) {		
		boolean status=false;
		factory = singletonFactory.getEntityManagerFactory();
		manager = factory.createEntityManager();
		List<Account> accounts = manager.find(Master.class, master.getUsername()).getAccounts();
		try {
		List<Account> groupAccounts=accounts.stream().filter(i->i.getGroupname().equals(groupname)).collect(Collectors.toList());
		if(!groupAccounts.isEmpty())
			status=true;
		}catch(IllegalStateException e) {
			e.getStackTrace();
		}finally {
			manager.close();
		}
		
		return status;
		
	}
	public boolean updateGroupName(String currentGroupname, String newGroupname) {
		return groupDao.modifyGroup(currentGroupname, newGroupname);
	}

	public List<Account> groupDetails(String groupname) {
		return groupDao.displayByGroup(groupname);
	}
	
	public boolean deleteGroup(String groupname) {
		return groupDao.deleteGroup(groupname);
	}
}
