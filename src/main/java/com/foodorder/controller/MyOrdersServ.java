package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.daoimpl.OrderFoodsDaoimpl;
import com.onlinefoodorder.model.Orderfoods;

@WebServlet("/MyOrdersServ")
public class MyOrdersServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl(); 
		
		int uid = (int)session.getAttribute("Userid1");
		
		List<Orderfoods> orderlist = orderfood.userViewOrder(uid);
				 
		request.setAttribute("orderList", orderlist);
		
		String username = (String)session.getAttribute("username");
		String fname = (String)session.getAttribute("foodname1");
		
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("myOrders.jsp");
		requestdispatcher.forward(request, response);
	}
}