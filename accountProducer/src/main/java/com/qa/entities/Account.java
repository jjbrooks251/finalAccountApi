package com.qa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer aId;
	@Column(length = 30)
	private String accNo;
	@Column(length = 30)
	private String firstName;
	@Column(length = 50)
	private String lastName;
	@Column(length = 255)
	private String email;
	@Column
	private String prize;
	
	public Account() {
		super();
	}
	
	public Account(Integer aId, String accNo, String firstName, String lastName, String email, String prize) {
		super();
		this.aId = aId;
		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.prize = prize;
	}

	public Integer getaId() {
		return aId;
	}

	public void setaId(Integer aId) {
		this.aId = aId;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	@Override
	public String toString() {
		return "Account [aId=" + aId + ", accNo=" + accNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", prize = " + prize +"]";
	}
	
	
	
	
}
