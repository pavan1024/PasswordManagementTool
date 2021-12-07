package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.ReadPassword;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.ReadPasswordUI;

import java.util.*;
@Component
public class ReadPasswordUI {
	private static final Logger LOGGER = LogManager.getLogger(ReadPasswordUI.class);
	@Autowired
	AccountOperations accountOperations;
	public void displayAccountPassword() {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the URL ");
		String url = input.nextLine();
		displaypassword(url);
	}

	private void displaypassword(String url) {
		try {
			if (!accountOperations.readPassword(url).equals(""))
				LOGGER.info("Account Password : " + accountOperations.readPassword(url));
			else
				LOGGER.info("URL not found");
		} catch (Exception e) {
			LOGGER.error("IndexOutOfBoundsException");
			LOGGER.info("URL Not Found ");
		}
	}
}
