package com.epam.pmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts_TABLE")
public class Account {

	@Id
	private String url;
	@Column
	private String username;
	@Column
	private String password;
	private String groupname;
	@ManyToOne
	@JoinColumn(name = "master_id")
	private Master master;

	public String getGroupName() {
		return groupname;
	}

	public void setGroupName(String groupName) {
		this.groupname = groupName;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
