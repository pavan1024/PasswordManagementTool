package com.epam.pmt.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
import com.epam.pmt.business.GroupOperations;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.DisplayGroupUI;

@Component
public class DisplayGroupUI {
	private static final Logger LOGGER = LogManager.getLogger(DisplayGroupUI.class);
	@Autowired
	AccountOperations accountOperations;
	@Autowired
	GroupOperations groupOperations;

	public void displayGroupAccountDetails() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the Groupname ");
		String groupname = input.nextLine();

		if (groupOperations.checkIfGroupExists(groupname)) {
			List<Account> accounts = groupOperations.groupDetails(groupname);
			for(Account account : accounts) {
				LOGGER.info("Account URL : {}",account.getUrl());
				LOGGER.info("Account Username : {}",account.getUserName());
				LOGGER.info("Account Password : {}",account.getPassword());
				LOGGER.info("Account Groupname : {}",account.getGroupname());
			}
		} else
			LOGGER.info("Enter the correct Groupname .......!!!!!!!!");

	}
}
