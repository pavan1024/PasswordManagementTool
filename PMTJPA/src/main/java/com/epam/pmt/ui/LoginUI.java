package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.epam.pmt.business.MasterUserService;

@Component
public class LoginUI {

	private static final Logger LOGGER = LogManager.getLogger(LoginUI.class);
	@Autowired
	MasterUserService masterUserService;
	@Autowired
	Menu menu;

	public void login() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean status = false;
		LOGGER.info("Enter your Username ");
		String username = input.nextLine();
		if (masterUserService.checkIfMasterExists(username)) {
			LOGGER.info("Enter your Password ");
			String password = input.nextLine();
			status = masterUserService.login(username, password);
			this.verify(status);
		}

	}

	private void verify(boolean status) {
		if (status) {
			LOGGER.info("Login Successful.....!!!!!!!!");
			menu.operations();
		} else {
			LOGGER.info("Invalid username or password");
		}
	}

}
