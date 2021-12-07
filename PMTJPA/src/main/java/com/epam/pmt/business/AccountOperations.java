package com.epam.pmt.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;
import com.epam.pmt.entities.Account;

@Component
public class AccountOperations {
	@Autowired
	AccountsDBOperations accountsDBOperations;

	public void createAccount(String url, String userName, String password, String groupName) {
		Account account = new Account();
		account.setUrl(url);
		account.setUserName(userName);
		account.setPassword(password);
		account.setGroupName(groupName);
		accountsDBOperations.createAccount(account);

	}

	public boolean deleteAccount(String url) {
		boolean status = false;
		status = this.accountsDBOperations.deleteAccount(url);
		return status;
	}

	public boolean deleteGroup(String groupName) {
		boolean status = false;
		status = this.accountsDBOperations.deleteGroup(groupName);
		return status;
	}

	public List<Account> groupDetails(String groupName) {
		return this.accountsDBOperations.displayByGroup(groupName);
	}

	public boolean checkIfGroupExists(String groupName) {
		boolean status = false;
		status = this.accountsDBOperations.checkIfGroupExists(groupName);
		return status;
	}

	public String readPassword(String url) {
		return this.accountsDBOperations.readPassword(url);
	}

	public boolean checkUrl(String url) {
		return this.accountsDBOperations.checkIfURLExists(url);
	}

	public boolean updateUserName(String url, String newUserName) {
		boolean status = false;
		status = this.accountsDBOperations.updateAccountUserName(url, newUserName);
		return status;

	}

	public boolean updatePassword(String url, String newPassword) {
		boolean status = false;
		status = this.accountsDBOperations.updateAccountPassword(url, newPassword);
		return status;
	}

	public boolean updateGroupName(String groupName, String newGroupName) {
		return this.accountsDBOperations.modifyGroup(groupName, newGroupName);
	}
}
