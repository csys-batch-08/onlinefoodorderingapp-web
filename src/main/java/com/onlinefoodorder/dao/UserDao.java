package com.onlinefoodorder.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinefoodorder.model.User;

public interface UserDao 
{
	public void insertUser(User user) throws SQLException, ClassNotFoundException;
	public void userProfileUpdate(User user) throws SQLException, ClassNotFoundException;
	public  boolean forgotPassword(String emailid,String password) throws SQLException, ClassNotFoundException;
	public User validateUser(String emailAddress,String password) throws SQLException, ClassNotFoundException;
	public List<User> viewSingleUser(String emailid) throws SQLException, ClassNotFoundException;
	public void userProfileDelete(String inactive) throws SQLException, ClassNotFoundException;
	public void userProfileActive(String active) throws SQLException, ClassNotFoundException;
	public User validateAdmin(String emailAddress,String password) throws SQLException, ClassNotFoundException;
	public List<User> viewUser() throws SQLException, ClassNotFoundException;
	public List<User> currentuserprofile(int userid) throws SQLException, ClassNotFoundException;
	public int findUserId(String emailAddress) throws SQLException, ClassNotFoundException;
	public int walletbal(int id) throws SQLException, ClassNotFoundException;
	public boolean updatewallet(User user) throws SQLException, ClassNotFoundException;
}
