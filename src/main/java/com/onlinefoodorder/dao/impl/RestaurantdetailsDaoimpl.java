package com.onlinefoodorder.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.dao.RestaurantdetailsDao;
import com.onlinefoodorder.model.RestaurantDetails;
import com.onlinefoodorder.util.ConnectionUtil;

public class RestaurantdetailsDaoimpl implements RestaurantdetailsDao {
	
	//Admin register the restaurant details
	public boolean insertRestaurantDetails(RestaurantDetails restaurant) throws SQLException {
		String insertQuery = "insert into restaurant_details(restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image) values(?,?,?,?,?,?,?,?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;

		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertQuery);
			p1.setString(1, restaurant.getRestaurantName());
			p1.setString(2, restaurant.getArea());
			p1.setString(3, restaurant.getCity());
			p1.setInt(4, restaurant.getPincode());
			p1.setLong(5, restaurant.getRestaurantLandlineNo());
			p1.setString(6, restaurant.getOwnerName());
			p1.setString(7, restaurant.getOperationalHours());
			p1.setString(8, restaurant.getEmail());
			p1.setString(9, restaurant.getPassword());
			p1.setString(10, restaurant.getRestaurantImages());
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return true;
	}

	//Admin update the restaurant Details
	public boolean restaurantUpdate(RestaurantDetails restaurant) throws SQLException {
		String updateQuery = "update restaurant_details set restaurant_name=?, restaurant_landline_no=?, owner_name=?, operational_hours=?, password=? where email=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, restaurant.getRestaurantName());
			p1.setLong(2, restaurant.getRestaurantLandlineNo());
			p1.setString(3, restaurant.getOwnerName());
			p1.setString(4, restaurant.getOperationalHours());
			p1.setString(5, restaurant.getPassword());
			p1.setString(6, restaurant.getEmail());
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return true;
	}

	// Admin Inactive the particular restaurant
	public int inactiveRestaurant(String emailid) throws SQLException {
		String updateQuery = "update restaurant_details set restaurant_status = 'Inactive' where email = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return -1;
	}

	//Admin Active the particular restaurant
	public int activeRestaurant(String emailid) throws SQLException {
		String updateQuery = "update restaurant_details set restaurant_status = 'active' where email =?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setString(1, emailid);
			p1.executeUpdate();
			p1.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return -1;
	}

	// Find Restaurant Id through restaurant emailaddress
	public int findRestaurantId(String email) throws SQLException {
		String findid = "select restaurant_id from restaurant_details where email=?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		int restaurantid = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findid);
			p1.setString(1, email);
			rs = p1.executeQuery();
			if (rs.next()) {
				restaurantid = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return restaurantid;
	}

	// Find Restaurant Name through restaurnat emailaddress 
	public String findRestaurantName(String emailId) throws SQLException {
		String findName = "select restaurant_name from restaurant_details where email=?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		String restaurantName = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findName);
			p1.setString(1, emailId);
			rs = p1.executeQuery();
			if (rs.next()) {
				restaurantName = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return restaurantName;
	}

	// Find Restaurant Id through restaurant name
	public int findRestaurantId2(String restaurantName) throws SQLException {
		String findId = "select restaurant_id from restaurant_details where restaurant_name=?";
		Connection con = null;
		int restaurantId = 0;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findId);
			p1.setString(1, restaurantName);
			rs = p1.executeQuery();
			if (rs.next()) {
				restaurantId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}

		return restaurantId;
	}

	// Find Restaurant Name through RestaurantId
	public String findRestaurantName(int restaurantId) throws SQLException {
		String findname = "select restaurant_name from restaurant_details where restaurant_id = ?";
		Connection con = null;
		String restaurantname = null;
		ResultSet rs = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findname);
			p1.setInt(1, restaurantId);
			rs = p1.executeQuery();
			if (rs.next()) {
				restaurantname = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return restaurantname;
	}

	// User view all restaurants
	public List<RestaurantDetails> showRestaurant() throws SQLException {
		List<RestaurantDetails> restaurantlist = new ArrayList<>();
		String query = "select restaurant_id, restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image, restaurant_status from restaurant_details where restaurant_status='active'";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				RestaurantDetails restaurant = new RestaurantDetails(rs.getInt("restaurant_id"),
						rs.getString("Restaurant_name"), rs.getString("area"), rs.getString("city"),
						rs.getInt("Pincode"), rs.getLong("Restaurant_landline_no"), rs.getString("Owner_name"),
						rs.getString("Operational_hours"), rs.getString("Email"), rs.getString("Password"),
						rs.getString("Restaurant_image"), rs.getString("restaurant_status"));
				restaurantlist.add(restaurant);
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
		return restaurantlist;
	}

	//To search the restaurant by city name
	public List<RestaurantDetails> filterbyCity(String city) throws SQLException {
		List<RestaurantDetails> restaurantlist = new ArrayList<>();
		String query = "select restaurant_id, restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image, restaurant_status from restaurant_details where city= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setString(1, city);
			rs = p1.executeQuery();
			while (rs.next()) {
				RestaurantDetails restaurant = new RestaurantDetails(rs.getString("restaurant_name"),
						rs.getString("area"), rs.getString("city"), rs.getInt("pincode"),
						rs.getLong("restaurant_landline_no"), rs.getString("owner_name"),
						rs.getString("operational_hours"), rs.getString("email"),
						rs.getString("password"), rs.getString("restaurant_image"));
				restaurantlist.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return restaurantlist;
	}

	
	public List<RestaurantDetails> searchRestaurant(String emailid) throws SQLException {
		List<RestaurantDetails> restaurantList = new ArrayList<>();
		String showQuery = "select restaurant_id, restaurant_name, area, city, pincode, restaurant_landline_no, owner_name, operational_hours, email, password, restaurant_image, restaurant_status from restaurant_details where email=?";
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setString(1, emailid);
			rs = p1.executeQuery();
			while (rs.next()) {
				RestaurantDetails restaurant = new RestaurantDetails(rs.getInt("restaurant_id"),rs.getString("restaurant_name"), rs.getString("area"), rs.getString("city"),rs.getInt("pincode"), 
						rs.getLong("restaurant_landline_no"), rs.getString("owner_name"),	rs.getString("operational_hours"), rs.getString("email"), rs.getString("password"),rs.getString("restaurant_image"), rs.getString("restaurant_status"));
				restaurantList.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return restaurantList;
	}
}
