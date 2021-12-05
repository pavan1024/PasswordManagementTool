package com.epam.pmt.business;

import com.epam.pmt.crudoperations.AccountOperations;

public class UpdateAccount {

	public static boolean checkUrl(String url) {
		return AccountOperations.checkIfURLExists(url);
	}

	public static boolean updateUserName(String url, String newUserName) {
		boolean status=false;
		status = AccountOperations.updateAccountUsername(url, newUserName);
		return status;
		
	}

	public static boolean updatePassword(String url, String newPassword) {
		boolean status=false;
		status = AccountOperations.updateAccountPassword(url, newPassword);
		return status;
	}

}
