package com.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicle")                   //              mappedBy is used to tell the hibernate not to create a separate table with the ids as it has already been maaped by userdetails table and it ahs created a separate table
	private Collection<UserDetails> userNameList = new ArrayList<>();	
	
	
	public Collection<UserDetails> getUserNameList() {
		return userNameList;
	}
	public void setUserNameList(Collection<UserDetails> userNameList) {
		this.userNameList = userNameList;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
}
