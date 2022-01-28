package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/UserProfileServ")
public class UserProfileServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int customerid = (int)session.getAttribute("Userid1");
		UserDaoimpl userdao = new UserDaoimpl();
		List<User> userList = userList = userdao.currentuserprofile(customerid);
		request.setAttribute("userlist", userList);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("userprofile.jsp");
		requestdispatcher.forward(request, response);
	}

}
