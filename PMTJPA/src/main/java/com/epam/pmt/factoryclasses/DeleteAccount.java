package com.epam.pmt.factoryclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.DeleteAccountUI;
@Component
public class DeleteAccount implements Task {
	@Autowired
	DeleteAccountUI deleteAccountUI;
	@Override
	public void doTask() {
		
		this.deleteAccountUI.deleteAccount();
		
	}

}
