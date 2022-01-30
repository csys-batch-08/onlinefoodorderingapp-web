package com.onlinefoodorder.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorder.util.ConnectionUtil;

public class CartDaoimpl
{
	public void insertCart(int itemId,int customerid) throws SQLException, ClassNotFoundException
	{	 
		String insertQuery = "insert into cart(user_id,item_id)values(?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		int itemid=0;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insertQuery);
			p1.setInt(1,customerid );
			p1.setInt(2, itemId);
			 
			p1.executeUpdate();
			p1.executeUpdate("commit");
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
	}
	
	public List<FoodItems> fetchCart(int userid) throws SQLException, ClassNotFoundException 
	{
		List<FoodItems> foodItems = new ArrayList<>();
		String query = "select * from food_items where item_id in (select item_id from cart where user_id = ?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(query);
			p1.setInt(1, userid);
			ResultSet rs = p1.executeQuery();
			while(rs.next()) {
				foodItems.add(new FoodItems(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
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
		return foodItems;
	}
	
	public int removeCart(int itemId, int userId) throws SQLException, ClassNotFoundException 
	{
		String deletecart="delete from cart where item_id = ? and user_id = ?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1=con.prepareStatement(deletecart);
			p1.setInt(1, itemId);
			p1.setInt(2, userId);
			int i=p1.executeUpdate();
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
		return 0;
	}	
}
