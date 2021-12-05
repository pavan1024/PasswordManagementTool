package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.ReadPasswordUI;

public class ReadPassoword implements Task {

	@Override
	public void doTask() {
		ReadPasswordUI.displayAccountDetails();
		
	}

}
