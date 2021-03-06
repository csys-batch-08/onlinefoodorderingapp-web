package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.OrderFoodsDaoimpl;
import com.onlinefoodorder.model.Orderfoods;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/MyOrdersServ")
public class MyOrdersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){

		
		try {
			HttpSession session = request.getSession();
			OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl(); 
			
			int uid = (int)session.getAttribute("Userid1");
			
			List<Orderfoods> orderlist;
			orderlist = orderfood.userViewOrder(uid);
			request.setAttribute("orderList", orderlist);
			
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("myOrders.jsp");
			requestdispatcher.forward(request, response);
		}catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
