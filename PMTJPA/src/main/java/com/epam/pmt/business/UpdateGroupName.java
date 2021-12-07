package com.epam.pmt.business;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;

public class UpdateGroupName {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static boolean checkIfGroupExists(String groupName) {
		return db.checkIfGroupExists(groupName);	
	}

	public static boolean updateGroupName(String groupName, String newGroupName) {
		return db.modifyGroup(groupName, newGroupName);
	}

}
