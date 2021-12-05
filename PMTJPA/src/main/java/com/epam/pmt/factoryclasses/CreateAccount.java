package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.CreateAccountUI;

public class CreateAccount implements Task {

	@Override
	public void doTask() {
		CreateAccountUI.createAccount();
		
	}

}
