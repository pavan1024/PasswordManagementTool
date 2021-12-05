package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.UpdateAccountUI;

public class UpdateAccount implements Task {

	@Override
	public void doTask() {
		UpdateAccountUI.updateAccountDetails();
		
	}

}
