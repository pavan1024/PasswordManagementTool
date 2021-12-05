package com.epam.pmt.factoryclasses;


import java.util.HashMap;

public class TaskFactory {

	public Task createTask(int choice) {
		HashMap<Integer,Task> map=new HashMap<>();
		map.put(1, new CreateAccount());
		map.put(2, new DisplayAllAccounts());
		map.put(3, new DisplayGroup());
		map.put(4, new DeleteAccount());
		map.put(5, new UpdateAccount());
		map.put(6, new UpdateGroupName());
		map.put(7, new DeleteGroup());
		return map.get(choice);
	}
}