package com.epam.pmt.business;

//import com.epam.rd.database.MasterLoginCredentials;
import com.epam.pmt.business.Validation;
import com.epam.pmt.dao.MasterOperations;
import com.epam.pmt.entities.Master;

public class Register {

	public static boolean register(String userName, String password) {
		boolean found = false;
		if (Validation.isValidPassword(password)) {
//			MasterLoginCredentials.getMasterAccounts().add(new MasterAccount(userName,password));
			MasterOperations.createMaster(userName,password);
			
			found = true;
		}
		return found;
	}

}
