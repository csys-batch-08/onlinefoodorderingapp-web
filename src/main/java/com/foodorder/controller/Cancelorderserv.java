package com.foodorder.controller;

import java.io.IOException;
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
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int order_id = Integer.parseInt(request.getParameter("orderid"));
		HttpSession session = request.getSession();
		session.setAttribute("orderId", order_id);
		OrderFoodsDaoimpl orderfooddao = new OrderFoodsDaoimpl();
		UserDaoimpl userdao = new UserDaoimpl();
		
		orderfooddao.updateOrderdetails(order_id);
		int foodprice = orderfooddao.findfoodPrice(order_id);
		
		int userid = (int)session.getAttribute("Userid1");
		int currentbalance = userdao.walletbal(userid);
		int refundprice = currentbalance + foodprice;
		String emailid = session.getAttribute("emailid").toString();
		User user = new User();
		user.setEmail_address(emailid);
		user.setWallet(refundprice);
		response.sendRedirect("userprofile.jsp");
		
//		int totalprice = (int)session.getAttribute("totalprice");
//		int balance = (int)session.getAttribute("walletebalance");
//		int refundprice = balance + totalprice;
		
		
	}
}
