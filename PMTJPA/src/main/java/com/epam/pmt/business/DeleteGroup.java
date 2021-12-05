package com.epam.pmt.business;

import com.epam.pmt.crudoperations.AccountOperations;

public class DeleteGroup {

	public static boolean deleteGroup(String groupName) {
		boolean status=false;
		status = AccountOperations.deleteGroup(groupName);
		return status;
	}

}
