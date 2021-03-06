package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.CartDaoimpl;
import com.onlinefoodorder.dao.impl.FoodItemsDaoimpl;
import com.onlinefoodorderingapp.logger.Logger;
@WebServlet("/addcartserv")
public class AddcartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		try {
			HttpSession session = request.getSession();
			
			FoodItemsDaoimpl fooditem = new FoodItemsDaoimpl();
			CartDaoimpl cart = new CartDaoimpl();
			
			String name= request.getParameter("fname");
			int resid=Integer.parseInt(request.getParameter("resid"));
			int itemid;
			itemid = fooditem.finditemid(resid, name);
			int customerid = (int)session.getAttribute("Userid1");
			
			cart.insertCart(customerid, itemid);
			
			session.setAttribute("itemidcart", itemid);
			session.setAttribute("resId", resid);
			response.sendRedirect("ShowCartServ");
			
		} catch (NumberFormatException | SQLException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
