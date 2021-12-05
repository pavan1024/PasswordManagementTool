package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.DeleteGroupUI;

public class DeleteGroup implements Task {

	@Override
	public void doTask() {
		DeleteGroupUI.deleteGroup();
		
	}

}
