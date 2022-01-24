package com.foodorder.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinefoodorder.daoimpl.UserDaoimpl;
import com.onlinefoodorder.model.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		UserDaoimpl userdao = new UserDaoimpl();
		User user = userdao.validateUser(email, password);
		User admin = userdao.validateAdmin(email, password);
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		if(user!=null)
		{
			pw.write("welcome " +user.getUser_name());
			
			session.setAttribute("user", user);
			String username=user.getUser_name();
			System.out.println(username);
			session.setAttribute("username", username);
			int userid = userdao.findUserId(email);
			session.setAttribute("Userid1", userid);
			System.out.println(userid);
			
			session.setAttribute("emailid", email);
			response.sendRedirect("showfoods.jsp");	
			
		}
		else if(admin!=null)
		{
			pw.write("welcome admin");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
			
		}
		else
		{
			pw.write("Invalid Login");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}	
	}
}
