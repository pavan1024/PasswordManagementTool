package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.Register;

public class RegisterUI {

	private static final Logger LOGGER = LogManager.getLogger(RegisterUI.class);

	public static void register() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter Username ");
		String userName = input.next();
		LOGGER.info("Enter Password ");
		LOGGER.info("(Note) : Password Should be atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
		String password = input.next();

		boolean registered = Register.register(userName, password);
		if (registered) {
			LOGGER.info("Account Registered Successfully......!!!!!!!!!!!!");
		} else {
			LOGGER.info("Enter the password with atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
		}
	}

}
