package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.AccountList;
import com.epam.pmt.business.UpdateGroupName;
import com.epam.pmt.ui.UpdateGroupNameUI;

public class UpdateGroupNameUI {
	private static final Logger LOGGER = LogManager.getLogger(UpdateGroupNameUI.class);
	public static void updateGroupName() {
		if (AccountList.isEmpty()) {
			LOGGER.info("Empty List");
		} else {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			LOGGER.info("Enter the Group Name ");
			String groupName = input.nextLine();
			
			boolean found=UpdateGroupName.checkIfGroupExists(groupName);
			updateIfGroupExists(input, groupName, found);
		}
	}

	private static void updateIfGroupExists(Scanner input, String groupName, boolean found) {
		if(found) {
		LOGGER.info("Enter the New Group Name ");
		String newGroupName = input.nextLine();
		UpdateGroupName.updateGroupName(groupName, newGroupName);
		LOGGER.debug("Group Name Updated Successfully");
		}
		else {
			LOGGER.info("Group Not Found");
		}
	}
}
