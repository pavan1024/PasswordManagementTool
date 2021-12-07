package com.epam.pmt.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.dao.MasterOperations;

@Component
public class Register {

	@Autowired
	Validation validation;

	public boolean register(String username, String password) {
		boolean status = false;
		if (validation.isValidPassword(password)) {
			MasterOperations.createMaster(username, password);

			status = true;
		}
		return status;
	}

}
