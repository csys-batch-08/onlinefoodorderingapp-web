package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
@WebServlet("/activerestaurant")

public class ActiveRestaurantServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			restaurantdao.activeRestaurant(email);
			String restaurantName = restaurantdao.findRestaurantName(email);
			request.setAttribute("restaurantname", restaurantName);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("restaurantActiveMsg.jsp");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
