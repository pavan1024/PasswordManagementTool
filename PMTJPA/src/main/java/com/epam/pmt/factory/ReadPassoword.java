package com.epam.pmt.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.ReadPasswordUI;

@Component
public class ReadPassoword implements Task {
	@Autowired
	ReadPasswordUI readPasswordUI;

	@Override
	public void doTask() {
		readPasswordUI.displayAccountPassword();

	}

}
