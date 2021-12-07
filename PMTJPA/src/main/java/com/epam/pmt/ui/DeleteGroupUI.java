package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.DeleteGroup;
import com.epam.pmt.ui.DeleteGroupUI;

public class DeleteGroupUI {
	private static final Logger LOGGER = LogManager.getLogger(DeleteGroupUI.class);

	public static void deleteGroup() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the GroupName ");
		String groupName = input.nextLine();
		boolean flag = AccountOperations.deleteGroup(groupName);
		if (flag) 
			LOGGER.info("Group Deleted Successfully..........!!!!!!");
		else
			LOGGER.info("Group not found.........!!!!!!!!!!!");
	}
}
