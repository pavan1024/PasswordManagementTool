package com.epam.pmt.business;

import java.util.List;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;
import com.epam.pmt.entities.Account;

public class ReadPassword {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static String readPassword(String url) {
		return db.readPassword(url);
	}

}
