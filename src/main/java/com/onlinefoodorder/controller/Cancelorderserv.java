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

import com.onlinefoodorder.dao.impl.OrderFoodsDaoimpl;
import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/Cancelorderserv")
public class Cancelorderserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response){
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
				User user = new User(null, 0, null, emailid, null, refundprice);
				userdao.updatewallet(user);
			
				user.setEmailAddress(emailid);
				user.setWallet(refundprice);

				RequestDispatcher requestdispatcher = request.getRequestDispatcher("UserProfileServ");
				requestdispatcher.forward(request, response);
		}catch (ServletException | IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}
}
