package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.DeleteAccountUI;

public class DeleteAccount implements Task {

	@Override
	public void doTask() {
		DeleteAccountUI.deleteAccount();
		
	}

}
