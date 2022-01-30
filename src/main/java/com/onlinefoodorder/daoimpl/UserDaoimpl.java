package com.onlinefoodorder.daoimpl;

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
	public void insertUser(User user) throws SQLException, ClassNotFoundException
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
	
	public void userProfileUpdate(User user) throws SQLException, ClassNotFoundException
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
	
	public  boolean forgotPassword(String emailid,String password) throws SQLException, ClassNotFoundException
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
	
	public User validateUser(String emailAddress,String password) throws SQLException, ClassNotFoundException
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
				user=new User(rs.getString(2), rs.getLong(3), rs.getString(5), emailAddress, password, rs.getInt(8));
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
	
	public List<User> viewSingleUser(String emailid) throws SQLException, ClassNotFoundException
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
				User user = new User(rs.getString(2),rs.getLong(3),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
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
	
	public void userProfileDelete(String inactive) throws SQLException, ClassNotFoundException
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
	
	public void userProfileActive(String active) throws SQLException, ClassNotFoundException
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
	
	public User validateAdmin(String emailAddress,String password) throws SQLException, ClassNotFoundException
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
				user = new User(rs.getString(2),rs.getLong(3),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
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
	
	public List<User> viewUser() throws SQLException, ClassNotFoundException
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
				User user = new User(rs.getString(2),(rs.getLong(3)),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
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
	
	public List<User> currentuserprofile(int userid) throws SQLException, ClassNotFoundException
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
				User user = new User(rs.getString(1),rs.getLong(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
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
	
	public int findUserId(String emailAddress) throws SQLException, ClassNotFoundException
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
	
	public String findUserName(String emailAddress) throws SQLException, ClassNotFoundException
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
	
	
	
	public int walletbal(int id) throws SQLException, ClassNotFoundException 
	{
		Connection con = null;
		String query = "select wallet from user_details where user_id = ?";
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, id);
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
	
	public boolean updatewallet(User user) throws SQLException, ClassNotFoundException
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
			p1.executeUpdate("commit");
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









