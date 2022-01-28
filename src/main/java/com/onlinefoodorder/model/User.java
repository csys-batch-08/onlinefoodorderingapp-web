package com.onlinefoodorder.model;

import java.util.Objects;

public class User 
{
	private String userName;
	private long phoneNo;
	private String address;
	private String emailAddress;
	private String password;
	private int wallet;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getWallet() {
		return wallet;
	}


	public void setWallet(int wallet) {
		this.wallet = wallet;
	}


	public User(String userName, long phoneNo, String address, String emailAddress, String password, int wallet) {
		super();
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.emailAddress = emailAddress;
		this.password = password;
		this.wallet = wallet;
	}
	public User(String userName, long phoneNo, String address, String emailAddress, String password) {
		super();
		this.userName = userName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, emailAddress, password, phoneNo, userName, wallet);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(emailAddress, other.emailAddress)
				&& Objects.equals(password, other.password) && phoneNo == other.phoneNo
				&& Objects.equals(userName, other.userName) && wallet == other.wallet;
	}
	@Override
	public String toString() {
		return String.format("\nUser name : " +userName+ "\nPhone Number : " +phoneNo+ "\nAddress : " +address+ "\nEmail Address : " +emailAddress+"\nPassword : " +password+ "\nwallet : ");
	}
}
