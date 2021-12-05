package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.AccountList;
import com.epam.pmt.business.DeleteAccount;
import com.epam.pmt.ui.DeleteAccountUI;

public class DeleteAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(DeleteAccountUI.class);

	public static void deleteAccount() {
		if (AccountList.isEmpty()) {
			LOGGER.info("Empty List");
		} else {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			LOGGER.info("Enter the URL ");
			String url = input.nextLine();
			boolean found=DeleteAccount.deleteAccount(url);
			if(found)
				LOGGER.info("Account Deleted Successfully...........!!!!!!");
			else 
				LOGGER.info("URL Not Found....!!!!");
		}

	}

}
