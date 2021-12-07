package com.epam.pmt.ui;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//import com.epam.pmt.business.CreateAccount;
import com.epam.pmt.ui.CreateAccountUI;
import com.epam.pmt.business.AccountOperations;
import com.epam.pmt.business.Validation;

@Component
public class CreateAccountUI {
	private static final Logger LOGGER = LogManager.getLogger(CreateAccountUI.class);
	@Autowired
	AccountOperations accountOperations;
	@Autowired
	Validation validation;
	public CreateAccountUI() {
		System.out.println("create account");
	}
	
	public void createAccount() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		LOGGER.info("Enter URL");
		LOGGER.info("(Note) : Url must start with 'https://'");
		String url = input.nextLine();
		boolean valid = validation.isValidURL(url);
		if (valid) {
			LOGGER.info("Enter Username ");
			String userName = input.nextLine();
			LOGGER.info("Enter Password ");
			LOGGER.info("(Note) : Password Should be atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
			String password = input.nextLine();
			if (validation.isValidPassword(password)) {
				LOGGER.info("Enter Group Name ");
				String groupName = input.nextLine();
				this.accountOperations.createAccount(url, userName, password, groupName);
				LOGGER.info("Account Added Succesfully...........!!!!!!!");
			} else {
				LOGGER.info("Enter the password with atleast 1 UpperCase, 1 LowerCase , 1 Number, 1 Special Character");
			}
		} else {
			LOGGER.info("Enter a Valid url ");
		}

	}
}
