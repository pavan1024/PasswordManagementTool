package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountOperations;
//import com.epam.pmt.business.DeleteGroup;
import com.epam.pmt.ui.DeleteGroupUI;

@Component
public class DeleteGroupUI {
	@Autowired
	AccountOperations accountOperations;
	private static final Logger LOGGER = LogManager.getLogger(DeleteGroupUI.class);

	public void deleteGroup() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the GroupName ");
		String groupname = input.nextLine();
		boolean status = accountOperations.deleteGroup(groupname);
		if (status)
			LOGGER.info("Group Deleted Successfully..........!!!!!!");
		else
			LOGGER.info("Group not found.........!!!!!!!!!!!");
	}
}
