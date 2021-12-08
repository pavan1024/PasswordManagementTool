package com.epam.pmt.dao;

import java.util.List;
import com.epam.pmt.entities.Account;

public interface AccountDAO {
	public boolean createAccount(Account account);

	public String readPassword(Account account);
	
	public boolean deleteAccount(String url);

	public boolean updateAccountUsername(String url, String newUsername);

	public boolean updateAccountPassword(String url, String newPassword);
	
	public List<Account> displayByGroup(String groupname);
	
	public boolean deleteGroup(String groupname);

	public boolean modifyGroup(String currentGroupname, String newGroupname);

	


}
