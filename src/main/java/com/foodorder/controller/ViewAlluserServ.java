package com.foodorder.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

@WebServlet("/ViewAlluserServ")
public class ViewAlluserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserDaoimpl userdao = new UserDaoimpl();
		List<User> userList = userdao.viewUser();
		
		request.setAttribute("userlist", userList);
		RequestDispatcher rd = request.getRequestDispatcher("viewAllUser.jsp");
		rd.forward(request, response);
	}

}
