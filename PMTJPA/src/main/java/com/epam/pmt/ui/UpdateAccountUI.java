package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.UpdateAccount;
import com.epam.pmt.ui.UpdateAccountUI;

public class UpdateAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(UpdateAccountUI.class);

	static Scanner input = new Scanner(System.in);

	public static void updateAccountDetails() {
		// checks whether the list is empty or not
		LOGGER.info("Enter your choice");
		LOGGER.info("1)update username");
		LOGGER.info("2)update password");
		String choice = input.nextLine();
		LOGGER.info("Enter url  ");
		String url = input.nextLine();
		usersChoice(choice, url);
	}

	private static void usersChoice(String choice, String url) {
		boolean found = UpdateAccount.checkUrl(url);
		switch (choice) {
		case "1":
			if (found) {
				updateUserName(url);
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

	public static void updateUserName(String url) {
		LOGGER.info("Enter New Username ");
		String newUserName = input.nextLine();
		UpdateAccount.updateUserName(url, newUserName);
		LOGGER.info("Username Updated Successfully.........!!!!!!");
	}

	public static void updatePassword(String url) {
		LOGGER.info("Enter New Password ");
		String newPassword = input.nextLine();
		boolean flag = UpdateAccount.updatePassword(url, newPassword);
		if (flag)
			LOGGER.info("Password Updated Successfully........!!!!!!!!!!! ");
		else
			LOGGER.info("Enter the password with atleat 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
	}

}
