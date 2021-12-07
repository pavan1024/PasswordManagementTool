package com.epam.pmt.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import com.epam.rd.database.MasterLoginCredentials;
import com.epam.pmt.business.Validation;
import com.epam.pmt.dao.MasterOperations;
import com.epam.pmt.entities.Master;

@Component
public class Register {
	
	@Autowired
	Validation validation;
	public boolean register(String username, String password) {
		boolean found = false;
		if (validation.isValidPassword(password)) {
			MasterOperations.createMaster(username, password);

			found = true;
		}
		return found;
	}

}
