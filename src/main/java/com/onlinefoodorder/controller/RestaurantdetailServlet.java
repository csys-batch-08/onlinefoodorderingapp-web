package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl;
import com.onlinefoodorder.model.RestaurantDetails;
import com.onlinefoodorderingapp.logger.Logger;
@WebServlet("/restaurantdetail")
public class RestaurantdetailServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
    	try {
    		String restaurantname = request.getParameter("restaurantname");
    		String area = request.getParameter("area");
    		String city = request.getParameter("city");
    		int pincode = Integer.parseInt(request.getParameter("pincode"));
    		long landlineno = (Long.parseLong(request.getParameter("landlineno")));
    		String ownername = request.getParameter("ownername");
    		String time = request.getParameter("time");
    		String email = request.getParameter("email");
    		String password = request.getParameter("password");
    		String image = request.getParameter("image");
        	RestaurantDetails restaurant = new RestaurantDetails(restaurantname, area, city, pincode, landlineno, ownername, time, email, password, image);
        	RestaurantdetailsDaoimpl restaurantDao = new RestaurantdetailsDaoimpl();
			restaurantDao.insertRestaurantDetails(restaurant);
			response.sendRedirect("admin.jsp");
		} catch (NumberFormatException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
    }
}
