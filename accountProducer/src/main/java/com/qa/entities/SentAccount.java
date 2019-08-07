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
	
	public SentAccount(Account account){
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.accNo = account.getAccNo();
        this.prize = account.getPrize();
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
