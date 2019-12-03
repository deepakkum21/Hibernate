package com.deepak.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;


// Specifies a class whose instances are stored as an intrinsicpart of an owning entity and share the identity of the entity.
// Each of the persistent properties or fields of the embeddedobject is mapped to the database table for the entity. 
	@Embeddable
public class Address {

	// by using @Column here, this column name will be same for those attribute who has @Embedded attribute as Address
	@Column(name="STREET_NAME")
	private String street;
	@Column(name="CITY_NAME")
	private String city;
	@Column(name="PINCODE_NAME")
	private String pincode;
	@Column(name="STATE_NAME")
	private String state;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
