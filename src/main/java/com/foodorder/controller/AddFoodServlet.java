package com.foodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
@WebServlet("/addfoods")
public class AddFoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("emailid");
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			int restaurantid;
			restaurantid = restaurantdao.findRestaurantId(email);
			HttpSession session = request.getSession();
			session.setAttribute("restaurantid", restaurantid);
			RequestDispatcher rd = request.getRequestDispatcher("foodItems.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

}
