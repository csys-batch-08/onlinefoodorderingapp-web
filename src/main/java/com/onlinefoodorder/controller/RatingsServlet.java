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

import com.onlinefoodorder.dao.impl.RatingsDaoimpl;
import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.Ratings;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/rating")
public class RatingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		
		
		try {
			HttpSession session = request.getSession();
			RestaurantdetailsDaoimpl restaurant = new RestaurantdetailsDaoimpl();
			RatingsDaoimpl ratingdao = new RatingsDaoimpl();

			int userid = (int)session.getAttribute("Userid1");
			
			String resname = request.getParameter("restaurantname");	
			
			int resid;
			resid = restaurant.findRestaurantId2(resname);
			double resrating = Double.parseDouble(request.getParameter("rating"));
			
			Ratings rating = new Ratings(userid, resid, resrating);
			ratingdao.insertRatings(rating);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("ShowRestaurantServ");
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e){
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
