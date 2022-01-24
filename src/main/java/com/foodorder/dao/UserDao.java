package com.foodorder.dao;

import java.util.List;

import com.onlinefoodorder.model.User;

public interface UserDao 
{
	public void insertUser(User user);
	public User validateUser(String email_address,String password);
	public void userProfileUpdate(String email_address, String password);
	public void userProfileDelete(String email_address);
	public List<User> viewUser();
	public int findUserId(String email_address);
	public int walletbal(int id);
	public int updatewallet(int amount,int userid);
}
