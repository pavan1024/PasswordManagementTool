package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
import com.epam.pmt.business.Validation;
//import com.epam.pmt.business.UpdateAccount;
import com.epam.pmt.ui.UpdateAccountUI;

@Component
public class UpdateAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(UpdateAccountUI.class);
	@Autowired
	AccountOperations accountOperations;
	@Autowired
	Validation validation;
	static Scanner input = new Scanner(System.in);

	public void updateAccountDetails() {

		LOGGER.info("Enter your choice");
		LOGGER.info("1)update username");
		LOGGER.info("2)update password");
		String choice = input.nextLine();
		LOGGER.info("Enter url  ");
		String url = input.nextLine();
		usersChoice(choice, url);
	}

	private void usersChoice(String choice, String url) {
		boolean found = accountOperations.checkUrl(url);
		switch (choice) {
		case "1":
			if (found) {
				updateUsername(url);
			} else {
				LOGGER.info("Url Not Found...!!!!!!!!!!");
			}
			break;
		case "2":
			if (found) {
				updatePassword(url);
			} else {
				LOGGER.info("Url Not Found...!!!!!!!!!!");
			}
			break;
		default:
			LOGGER.info("Enter the Right choice  ");
		}
	}

	public void updateUsername(String url) {
		LOGGER.info("Enter New Username ");
		String newUsername = input.nextLine();

		accountOperations.updateUserName(url, newUsername);
		LOGGER.info("Username Updated Successfully.........!!!!!!");
	}

	public void updatePassword(String url) {
		LOGGER.info("Enter New Password ");
		String newPassword = input.nextLine();
		if (validation.isValidPassword(newPassword)) {
			accountOperations.updatePassword(url, newPassword);
			LOGGER.info("Password Updated Successfully........!!!!!!!!!!! ");
		} else
			LOGGER.info("Enter the password with atleat 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
	}

}
