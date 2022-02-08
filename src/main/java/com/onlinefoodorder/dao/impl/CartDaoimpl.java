package com.onlinefoodorder.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorder.util.ConnectionUtil;
public class CartDaoimpl {

	// Insert Cart
	public void insertCart(int customerid, int itemId) throws SQLException {
		String insertQuery = "insert into cart(user_id, item_id)values (?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertQuery);
			p1.setInt(1, customerid);
			p1.setInt(2, itemId);
			p1.executeUpdate();
			p1.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
	}

	// Add to Cart
	public List<FoodItems> fetchCart(int userid) throws SQLException {
		List<FoodItems> foodItems = new ArrayList<>();
		String query = "select * from food_items where item_id in (select item_id from cart where user_id = ?)";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, userid);
			rs = p1.executeQuery();
			while (rs.next()) {
				foodItems.add(new FoodItems(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5),
						rs.getDouble(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return foodItems;
	}

	// User Remove foods from cart
	public int removeCart(int itemId, int userId) throws SQLException {
		String deletecart = "delete from cart where item_id = ? and user_id = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(deletecart);
			p1.setInt(1, itemId);
			p1.setInt(2, userId);
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return 0;
	}
}
