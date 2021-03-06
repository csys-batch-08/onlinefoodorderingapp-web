package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.FoodItemsDaoimpl;
import com.onlinefoodorder.dao.impl.OrderFoodsDaoimpl;
import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.Orderfoods;
import com.onlinefoodorder.model.User;

@WebServlet("/orderfood")
public class OrderfoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		
	try {
		HttpSession session = request.getSession();
		FoodItemsDaoimpl fooditem = new FoodItemsDaoimpl();
		
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		int userid = (int)(session.getAttribute("Userid1"));
		
		String emailaddress = (String)session.getAttribute("emailid");
	
		int resid = Integer.parseInt(request.getParameter("number"));
		
		String fname = request.getParameter("foodname");
		
		session.setAttribute("foodname",fname );
		
		int itemid = fooditem.finditemid(resid, fname);
		
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		String foodname1 = fooditemdao.findFoodname(itemid);
		session.setAttribute("foodname1", foodname1);
		
		int price = fooditem.findFoodPrice(itemid);
		
		int totalprice = quantity*price;
		
		session.setAttribute("totalprice", totalprice);
		
		OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl();
		Orderfoods order = new Orderfoods(userid, itemid, quantity, totalprice);
		
		UserDaoimpl userdao = new UserDaoimpl();
		int wallet = userdao.walletbal(userid);
		
		if(wallet > 0)
		{
			orderfood.insertOrderFoods(order);
			int walletbalance = wallet - totalprice;
			session.setAttribute("walletbalance", walletbalance);
			User user = new User(null, 0, null, emailaddress, null, walletbalance);
			userdao.updatewallet(user);
			response.sendRedirect("orderConfirm.jsp");
		}
		else {
			response.sendRedirect("walletRecharge.jsp");
		}
	} catch (NumberFormatException | SQLException |IOException e) {
			e.printStackTrace();
	}
  }
}
