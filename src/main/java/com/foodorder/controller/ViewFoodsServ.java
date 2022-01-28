package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;

@WebServlet("/ViewFoodsServ")
public class ViewFoodsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		List<FoodItems> foodItemList = fooditemdao.showFoodItems();
		
		request.setAttribute("foodItemlist", foodItemList);
		RequestDispatcher rd = request.getRequestDispatcher("viewfoods.jsp");
		rd.forward(request, response);	
	}

}
