package com.foodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodorder.dao.UserDao;
import com.onlinefoodorder.daoimpl.FoodItemsDaoimpl;
import com.onlinefoodorder.daoimpl.OrderFoodsDaoimpl;
import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.FoodItems;
import com.onlinefoodorder.model.Orderfoods;
import com.onlinefoodorder.model.User;

@WebServlet("/orderfood")
public class OrderfoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	try {
		HttpSession session = request.getSession();
		FoodItemsDaoimpl fooditem = new FoodItemsDaoimpl();
		
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		System.out.println(quantity);
		
		int userid = (int)(session.getAttribute("Userid1"));
		
		String emailaddress = (String)session.getAttribute("emailid");
	
		int resid = Integer.parseInt(request.getParameter("number"));
		
		String fname=request.getParameter("foodname");
		session.setAttribute("foodname",fname );
		
		int itemid = fooditem.finditemid(fname, resid);
		
		FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
		String foodname1 = fooditemdao.findFoodname(itemid);
		session.setAttribute("foodname1", foodname1);
		
		int price = fooditem.findFoodPrice(itemid);
		
		int totalprice = quantity*price;
		
		session.setAttribute("totalprice", totalprice);
		
		OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl();
		Orderfoods order = new Orderfoods(userid, itemid, quantity, totalprice);
		orderfood.insertOrderFoods(order);
		
		UserDaoimpl userdao = new UserDaoimpl();
		int wallet = userdao.walletbal(userid);
		
		if(wallet > 0)
		{
			int walletbalance = wallet - totalprice;
			session.setAttribute("walletbalance", walletbalance);
			User user = new User(null, 0, null, emailaddress, null, walletbalance);
			userdao.updatewallet(user);
			response.sendRedirect("orderConfirm.jsp");
		}
	} catch (SQLException e) {
			e.printStackTrace();
	}
  }
}
