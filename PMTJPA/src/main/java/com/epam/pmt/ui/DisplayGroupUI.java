package com.epam.pmt.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountService;
import com.epam.pmt.business.GroupService;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.DisplayGroupUI;

@Component
public class DisplayGroupUI {
	private static final Logger LOGGER = LogManager.getLogger(DisplayGroupUI.class);
	@Autowired
	AccountService accountService;
	@Autowired
	GroupService groupService;

	public void displayGroupAccountDetails() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the Groupname ");
		String groupname = input.nextLine();

		if (groupService.checkIfGroupExists(groupname)) {
			List<Account> accounts = groupService.groupDetails(groupname);
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
