package com.foodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
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
			HttpSession session = request.getSession();
			session.setAttribute("activerestaurant","Restaurant Active");
			response.sendRedirect("admin.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
