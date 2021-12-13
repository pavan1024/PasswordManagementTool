package com.epam.pmt.ui;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.epam.pmt.business.MasterOperations;


@Component
public class RegisterUI {
	@Autowired
	MasterOperations masterOperations;
	private static final Logger LOGGER = LogManager.getLogger(RegisterUI.class);

	public void register() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter Username ");
		String username = input.next();
		LOGGER.info("Enter Password ");
		LOGGER.info("(Note) : Password Should be atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
		String password = input.next();

		boolean registered = masterOperations.registerAccount(username, password);
		if (registered) {
			LOGGER.info("Account Registered Successfully......!!!!!!!!!!!!");
		} else {
			LOGGER.info("Enter the password with atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
		}
	}

}
