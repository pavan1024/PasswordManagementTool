package com.epam.pmt.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.CreateAccountUI;

@Component
public class CreateAccount implements Task {
	@Autowired
	CreateAccountUI createAccountUI;

	@Override
	public void doTask() {
		createAccountUI.createAccount();

	}

}
