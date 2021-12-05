package com.epam.pmt.factoryclasses;

import com.epam.pmt.ui.UpdateGroupNameUI;

public class UpdateGroupName implements Task {

	@Override
	public void doTask() {
		UpdateGroupNameUI.updateGroupName();

	}

}
