package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.CartDaoimpl;
import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.model.FoodItems;
@WebServlet("/addcartserv")
public class AddcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String name= request.getParameter("fname");
	//	session.setAttribute("itemname",  name);
		int resid=Integer.parseInt(request.getParameter("resid"));
		FoodItemsDaoimpl fooditem = new FoodItemsDaoimpl();
		FoodItems food=new FoodItems();
		int itemid = fooditem.finditemid(name, resid);
		CartDaoimpl cart = new CartDaoimpl();
		int customerid = (int)session.getAttribute("Userid1");
		cart.insertCart( itemid,customerid);
		session.setAttribute("itemidcart", itemid);
		session.setAttribute("resId", resid);
		response.sendRedirect("CartSucc.jsp");
	}


}
