package com.ldeng.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="user1")
public class AutoUser {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int autoUserId;
	
	private String email;
	private String firstName;
	
	private String lastName;

	/**
	 * @return the autoUserId
	 */
	public int getAutoUserId() {
		return autoUserId;
	}

	/**
	 * @param autoUserId the autoUserId to set
	 */
	public void setAutoUserId(int autoUserId) {
		this.autoUserId = autoUserId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
