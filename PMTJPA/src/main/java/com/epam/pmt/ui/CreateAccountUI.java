package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.CreateAccount;
import com.epam.pmt.ui.CreateAccountUI;
import com.epam.pmt.business.Validation;

public class CreateAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(CreateAccountUI.class);

	public static void createAccount() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter URL");
		LOGGER.info("(Note) : Url must start with 'https://'");
		String url = input.nextLine();
		boolean valid = Validation.isValidURL(url);
		if (valid) {
			LOGGER.info("Enter Username ");
			String userName = input.nextLine();
			LOGGER.info("Enter Password ");
			LOGGER.info(
					"(Note) : Password Should be atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
			String password = input.nextLine();
			if (Validation.isValidPassword(password)) {
				LOGGER.info("Enter Group Name ");
				String groupName = input.nextLine();
				CreateAccount.createAccount(url, userName, password, groupName);
				LOGGER.info("Account Added Succesfully...........!!!!!!!");
			} else {
				LOGGER.info(
						"Enter the password with atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
			}
		} else {
			LOGGER.info("Enter a Valid url ");
		}

	}
}
