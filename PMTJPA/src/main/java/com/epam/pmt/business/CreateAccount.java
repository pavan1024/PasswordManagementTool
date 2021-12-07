package com.epam.pmt.business;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;
import com.epam.pmt.entities.Account;

public class CreateAccount {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static void createAccount(String url, String userName, String password, String groupName) {
		Account account=new Account();
		account.setUrl(url);
		account.setUserName(userName);
		account.setPassword(password);
		account.setGroupName(groupName);
		db.createAccount(account);
		
	}

}
