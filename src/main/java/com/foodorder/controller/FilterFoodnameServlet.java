package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
 @WebServlet("/filterfoods")
public class FilterFoodnameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		HttpSession session = request.getSession();
		
		String foodname = request.getParameter("search");
		fooditemdao.filterbyfoodname(foodname);
		
		session.setAttribute("foodname",foodname);
		response.sendRedirect("filterbyfoodnames.jsp");
		
//		Double foodprice = Double.parseDouble(request.getParameter("search"));
//		fooditemdao.filterbyPrice(foodprice);
		
//		session.setAttribute("foodprice", foodprice);
//		if(foodname!= null){
//			
//		}
//		else if(foodprice!=null){
//			response.sendRedirect("filterFoodsbyprice.jsp");
//		}
		
	}
}
