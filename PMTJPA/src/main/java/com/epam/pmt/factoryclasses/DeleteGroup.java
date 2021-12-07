package com.epam.pmt.factoryclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.pmt.ui.DeleteGroupUI;
@Component
public class DeleteGroup implements Task {
	@Autowired
	DeleteGroupUI deleteGroupUI;
	@Override
	public void doTask() {
		deleteGroupUI.deleteGroup();
		
	}

}
