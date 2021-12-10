package com.epam.pmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="groups")
public class Group {
	@Id
	int id;
	@Column
	String groupname;
	
	
}
