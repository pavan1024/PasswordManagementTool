package com.epam.pmt.db;

import com.epam.pmt.entities.Master;

public class MasterProvider {
	static Master master=new Master();
	
	public static void setMaster(String userName,String password) {
		master.setUsername(userName);
		master.setPassword(password);
	}

	public static Master getMaster() {
		return master;
	}
	
	
}
