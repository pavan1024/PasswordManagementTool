package com.epam.pmt.business;

import com.epam.pmt.crudoperations.AccountOperations;
import com.epam.pmt.entities.Account;

public class CreateAccount {

	public static void createAccount(String url, String userName, String password, String groupName) {
		Account account=new Account();
		account.setUrl(url);
		account.setUserName(userName);
		account.setPassword(password);
		account.setGroupName(groupName);
		AccountOperations.createAccount(account);
		
	}

}
