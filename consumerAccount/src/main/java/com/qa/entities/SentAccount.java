package com.qa.entities;

public class SentAccount {

	private String accNo;
	private String firstName;
	private String lastName;
	private String email;
	private String prize;
	
	public SentAccount() {
		super();
	}
	
	public SentAccount(String accNo, String firstName, String lastName, String email, String prize) {
		super();
		this.accNo = accNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.prize = prize;
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
}
