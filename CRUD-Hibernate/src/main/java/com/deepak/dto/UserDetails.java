package com.deepak.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
// Should the entity's current state be selected from the database when determining whether to perform an update when
// re-attaching detached entities?
@SelectBeforeUpdate(true)                          // fires select query before firing update query, if there is changes in the record then only fires update query
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // uses as serogate value now the onus is on the db to generate a
													// new value at the time of insertion
													// by default generationType is AUTO, others are sequence, identity,
													// table(uses other table to store value of id
	private int userId;
	
	private String userName;

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
