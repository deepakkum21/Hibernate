package com.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // uses as serogate value now the onus is on the db to generate a
													// new value at the time of insertion
													// by default generationType is AUTO, others are sequence, identity,
													// table(uses other table to store value of id
	@Column(name = "USER_ID")
	private int userId;
	
	private String userName;
	
	@JoinTable(name = "USER_VEHICLE",joinColumns= @JoinColumn(name="USER_ID"), inverseJoinColumns=@JoinColumn(name="VECHILE_ID"))
	@OneToMany
	private Collection<Vehicle> vehicle = new ArrayList<>();

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
