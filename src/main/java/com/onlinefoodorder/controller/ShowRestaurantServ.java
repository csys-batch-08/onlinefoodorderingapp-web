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

@WebServlet("/ShowRestaurantServ")
public class ShowRestaurantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
{			
	try {
			RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
			List<RestaurantDetails> restaurantlist;
			restaurantlist = restaurantdao.showRestaurant();
			req.setAttribute("restaurantList", restaurantlist);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("showRestaurant.jsp");
			requestDispatcher.forward(req, resp);
		} catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
