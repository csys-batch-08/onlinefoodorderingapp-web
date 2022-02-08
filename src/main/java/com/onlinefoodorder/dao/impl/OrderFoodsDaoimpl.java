package com.onlinefoodorder.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.onlinefoodorder.dao.OrderFoodsDao;
import com.onlinefoodorder.model.Orderfoods;
import com.onlinefoodorder.util.ConnectionUtil;

public class OrderFoodsDaoimpl implements OrderFoodsDao {
	
	//insert ordered food details
	public boolean insertOrderFoods(Orderfoods order) throws SQLException {
		String insert = "insert into order_foods(user_id, item_id, quantity, total_price) values(?,?,?,?)";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(insert);
			p1.setInt(1, order.getUserId());
			p1.setInt(2, order.getItemId());
			p1.setInt(3, order.getQuantity());
			p1.setDouble(4, order.getTotalPrice());
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return true;
	}

	// Admin view all order details
	public List<Orderfoods> viewOrderFoods() throws SQLException {
		List<Orderfoods> orderlist = new ArrayList<>();
		String showQuery = "select order_id, user_id, item_id, quantity, total_price, order_date, order_status from order_foods";
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			statement = con.createStatement();
			rs = statement.executeQuery(showQuery);
			while (rs.next()) {
				Orderfoods order = new Orderfoods(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("item_id"),
						rs.getInt("quantity"), rs.getDouble("total_price"), rs.getDate("order_date").toLocalDate(),
						rs.getString("order_status"));
				orderlist.add(order);
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

		return orderlist;
	}

	// User view my orders details
	public List<Orderfoods> userViewOrder(int userid) throws SQLException {
		List<Orderfoods> orderlist = new ArrayList<>();
		String showQuery = "select order_id, user_id, item_id, quantity, total_price, order_date, order_status from order_foods "
				+ "where user_id = ? order by order_date desc";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(showQuery);
			p1.setInt(1, userid);
			rs = p1.executeQuery();
			while (rs.next()) {
				Orderfoods order = new Orderfoods(rs.getInt("order_id"), rs.getInt("user_id"), rs.getInt("item_id"),
						rs.getInt("quantity"), rs.getDouble("total_price"), rs.getDate("order_date").toLocalDate(),
						rs.getString("order_status"));
				orderlist.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return orderlist;
	}

	//user can cancel the order
	public int updateOrderdetails(int orderId) throws SQLException {
		String updateQuery = "update order_foods set order_status = 'Cancel' where order_id=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(updateQuery);
			p1.setInt(1, orderId);
			p1.executeUpdate();
			p1.executeUpdate("commit");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return 0;
	}

	// Find Order Status through orderId
	public String findOrderstatus(int orderId) throws SQLException {
		String findQuery = "select order_status from order_foods where order_id=?";
		Connection con = null;
		PreparedStatement p1 = null;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(findQuery);
			p1.setInt(1, orderId);
			p1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatement(p1, con);
		}
		return null;
	}

	// Find Food Price through OrderId
	public int findfoodPrice(int orderid) throws SQLException {
		String price = "select total_price from order_foods where order_id= ?";
		Connection con = null;
		PreparedStatement p1 = null;
		ResultSet rs = null;
		int foodprice = 0;
		try {
			con = ConnectionUtil.getDbConnection();
			p1 = con.prepareStatement(price);
			p1.setInt(1, orderid);
			rs = p1.executeQuery();
			if (rs.next()) {
				foodprice = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeConnectionStatementResultSet(rs, p1, con);
		}
		return foodprice;
	}

}
