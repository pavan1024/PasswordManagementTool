package com.epam.pmt.business;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;

public class UpdateAccount {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
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

}
