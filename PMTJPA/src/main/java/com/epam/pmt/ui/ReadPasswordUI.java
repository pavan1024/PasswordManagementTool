package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.ReadPassword;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.ReadPasswordUI;

import java.util.*;

public class ReadPasswordUI {
	private static final Logger LOGGER = LogManager.getLogger(ReadPasswordUI.class);

	public static void displayAccountDetails() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the URL ");
		String url = input.nextLine();
		displayAccounts(url);
	}

	private static void displayAccounts(String url) {
		try {
			if (!AccountOperations.readPassword(url).equals(""))
				LOGGER.info("Account Password : " + AccountOperations.readPassword(url));
			else
				LOGGER.info("URL not found");
		} catch (Exception e) {
			LOGGER.error("IndexOutOfBoundsException");
			LOGGER.info("URL Not Found ");
		}
	}
}
