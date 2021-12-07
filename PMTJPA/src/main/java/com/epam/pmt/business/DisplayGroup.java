package com.epam.pmt.business;

import java.util.List;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;
import com.epam.pmt.entities.Account;

public class DisplayGroup {

	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static List<Account> groupDetails(String groupName) {
		return db.displayByGroup(groupName);
	}

	public static boolean checkIfGroupExists(String groupName) {
		boolean status=false;
		status = db.checkIfGroupExists(groupName);
		return status;
	}

}
