package com.onlinefoodorder.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinefoodorder.model.Ratings;
import com.onlinefoodorder.util.ConnectionUtil;
import com.onlinefoodorderingapp.logger.Logger;

public class RatingsDaoimpl {

	// Insert Ratings

	public int insertRatings(Ratings rating) throws SQLException {
		String query = "insert into ratings(user_id, restaurant_id, rating) values(?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, rating.getUserId());
			p1.setInt(2, rating.getRestaurantId());
			p1.setDouble(3, rating.getRating());
			int resid = p1.executeUpdate();
			p1.executeUpdate("commit");
			return resid;
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
			return -1;
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
	}

	// Add Ratings

	public double fetchRating(int restarantid) throws SQLException {
		Connection con = null;
		String query = "select floor(avg(rating)) from ratings where restaurant_id = ?";
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setDouble(1, restarantid);
			rs = p1.executeQuery();
			while (rs.next()) {
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return -1;
	}
}
