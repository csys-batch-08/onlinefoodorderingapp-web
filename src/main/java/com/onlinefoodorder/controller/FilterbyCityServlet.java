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
@WebServlet("/filterbycityserv")
public class FilterbyCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			String city = request.getParameter("city");
			List<RestaurantDetails> restaurantlist = restaurantdao.filterbyCity(city);
			request.setAttribute("restaurantList", restaurantlist);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("filterByCity.jsp");
			requestdispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}	
	}
}
