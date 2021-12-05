package com.epam.pmt.business;

import com.epam.pmt.dao.AccountOperations;

public class UpdateGroupName {

	public static boolean checkIfGroupExists(String groupName) {
		return AccountOperations.checkIfGroupExists(groupName);	
	}

	public static boolean updateGroupName(String groupName, String newGroupName) {
		return AccountOperations.modifyGroupName(groupName, newGroupName);
	}

}
