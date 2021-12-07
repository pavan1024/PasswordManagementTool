package com.epam.pmt.factoryclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.UpdateAccountUI;

@Component
public class UpdateAccount implements Task {
	@Autowired
	UpdateAccountUI updateAccountUI;

	@Override
	public void doTask() {
		updateAccountUI.updateAccountDetails();

	}

}
