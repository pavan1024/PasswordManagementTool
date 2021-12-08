package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.UpdateGroupName;
import com.epam.pmt.ui.UpdateGroupNameUI;

@Component
public class UpdateGroupNameUI {
	private static final Logger LOGGER = LogManager.getLogger(UpdateGroupNameUI.class);
	@Autowired
	AccountOperations accountOperations;

	public void updateGroupName() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the current Groupname ");
		String currentGroupname = input.nextLine();

		
		if (accountOperations.checkIfGroupExists(currentGroupname)) {
			LOGGER.info("Enter the New Groupname ");
			String newGroupname = input.nextLine();
			accountOperations.updateGroupName(currentGroupname, newGroupname);
			LOGGER.debug("Groupname Updated Successfully");
		} else {
			LOGGER.info("Group Not Found");
		}
	}

}
