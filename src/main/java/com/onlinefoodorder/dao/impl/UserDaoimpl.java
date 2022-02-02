package com.onlinefoodorder.dao.impl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinefoodorder.dao.UserDao;
import com.onlinefoodorder.model.User;
import com.onlinefoodorder.util.ConnectionUtil;

public class UserDaoimpl implements UserDao
{
	
	//Insert User Details
	
	public void insertUser(User user) throws SQLException
	{
		String insertQuery = "insert into user_details(user_name, phone_no, address, email_address, password) values(?,?,?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertQuery);
			p1.setString(1, user.getUserName());
			p1.setLong(2, user.getPhoneNo());
			p1.setString(3, user.getAddress());
			p1.setString(4, user.getEmailAddress());
			p1.setString(5, user.getPassword());
			p1.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
	}
	
	//Update User Details
	
	public void userProfileUpdate(User user) throws SQLException
	{
		String updateQuery = "update user_details set user_name=?, phone_no=?, address=?, password=?  where email_address=?";
		
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, user.getUserName());
			p1.setLong(2, user.getPhoneNo());
			p1.setString(3, user.getAddress());
			p1.setString(4, user.getPassword());
			p1.setString(5, user.getEmailAddress());
			p1.executeUpdate();
		} 
		catch (SQLException e)
		{	
			e.printStackTrace();
		}
		finally{
			if(p1!=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	//Forgot Password 
	
	public  boolean forgotPassword(String emailid,String password) throws SQLException
	{
		String query = "update user_details set password = ? where email_address= ?";
		Connection con = null;
		PreparedStatement p1=null;
		boolean flag=false;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, password);
			p1.setString(2, emailid);
			p1.executeUpdate();
			flag=true;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return flag;
	}
	
	// Validate User 
	
	public User validateUser(String emailAddress,String password) throws SQLException
	{
		String validateQuery="select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where role='user' and email_address='"+emailAddress+"' and password='"+password+"'";
		Connection con = null;
		User user=null;
		Statement statement=null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement=con.createStatement();
			ResultSet rs=statement.executeQuery(validateQuery);
			if(rs.next())
			{
				user=new User(rs.getString("user_name"), rs.getLong("phone_no"), rs.getString("address"), emailAddress, password, rs.getInt("wallet"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
		return user;
	}
	
	//Admin Search User
	
	public List<User> viewSingleUser(String emailid) throws SQLException
	{
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where email_address= ? ";
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setString(1, emailid);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				User user = new User(rs.getString("user_name"),rs.getLong("phone_no"),rs.getString("address"), rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return userList;
	}
	
	// Inactive User
	
	public void userProfileDelete(String inactive) throws SQLException
	{
		String deleteQuery = "update user_details set role='Inactive' where email_address=?";
		Connection con = null;
		PreparedStatement p1= null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, inactive);
			p1.executeUpdate();
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	//Active User
	
	public void userProfileActive(String active) throws SQLException
	{
		String deleteQuery = "update user_details set role='user' where email_address=?";
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, active);
			p1.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
	}
	
	//Validate Admin
	public User validateAdmin(String emailAddress,String password) throws SQLException
	{
		String adminQuery="select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where role='Admin' and email_address= '"+emailAddress+"' and password='"+password+"'";		
		Connection con =null; 
		User user=null;
		Statement statement = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement =con.createStatement();
			ResultSet rs=statement.executeQuery(adminQuery);
			if(rs.next())
			{
				user = new User(rs.getString("user_name"),rs.getLong("phone_no"),rs.getString("address"), rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return user;
	}
	
	//Admin View All User
	
	public List<User> viewUser() throws SQLException
	{
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where not role='Admin'";
		Connection con = null;
		Statement statement=null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(showQuery);
			while(rs.next())
			{
				User user = new User(rs.getString("user_name"),rs.getLong("phone_no"),rs.getString("address"), rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return userList;
	}
	
	// User Profile
	
	public List<User> currentuserprofile(int userid) throws SQLException
	{
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_name, phone_no, address, email_address, password, wallet from user_details where user_id=?";
		Connection con = null;
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setInt(1, userid);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				User user = new User(rs.getString("user_name"),rs.getLong("phone_no"),rs.getString("address"), rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return userList;
	}
	
	// Find User Id
	public int findUserId(String emailAddress) throws SQLException
	{
		String findUser = "select user_id from user_details where email_address = '"+emailAddress+"'";
		Connection con = null;
		int userId = 0;
		Statement statement = null;
		
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findUser);
			if(rs.next())
			{
				userId = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return userId;
	}
	
	//Find User Name
	public String findUserName(String emailAddress) throws SQLException
	{
		String findUser = "select user_name from user_details where email_address = '"+emailAddress+"'";
		Connection con = null;
		String userName = null;
		Statement statement = null;
		
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery(findUser);
			if(rs.next())
			{
				userName = rs.getString(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				statement.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return userName;
	}
	
	//Wallet Balance
	
	public int walletbal(int userId) throws SQLException 
	{
		Connection con = null;
		String query = "select wallet from user_details where user_id = ?";
		PreparedStatement p1 = null;
		
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, userId);
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
					return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return -1;
	}
	
	//Update Wallet
	
	public boolean updatewallet(User user) throws SQLException
	{
		Connection con = null;
		String query = "update user_details set wallet = ? where email_address = ?";
		PreparedStatement p1=null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1,user.getWallet());
			p1.setString(2, user.getEmailAddress());
			p1.executeUpdate();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		finally{
			if(p1 !=null){
				p1.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return true;
	}
}









