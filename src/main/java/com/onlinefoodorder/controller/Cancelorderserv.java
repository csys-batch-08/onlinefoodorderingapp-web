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

import com.onlinefoodorder.daoimpl.OrderFoodsDaoimpl;
import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/Cancelorderserv")
public class Cancelorderserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			int orderId = Integer.parseInt(request.getParameter("orderid"));
			HttpSession session = request.getSession();
			session.setAttribute("orderId", orderId);
			OrderFoodsDaoimpl orderfooddao = new OrderFoodsDaoimpl();
			UserDaoimpl userdao = new UserDaoimpl();
			orderfooddao.updateOrderdetails(orderId);
			int foodprice = orderfooddao.findfoodPrice(orderId);
			
			int userid = (int)session.getAttribute("Userid1");
			int currentbalance = userdao.walletbal(userid);
			
			int refundprice = currentbalance + foodprice;
			
			String emailid = session.getAttribute("emailid").toString();
			User user = new User(emailid, refundprice, emailid, emailid, emailid);
			
			user.setEmailAddress(emailid);
			user.setWallet(refundprice);

			RequestDispatcher requestdispatcher = request.getRequestDispatcher("UserProfileServ");
			requestdispatcher.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
