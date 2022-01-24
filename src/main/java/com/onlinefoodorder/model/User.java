package com.onlinefoodorder.model;

import java.util.Objects;

public class User 
{
	private String user_name;
	private long phone_no;
	private String address;
	private String email_address;
	private String password;
	private int wallet;
	
	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public long getPhone_no() {
		return phone_no;
	}


	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
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


	public User(String user_name, long phone_no, String address, String email_address, String password, int wallet) {
		super();
		this.user_name = user_name;
		this.phone_no = phone_no;
		this.address = address;
		this.email_address = email_address;
		this.password = password;
		this.wallet = wallet;
	}
	public User(String user_name, long phone_no, String address, String email_address, String password) {
		super();
		this.user_name = user_name;
		this.phone_no = phone_no;
		this.address = address;
		this.email_address = email_address;
		this.password = password;
	}


	public User() {
		
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, email_address, password, phone_no, user_name, wallet);
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
		return Objects.equals(address, other.address) && Objects.equals(email_address, other.email_address)
				&& Objects.equals(password, other.password) && phone_no == other.phone_no
				&& Objects.equals(user_name, other.user_name) && wallet == other.wallet;
	}


	@Override
	public String toString() {
		return String.format("\nUser name : " +user_name+ "\nPhone Number : " +phone_no+ "\nAddress : " +address+ "\nEmail Address : " +email_address+"\nPassword : " +password+ "\nwallet : ");
	}
}
