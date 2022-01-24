package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.RatingsDaoimpl;
import com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.Ratings;

@WebServlet("/rating")
public class RatingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		RestaurantdetailsDaoimpl restaurant = new RestaurantdetailsDaoimpl();
		RatingsDaoimpl ratingdao = new RatingsDaoimpl();

		int userid = (int)session.getAttribute("Userid1");
		
		String resname = request.getParameter("restaurantname");	
		
		int resid = restaurant.findRestaurantId2(resname);
				
		double resrating = Double.parseDouble(request.getParameter("rating"));
		
		Ratings rating = new Ratings(userid, resid, resrating);
		System.out.println(rating);
		ratingdao.insertRatings(rating);
		response.sendRedirect("showrestaurant.jsp");
	}
}
