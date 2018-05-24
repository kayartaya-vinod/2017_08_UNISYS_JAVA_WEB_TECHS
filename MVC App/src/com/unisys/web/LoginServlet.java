package com.unisys.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read username/password from request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// get the "users" from the appScope
		ServletContext appScope = getServletContext();
		ResourceBundle users = (ResourceBundle) appScope.getAttribute("users");

		// authenticate
		boolean validUser = false;
		HttpSession session = request.getSession();

		if (users.containsKey(username)) {
			String actualPassword = users.getString(username);
			if (password.equals(actualPassword)) {
				// if valid user, store that info in the session
				validUser = true;
				session.setAttribute("username", username);
			}
		}

		if (!validUser) {
			this.doGet(request, response);
			return;
		}

		String url = (String) session.getAttribute("URL");
		if (url == null) {
			url = "./";
		}
		response.sendRedirect(url);
	}

}






