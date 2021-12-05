package com.epam.pmt.business;

import com.epam.pmt.dao.AccountOperations;

public class DeleteAccount {

	public static boolean deleteAccount(String url) {
		boolean status=false;
		status = AccountOperations.deleteAccount(url);
		return status;
	}

}
