package com.epam.pmt.ui;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.factoryclasses.*;

public class Menu {
	private static final Logger LOGGER = LogManager.getLogger(Menu.class);

	public static void operations() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choice = 0;
		do {
			LOGGER.info("======== MENU ======== ");
			LOGGER.info("Enter your choice ");
			LOGGER.info("1) Create Account ");
			LOGGER.info("2) Display Account Password");
			LOGGER.info("3) Display All Accounts by Group Name");
			LOGGER.info("4) Delete Account ");
			LOGGER.info("5) Update Account Details ");
			LOGGER.info("6) Modify Groupname ");
			LOGGER.info("7) Delete Group ");
			LOGGER.info("Enter 0 to exit ");
			try {
			choice = input.nextInt();
			}
			catch(InputMismatchException e){
				//LOGGER.error("InputMismatchException");
				LOGGER.info("Enter the Numbers from 1 to 7 \n"+ "");
				Menu.operations();
				break;
			}
			TaskFactory taskFactory = new TaskFactory();
			Task task = taskFactory.createTask(choice);
			Optional<Task> optional=Optional.ofNullable(task);
			try {
				optional.get().doTask();
			} catch (NoSuchElementException e ) {
				if(choice!=0)
					LOGGER.info("Enter the Right choice  \n");
			}LOGGER.info("");
		} while (choice != 0);

	}
}