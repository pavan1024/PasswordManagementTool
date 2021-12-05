package com.epam.pmt.business;

import java.util.List;

import com.epam.pmt.crudoperations.AccountOperations;
import com.epam.pmt.entities.Account;

public class DisplayGroup {


	public static List<Account> groupDetails(String groupName) {
		return AccountOperations.displayByGroup(groupName);
	}

	public static boolean checkIfGroupExists(String groupName) {
		boolean status=false;
		status = AccountOperations.checkIfGroupExists(groupName);
		return status;
	}

}
