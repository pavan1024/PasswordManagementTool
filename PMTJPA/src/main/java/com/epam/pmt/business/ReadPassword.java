package com.epam.pmt.business;

import java.util.List;

import com.epam.pmt.dao.AccountOperations;
import com.epam.pmt.entities.Account;

public class ReadPassword {

	public static String readPassword(String url) {
		return AccountOperations.readPassword(url);
	}

}
