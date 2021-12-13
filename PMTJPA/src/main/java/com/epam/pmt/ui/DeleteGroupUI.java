package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.AccountService;
import com.epam.pmt.business.GroupService;
import com.epam.pmt.ui.DeleteGroupUI;

@Component
public class DeleteGroupUI {
	@Autowired
	AccountService accountService;
	@Autowired
	GroupService groupService;
	private static final Logger LOGGER = LogManager.getLogger(DeleteGroupUI.class);

	public void deleteGroup() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter the Groupname ");
		String groupname = input.nextLine();
		if (groupService.deleteGroup(groupname))
			LOGGER.info("Group Deleted Successfully..........!!!!!!");
		else
			LOGGER.info("Group not found.........!!!!!!!!!!!");
	}
}
