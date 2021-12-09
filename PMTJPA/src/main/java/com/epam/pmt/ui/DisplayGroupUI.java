package com.epam.pmt.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.DisplayGroupUI;

@Component
public class DisplayGroupUI {
	private static final Logger LOGGER = LogManager.getLogger(DisplayGroupUI.class);
	@Autowired
	AccountOperations accountOperations;

	public void displayGroupAccountDetails() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the Groupname ");
		String groupname = input.nextLine();

		if (accountOperations.checkIfGroupExists(groupname)) {
			List<Account> accounts = accountOperations.groupDetails(groupname);
			accounts.forEach(i -> LOGGER.info("URL : " + i.getUrl() + ", GroupName : " + i.getGroupname()
					+ ", Username : " + i.getUserName() + ", Password : " + i.getPassword()));
		} else
			LOGGER.info("Enter the correct Groupname .......!!!!!!!!");

	}
}
