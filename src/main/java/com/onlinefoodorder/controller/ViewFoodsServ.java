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

import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;

@WebServlet("/ViewFoodsServ")
public class ViewFoodsServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
			FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
			List<FoodItems> foodItemList;
			foodItemList = fooditemdao.showFoodItems();
			request.setAttribute("foodItemlist", foodItemList);
			RequestDispatcher rd = request.getRequestDispatcher("viewFoods.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
			
	}

}
