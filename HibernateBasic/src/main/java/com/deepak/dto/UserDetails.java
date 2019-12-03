package com.deepak.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   // uses as serogate value now the onus is on the db to generate a new value at the time of insertion
													// by default generationType is AUTO, others are sequence, identity, table(uses other table to store value of id
	@Column(name = "USER_ID")
	private int userId;
	private String userName;

	// if want to save only date, time or timeStamp use temporaltype enumeration
	@Temporal(TemporalType.TIME)
	// by default date time will be saved
	private Date joinDate;

	// Specifies that the property or field is not persistent.
	// or declare it as static
	@Transient
	private String address;
	
	// Specifies that a persistent property or field should be persistedas a large object to a database-supported large object type. 
	@Lob   // depending on type  selects CLob or BLob (character or Byte)
	private String description;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME") // can put to getter also
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
