package com.onlinefoodorder.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.Ratings;

public class RatingsDaoimpl {

	public int insertRatings(Ratings rating)
	{
		String query = "insert into ratings(user_id, restaurant_id, rating) values(?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1 = null;
		try {
				p1 = con.prepareStatement(query);
				p1.setInt(1, rating.getUser_id());
				p1.setInt(2, rating.getRestaurant_id());
				p1.setDouble(3, rating.getRating());
				int resid = p1.executeUpdate();
				p1.executeUpdate("commit");
				System.out.println("insrted");
				return resid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("try again");
			return -1;
		}		
	}
	public double fetchRating(Ratings rating)
	{
		Connection con =ConnectionUtil.getDbConnection();
		String query = "select avg(rating) from ratings where restaurant_id = ?";
		try {
			PreparedStatement p1 = con.prepareStatement(query);
			p1.setInt(1, rating.getRestaurant_id());
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}	
}










