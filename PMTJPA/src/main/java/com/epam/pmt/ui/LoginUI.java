package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.pmt.business.Login;



public class LoginUI {

	private static final Logger LOGGER = LogManager.getLogger(LoginUI.class);

	public static void login() {
		
			 	@SuppressWarnings("resource")
				Scanner input = new Scanner(System.in);
			 	boolean found =false;
			 	LOGGER.info("Enter your Username ");
				String userName = input.nextLine();
				if(Login.checkIfUserNameExists(userName)) {
					LOGGER.info("Enter your Password ");
					String password = input.nextLine();
					found = Login.login(userName, password);
					verify(found);
				}

				
				
	}
	private static void verify(boolean found) {
		if(found) {
			LOGGER.info("Login Successful.....!!!!!!!!");
			Menu.operations();
		}
		else {
			LOGGER.info("Invalid username or password");
		}
	}

}
