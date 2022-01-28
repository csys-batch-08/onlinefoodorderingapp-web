package com.onlinefoodorder.daoimpl;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodorder.dao.UserDao;
import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.User;

public class UserDaoimpl implements UserDao
{
	public void insertUser(User user) 
	{
		String insertQuery = "insert into user_details(user_name, phone_no, address, email_address, password) values(?,?,?,?,?)";
		
		ConnectionUtil con1 = new ConnectionUtil();
		Connection con = con1.getDbConnection();
		PreparedStatement p1 = null;
		try {
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
		}
	}
	
	public void userProfileUpdate(User user)
	{
		String updateQuery = "update user_details set user_name=?, phone_no=?, address=?, password=?  where email_address=?";
		
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(updateQuery);
			p1.setString(1, user.getUserName());
			p1.setLong(2, user.getPhoneNo());
			p1.setString(3, user.getAddress());
			p1.setString(4, user.getPassword());
			p1.setString(5, user.getEmailAddress());
			int i = p1.executeUpdate();
			p1.close();
			con.close();
		} 
		catch (SQLException e)
		{	
			e.printStackTrace();
		}
	}
	public  boolean forgotPassword(String emailid,String password)
	{
		String query = "update user_details set password = ? where email_address= ?";
		Connection con = ConnectionUtil.getDbConnection();
		boolean flag=false;
		try {
			PreparedStatement p1 = con.prepareStatement(query);
			p1.setString(1, password);
			p1.setString(2, emailid);
			int i=p1.executeUpdate();
			System.out.println(emailid);
			flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public User validateUser(String email_address,String password)
	{
		String validateQuery="select * from user_details where role='user' and email_address='"+email_address+"' and password='"+password+"'";
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(validateQuery);
			if(rs.next())
			{
				System.out.println(rs.getString(2));
				user=new User(rs.getString(2), rs.getLong(3), rs.getString(5), email_address, password, rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Statement error");
		} 
		return user;
	}
	public List<User> viewSingleUser(String emailid)
	{
		List<User> userList = new ArrayList<User>();
		String showQuery = "select * from user_details where email_address= ? ";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement s1 = con.prepareStatement(showQuery);
			s1.setString(1, emailid);
			ResultSet rs = s1.executeQuery();
			while(rs.next())
			{
				User user = new User(rs.getString(2),rs.getLong(3),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public void userProfileDelete(String inactive)
	{
		String deleteQuery = "update user_details set role='Inactive' where email_address=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, inactive);
			int i = p1.executeUpdate();
			System.out.println(i+ "user deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	public void userProfileActive(String active)
	{
		String deleteQuery = "update user_details set role='user' where email_address=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, active);
			int i = p1.executeUpdate();
			System.out.println(i+ "user deleted");
			p1.close();
			con.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	
	
	public User validateAdmin(String email_address,String password)
	{
		String adminQuery="select * from user_details where role='Admin' and email_address='"+email_address+"'and password='"+password+"'";		
		Connection con=ConnectionUtil.getDbConnection();
		User user=null;
		try {
			Statement stm =con.createStatement();
			ResultSet rs=stm.executeQuery(adminQuery);
			if(rs.next())
			{
				user = new User(rs.getString(2),(rs.getLong(3)),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> viewUser()
	{
		List<User> userList = new ArrayList<User>();
		String showQuery = "select * from user_details where not role='Admin'";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(showQuery);
			while(rs.next())
			{
				User user = new User(rs.getString(2),(rs.getLong(3)),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	public List<User> currentuserprofile(int userid)
	{
		List<User> userList = new ArrayList<User>();
		String showQuery = "select user_name, phone_no, address, email_address, password, wallet from user_details where user_id=?";
		Connection con = ConnectionUtil.getDbConnection();
		try {
			PreparedStatement s1 = con.prepareStatement(showQuery);
			s1.setInt(1, userid);
			ResultSet rs = s1.executeQuery();
			while(rs.next())
			{
				User user = new User(rs.getString(1),rs.getLong(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				userList.add(user);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	public int findUserId(String email_address)
	{
		String find_user = "select user_id from user_details where email_address = '"+email_address+"'";
		Connection con = ConnectionUtil.getDbConnection();
		int userId = 0;
		
		try {
			Statement s1 = con.createStatement();
			ResultSet rs = s1.executeQuery(find_user);
			if(rs.next())
			{
				userId = rs.getInt(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}
	
	//get wallet balance:
	public int walletbal(int id) 
	{
		Connection con = ConnectionUtil.getDbConnection();
		String query = "select wallet from user_details where user_id = ?";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
					return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//update wallet balance:
	public boolean updatewallet(User user){
		Connection con = ConnectionUtil.getDbConnection();
		String query = "update user_details set wallet = ? where email_address = ?";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(query);
			statement.setInt(1,user.getWallet());
			statement.setString(2, user.getEmailAddress());
			int res = statement.executeUpdate();
			statement.executeUpdate("commit");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public void userProfileUpdate(String emailAddress, String password) {
	}

	@Override
	public int updatewallet(int amount, int userid) {
		return 0;
	}
}









