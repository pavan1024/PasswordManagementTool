package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.DeleteAccount;
import com.epam.pmt.ui.DeleteAccountUI;
@Component
public class DeleteAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(DeleteAccountUI.class);
	@Autowired
	AccountOperations accountOperations;
	public void deleteAccount() {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			
			LOGGER.info("Enter the URL ");
			String url = input.nextLine();
			if(accountOperations.deleteAccount(url))
				LOGGER.info("Account Deleted Successfully...........!!!!!!");
			else 
				LOGGER.info("URL Not Found....!!!!");

	}

}
