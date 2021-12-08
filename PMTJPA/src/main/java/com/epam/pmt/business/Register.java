package com.epam.pmt.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.MasterOperations;

@Component
public class Register {
	@Autowired
	MasterOperations masterOperations;
	@Autowired
	Validation validation;

	public boolean registerAccount(String username, String password) {
		boolean status = false;
		if (validation.isValidPassword(password)) {
			masterOperations.createMaster(username, password);

			status = true;
		}
		return status;
	}

}
