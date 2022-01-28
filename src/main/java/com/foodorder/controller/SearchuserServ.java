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

@WebServlet("/searchUser")
public class SearchuserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String emailid = request.getParameter("email");
	
		UserDaoimpl userdao = new UserDaoimpl();
		List<User> userList = userdao.viewSingleUser(emailid);
		
		request.setAttribute("userlist", userList);
		RequestDispatcher requestdispatcher = request.getRequestDispatcher("adminSearchUser.jsp");
		requestdispatcher.forward(request, response);
	}
}