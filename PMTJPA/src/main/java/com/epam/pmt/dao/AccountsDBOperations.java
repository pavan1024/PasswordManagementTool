package com.epam.pmt.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.epam.pmt.entities.Account;

public interface AccountsDBOperations {
	public boolean createAccount(Account account);
	public String readPassword(String url);
	public List<Account> displayByGroup(String groupName);
	public boolean deleteAccount(String url);
	public boolean updateAccountUserName(String url,String newUserName);
	public boolean updateAccountPassword(String url,String newPassword);
	public boolean modifyGroup(String groupName,String newGroupName);
	public boolean deleteGroup(String groupName);
	public boolean checkIfURLExists(String url);
	public boolean checkIfGroupExists(String groupName);
	
}
