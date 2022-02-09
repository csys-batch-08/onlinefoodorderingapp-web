package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/deleterestaurant")
public class InactiveRestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
          
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			String email = request.getParameter("email");
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			restaurantdao.inactiveRestaurant(email);
			String restaurantName = restaurantdao.findRestaurantName(email);
			request.setAttribute("restaurantname", restaurantName);
			HttpSession session = request.getSession();
			session.setAttribute("Inactive", "Successfully Inactive");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("admin.jsp");
			requestdispatcher.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
