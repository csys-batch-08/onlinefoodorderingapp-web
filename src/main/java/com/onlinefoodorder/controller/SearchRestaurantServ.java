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

import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.RestaurantDetails;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/SearchRestaurantServ")
public class SearchRestaurantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			String emailid = request.getParameter("email");
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			List<RestaurantDetails> restaurantList = restaurantdao.searchRestaurant(emailid);
			
			request.setAttribute("restaurantList", restaurantList);
			
			RequestDispatcher resquestdispatcher = request.getRequestDispatcher("adminSearchRestaurant.jsp");
			resquestdispatcher.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
