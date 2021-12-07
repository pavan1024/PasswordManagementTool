package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.business.Login;
@Component
public class LoginUI {

	private static final Logger LOGGER = LogManager.getLogger(LoginUI.class);
	@Autowired
	Login login;
	@Autowired
	Menu menu;
	public void login() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean found = false;
		LOGGER.info("Enter your Username ");
		String userName = input.nextLine();
		if (login.checkIfUserNameExists(userName)) {
			LOGGER.info("Enter your Password ");
			String password = input.nextLine();
			found = login.login(userName, password);
			this.verify(found);
		}

	}

	private void verify(boolean found) {
		if (found) {
			LOGGER.info("Login Successful.....!!!!!!!!");
			menu.operations();
		} else {
			LOGGER.info("Invalid username or password");
		}
	}

}
