package com.deepak.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)                  					  // by default this is the strategy if not given @Inheritance
@DiscriminatorColumn(name="VEHICLE_TYPE", discriminatorType=DiscriminatorType.STRING)     //   column name and type for the DTYPE
@DiscriminatorValue("GAADI")															  // this gives the userdefined name to the Discriminator in DTYPE Column
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
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
