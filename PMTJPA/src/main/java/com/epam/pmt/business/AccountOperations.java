package com.epam.pmt.business;

import java.util.List;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;
import com.epam.pmt.entities.Account;

public class AccountOperations {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	
	public static void createAccount(String url, String userName, String password, String groupName) {
		Account account=new Account();
		account.setUrl(url);
		account.setUserName(userName);
		account.setPassword(password);
		account.setGroupName(groupName);
		db.createAccount(account);
		
	}
	
	public static boolean deleteAccount(String url) {
		boolean status=false;
		status = db.deleteAccount(url);
		return status;
	}
	
	public static boolean deleteGroup(String groupName) {
		boolean status=false;
		status = db.deleteGroup(groupName);
		return status;
	}
	
	public static List<Account> groupDetails(String groupName) {
		return db.displayByGroup(groupName);
	}

	public static boolean checkIfGroupExists(String groupName) {
		boolean status=false;
		status = db.checkIfGroupExists(groupName);
		return status;
	}
	
	public static String readPassword(String url) {
		return db.readPassword(url);
	}
	
	public static boolean checkUrl(String url) {
		return db.checkIfURLExists(url);
	}

	public static boolean updateUserName(String url, String newUserName) {
		boolean status=false;
		status = db.updateAccountUserName(url, newUserName);
		return status;
		
	}

	public static boolean updatePassword(String url, String newPassword) {
		boolean status=false;
		status = db.updateAccountPassword(url, newPassword);
		return status;
	}
	
	public static boolean updateGroupName(String groupName, String newGroupName) {
		return db.modifyGroup(groupName, newGroupName);
	}
}
