package com.epam.pmt.dao;

import java.util.List;
import com.epam.pmt.entities.Account;

public interface AccountsDBOperations {
	public boolean createAccount(Account account);

	public String readPassword(String url);

	public List<Account> displayByGroup(String groupname);

	public boolean deleteAccount(String url);

	public boolean updateAccountUserName(String url, String newUsername);

	public boolean updateAccountPassword(String url, String newPassword);

	public boolean modifyGroup(String currentGroupname, String newGroupname);

	public boolean deleteGroup(String groupname);

	public boolean checkIfURLExists(String url);

	public boolean checkIfGroupExists(String groupname);

}
