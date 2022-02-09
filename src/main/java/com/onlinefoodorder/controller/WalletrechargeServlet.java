package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/rechargewallet")
public class WalletrechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){	
	try{
			HttpSession session = request.getSession();	
			Long cardnumber = Long.parseLong(request.getParameter("cardnumber"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			int cvv = Integer.parseInt(request.getParameter("cvv"));
			
			UserDaoimpl userdao = new UserDaoimpl();
			int userid = (int)session.getAttribute("Userid1");
			int balance = userdao.walletbal(userid);
			int currentbalance = balance + amount;
			
			String emailid = (String) session.getAttribute("emailid");
			
			User user = new User(null, 0, null, emailid, null, currentbalance);
			boolean wallet = userdao.updatewallet(user);
		
			if(wallet)
			{
				response.sendRedirect("UserProfileServ");
			}
			else
			{
				response.getWriter().print("Wallet not recharged");
			}		
		} catch (NumberFormatException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
