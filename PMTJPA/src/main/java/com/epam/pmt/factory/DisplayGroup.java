package com.epam.pmt.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.DisplayGroupUI;

@Component
public class DisplayGroup implements Task {
	@Autowired
	DisplayGroupUI displayGroupUI;

	@Override
	public void doTask() {
		displayGroupUI.displayGroupAccountDetails();

	}

}
