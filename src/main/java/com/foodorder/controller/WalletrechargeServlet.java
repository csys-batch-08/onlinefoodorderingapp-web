package com.foodorder.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/rechargewallet")
public class WalletrechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		HttpSession session = request.getSession();	
		Long cardnumber = Long.parseLong(request.getParameter("cardnumber"));
		String email = (String) session.getAttribute("emailid");
		int amount = Integer.parseInt(request.getParameter("amount"));
		int cvv = Integer.parseInt(request.getParameter("cvv"));
		UserDaoimpl userdao = new UserDaoimpl();
		int userid = (int)session.getAttribute("Userid1");
		int balance= userdao.walletbal(userid);
		int currentbalance = balance+amount;
		User user = new User(null, 0, null, email, null, currentbalance);
		boolean wallet = userdao.updatewallet(user);
		
		if(wallet)
		{
			response.sendRedirect("userprofile.jsp");
		}
		else
		{
			response.getWriter().print("Wallet not recharged");
		}
	}
}
