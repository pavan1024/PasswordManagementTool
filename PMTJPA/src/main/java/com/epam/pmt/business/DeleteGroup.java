package com.epam.pmt.business;

import com.epam.pmt.dao.AccountsDBOperations;
import com.epam.pmt.dao.AccountsDBOperationsImpl;

public class DeleteGroup {
	static AccountsDBOperations db=new AccountsDBOperationsImpl();
	public static boolean deleteGroup(String groupName) {
		boolean status=false;
		status = db.deleteGroup(groupName);
		return status;
	}

}
