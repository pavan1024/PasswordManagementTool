package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.DisplayGroupUI;

public class DisplayGroup implements Task {

	@Override
	public void doTask() {
		DisplayGroupUI.displayGroupAccountDetails();
		
	}

}
