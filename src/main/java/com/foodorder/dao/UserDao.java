package com.foodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.User;

public interface UserDao 
{
	public void insertUser(User user) throws SQLException;
	public void userProfileUpdate(User user) throws SQLException;
	public  boolean forgotPassword(String emailid,String password) throws SQLException;
	public User validateUser(String emailAddress,String password) throws SQLException;
	public List<User> viewSingleUser(String emailid) throws SQLException;
	public void userProfileDelete(String inactive) throws SQLException;
	public void userProfileActive(String active) throws SQLException;
	public User validateAdmin(String emailAddress,String password) throws SQLException;
	public List<User> viewUser() throws SQLException;
	public List<User> currentuserprofile(int userid) throws SQLException;
	public int findUserId(String emailAddress) throws SQLException;
	public int walletbal(int id) throws SQLException;
	public boolean updatewallet(User user) throws SQLException;
}
