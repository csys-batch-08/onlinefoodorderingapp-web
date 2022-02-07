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

public class UserDaoimpl implements UserDao {
	
	//User register the details
	public boolean insertUser(User user) throws SQLException {
		String insertQuery = "insert into user_details(user_name, phone_no, address, email_address, password) values(?,?,?,?,?)";
		boolean flag = false;
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
			p1.executeUpdate("commit");
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return flag;
	}
	
	// User update their profile
	public boolean userProfileUpdate(User user) throws SQLException {
		String updateQuery = "update user_details set user_name=?, phone_no=?, address=?, password=?  where email_address=?";
		boolean flag = false;
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, user.getUserName());
			p1.setLong(2, user.getPhoneNo());
			p1.setString(3, user.getAddress());
			p1.setString(4, user.getPassword());
			p1.setString(5, user.getEmailAddress());
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return flag;
	}

	
	// Forgot Password
	public boolean forgotPassword(String emailid, String password) throws SQLException {
		String query = "update user_details set password = ? where email_address= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		boolean flag = false;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, password);
			p1.setString(2, emailid);
			p1.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return flag;
	}
	
	// Validate admin login
	public User validateAdmin(String emailAddress, String password) throws SQLException {
		String adminQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where role='Admin' and email_address= ? and password=?";
		Connection con = null;
		PreparedStatement p1 = null;
		User user = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(adminQuery);
			p1.setString(1, emailAddress);
			p1.setString(2, password);
			rs = p1.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("User_Name"), rs.getLong("Phone_no"), rs.getString("Address"),rs.getString("Email_address"), rs.getString("Password"), rs.getInt("Wallet"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return user;
	}
	
	// Validate User login
	public User validateUser(String emailAddress, String password) throws SQLException {
		String validateQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where role='user' and email_address= ? and password= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		User user = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(validateQuery);
			p1.setString(1, emailAddress);
			p1.setString(2, password);
			rs = p1.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("USER_NAME"), rs.getLong("PHONE_NO"), rs.getString("ADDRESS"),emailAddress, password, rs.getInt("WALLET"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return user;
	}

	// Admin search the particular user details
	public List<User> viewSingleUser(String emailid) throws SQLException {
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where email_address= ? ";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setString(1, emailid);
			rs = p1.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("USER_NAME"), rs.getLong("PHONE_NO"), rs.getString("ADDRESS"), rs.getString("EMAIL_ADDRESS"), rs.getString("PASSWORD"), rs.getInt("WALLET"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return userList;
	}

	// Admin inactive the user details
	public int userProfileDelete(String emailAddress) throws SQLException {
		String deleteQuery = "update user_details set role='Inactive' where email_address=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, emailAddress);
			p1.executeUpdate();
			p1.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return -1;
	}

	// Admin active the user details
	public int userProfileActive(String emailAddress) throws SQLException {
		String deleteQuery = "update user_details set role='user' where email_address=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(deleteQuery);
			p1.setString(1, emailAddress);
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return -1;
	}

	// Admin view all user details
	public List<User> viewUser() throws SQLException {
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_id, user_name, phone_no, role, address, email_address, password, wallet from user_details where not role='Admin' order by user_id desc fetch first 10 rows only";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(showQuery);
			while (rs.next()) {
				User user = new User(rs.getString("user_name"), rs.getLong("phone_no"), rs.getString("address"),rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null){
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}

	// User view their profile details
	public List<User> currentuserprofile(int userid) throws SQLException {
		List<User> userList = new ArrayList<>();
		String showQuery = "select user_name, phone_no, address, email_address, password, wallet from user_details where user_id=?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setInt(1, userid);
			rs = p1.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getString("user_name"), rs.getLong("phone_no"), rs.getString("address"),rs.getString("email_address"), rs.getString("password"), rs.getInt("wallet"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return userList;
	}

	//Find User Id through emailaddress
	public int findUserId(String emailAddress) throws SQLException {
		String findUser = "select user_id from user_details where email_address = ?";
		Connection con = null;
		int userId = 0;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findUser);
			p1.setString(1, emailAddress);
			rs = p1.executeQuery();
			if (rs.next()) {
				userId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return userId;
	}

	// Find username through emailaddress
	public String findUserName(String email) throws SQLException {
		String findUser = "select user_name from user_details where email_address = ?";
		Connection con = null;
		String userName = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findUser);
			p1.setString(1, email);
			rs = p1.executeQuery();
			if (rs.next()) {
				userName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return userName;
	}

	// user to check the wallet balance
	public int walletbal(int userId) throws SQLException {
		Connection con = null;
		String query = "select wallet from user_details where user_id = ?";
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, userId);
			rs = p1.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return -1;
	}

	//User to  update wallet balancce
	public boolean updatewallet(User user) throws SQLException {
		Connection con = null;
		String query = "update user_details set wallet = ? where email_address = ?";
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, user.getWallet());
			p1.setString(2, user.getEmailAddress());
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return true;
	}
}
