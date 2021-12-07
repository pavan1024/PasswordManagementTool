package com.epam.pmt.business;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;

public class DeleteAccount {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static boolean deleteAccount(String url) {
		boolean status=false;
		status = db.deleteAccount(url);
		return status;
	}

}
