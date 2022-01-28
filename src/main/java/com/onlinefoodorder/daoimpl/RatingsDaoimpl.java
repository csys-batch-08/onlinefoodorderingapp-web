package com.onlinefoodorder.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodorder.util.ConnectionUtil;
import com.onlinefoodorder.model.Ratings;

public class RatingsDaoimpl {

	public int insertRatings(Ratings rating) throws SQLException
	{
		String query = "insert into ratings(user_id, restaurant_id, rating) values(?,?,?)";
		Connection con = ConnectionUtil.getDbConnection();
		PreparedStatement p1 = null;
		try {
				p1 = con.prepareStatement(query);
				p1.setInt(1, rating.getUserId());
				p1.setInt(2, rating.getRestaurantId());
				p1.setDouble(3, rating.getRating());
				int resid = p1.executeUpdate();
				p1.executeUpdate("commit");
				System.out.println("insrted");
				return resid;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("try again");
			return -1;
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}	
	}
	
	public double fetchRating(int restarantid) throws SQLException
	{
		System.out.println(restarantid + "reid");
		Connection con =ConnectionUtil.getDbConnection();
		String query = "select floor(avg(rating)) from ratings where restaurant_id = ?";
		PreparedStatement p1=null;
		try {
			p1 = con.prepareStatement(query);
			p1.setDouble(1, restarantid);
			ResultSet rs = p1.executeQuery();
			while(rs.next())
			{
				return rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(p1!=null) {
				p1.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		return -1;
	}	
}









