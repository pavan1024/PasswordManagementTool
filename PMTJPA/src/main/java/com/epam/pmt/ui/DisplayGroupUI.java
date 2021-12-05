package com.epam.pmt.ui;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.AccountList;
import com.epam.pmt.business.DisplayGroup;
import com.epam.pmt.entities.Account;
import com.epam.pmt.ui.DisplayGroupUI;

public class DisplayGroupUI {
	private static final Logger LOGGER = LogManager.getLogger(DisplayGroupUI.class);

	public static void displayGroupAccountDetails() {
		if (AccountList.isEmpty()) {
			LOGGER.warn("Empty List");
		} else {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			LOGGER.info("Enter the Group Name ");
			String groupName = input.nextLine();
			
			if(DisplayGroup.checkIfGroupExists(groupName)) {
				List<Account> accounts=DisplayGroup.groupDetails(groupName);
				accounts.forEach(i -> LOGGER.info("URL : " + i.getUrl() + ", GroupName : " + i.getGroupName() + ", Username : " + i.getUserName() + ", Password : " + i.getPassword()));
			}else {
				LOGGER.info("Enter the correct Group Name .......!!!!!!!!");
			}
			
		}

	}
}
