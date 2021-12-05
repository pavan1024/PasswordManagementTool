package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class PMTMainUser {
	private static final Logger LOGGER = LogManager.getLogger(PMTMainUser.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String choice;
		do {
			LOGGER.info("Enter your choice");
			LOGGER.info("1) Login ");
			LOGGER.info("2) Register");
			LOGGER.info("Enter 0 to exit");
			choice = input.nextLine();
			try {
			userschoice(choice);
			}
			catch(IndexOutOfBoundsException e) {
				LOGGER.info("Register an Account Before Login");
			}
		} while (!choice.equals("0"));
	}

	private static void userschoice(String choice) {
		if (choice.equals("1"))
			LoginUI.login();
		else if (choice.equals("2"))
			RegisterUI.register();
	}

}
