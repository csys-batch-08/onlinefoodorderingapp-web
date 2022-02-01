package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;

@WebServlet("/deleterestaurant")
public class InactiveRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			restaurantdao.inactiveRestaurant(email);
			String restaurantName = restaurantdao.findRestaurantName(email);
			request.setAttribute("restaurantname", restaurantName);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("restaurantInactiveMsg.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
