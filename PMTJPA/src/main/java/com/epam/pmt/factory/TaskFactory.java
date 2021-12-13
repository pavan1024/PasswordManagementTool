package com.epam.pmt.factory;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskFactory {
	@Autowired
	CreateAccount createAccount;
	@Autowired
	ReadPassoword readPassoword;
	@Autowired
	DisplayGroup displayGroup;
	@Autowired
	DeleteAccount deleteAccount;
	@Autowired
	UpdateAccount updateAccount;
	@Autowired
	UpdateGroupName updateGroupName;
	@Autowired
	DeleteGroup deleteGroup;

	public Task createTask(int choice) {
		HashMap<Integer, Task> map = new HashMap<>();
		map.put(1, createAccount);
		map.put(2, readPassoword);
		map.put(3, displayGroup);
		map.put(4, deleteAccount);
		map.put(5, updateAccount);
		map.put(6, updateGroupName);
		map.put(7, deleteGroup);

		return map.get(choice);
	}
}