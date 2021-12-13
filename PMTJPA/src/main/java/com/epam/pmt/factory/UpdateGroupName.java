package com.epam.pmt.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.UpdateGroupNameUI;

@Component
public class UpdateGroupName implements Task {
	@Autowired
	UpdateGroupNameUI updateGroupNameUI;

	@Override
	public void doTask() {
		updateGroupNameUI.updateGroupName();

	}

}
