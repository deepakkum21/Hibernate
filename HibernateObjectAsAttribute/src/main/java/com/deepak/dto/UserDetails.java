package com.deepak.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

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

	// Specifies a persistent field or property of an entity whose value is an
	// instance of an embeddable class. The embeddableclass must be annotated as
	// Embeddable.
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "HOME_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "HOME_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "HOME_PINCODE")) })
	private Address homeAddress;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "street", column = @Column(name = "OFFICE_STREET")),
			@AttributeOverride(name = "city", column = @Column(name = "OFFICE_CITY")),
			@AttributeOverride(name = "state", column = @Column(name = "OFFICE_STATE")),
			@AttributeOverride(name = "pincode", column = @Column(name = "OFFICE_PINCODE")) })
	private Address officeAddress;
	
	
	
	@ElementCollection      // when we want to have collection of a field
	// when want to give user defined of the collection table instead of maintablename_attributename as table
	@JoinTable(name="USER_ADDRESS",
			// this is to give userDefined name to a foreign key column instead of 
			joinColumns=@JoinColumn(name="USER_ID"))
	@GenericGenerator(name="increment-gen", strategy = "increment")               // it uses hibernate generator strategy (increment-gen)
	// used for having primary key on the attribute table list
	// sequence - This sort of strategy supports by Oracle, Postgresql.
	// increment - This sort of strategy supports by MySql.
	@CollectionId(columns= {@Column(name="ADDRESS_ID")},generator="increment-gen", type=@Type(type="long"))
	private Collection<Address> listOfAddress = new ArrayList<>();    // used Collection as it has index to support primary key on that listofAddress table
	// private Set<Address> listOfAddress = new HashSet<>();		  // Reference to a list has to be Interface	

	public Collection<Address> getListOfAddress() {
		return listOfAddress;
	}

	public void setListOfAddress(Collection<Address> listOfAddress) {
		this.listOfAddress = listOfAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address offideAddress) {
		this.officeAddress = offideAddress;
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
