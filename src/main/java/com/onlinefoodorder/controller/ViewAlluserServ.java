package com.onlinefoodorder.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinefoodorder.dao.impl.UserDaoimpl;
import com.onlinefoodorder.model.User;
import com.onlinefoodorderingapp.logger.Logger;

@WebServlet("/ViewAlluserServ")
public class ViewAlluserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response){

		try {
			UserDaoimpl userdao = new UserDaoimpl();
			List<User> userList = userdao.viewUser();
			request.setAttribute("userlist", userList);
			RequestDispatcher rd = request.getRequestDispatcher("viewAllUser.jsp");
			rd.forward(request, response);
		} catch (ServletException | IOException | SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}	
	}
}
