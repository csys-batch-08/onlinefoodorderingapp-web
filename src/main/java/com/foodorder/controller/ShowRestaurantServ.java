package com.foodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.RatingsDaoimpl;
import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.Ratings;
import com.onlinefoodorder.model.RestaurantDetails;

@WebServlet("/ShowRestaurantServ")
public class ShowRestaurantServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{			
		try {
				RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
				List<RestaurantDetails> restaurantlist;
				restaurantlist = restaurantdao.showRestaurant();
				RatingsDaoimpl ratingdao = new RatingsDaoimpl();
				Ratings rating = new Ratings();
						
				req.setAttribute("restaurantList", restaurantlist);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("showRestaurant.jsp");
				requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
				e.printStackTrace();
		}
			
	}
}
