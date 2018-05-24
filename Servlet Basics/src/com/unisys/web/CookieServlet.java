package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/store-cookie")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] allCookies = request.getCookies();
		String username = null;
		if (allCookies != null) {
			for (Cookie c1 : allCookies) {
				if (c1.getName().equals("username")) {
					username = c1.getValue();
					break;
				}
			}
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(username==null){
			out.println("<h1>Sorry, no cookie found with your name!</h1>");
			
			RequestDispatcher rd = request.getRequestDispatcher("ex03.html");
			rd.include(request, response);
		}
		else {
			out.printf("<h1>Hello, %s</h1>", username);
			out.println("<a href='delete-cookie'>Delete username cookie</a>");
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		Cookie c1 = new Cookie("username", username);
		c1.setMaxAge(300);
		response.addCookie(c1);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>We have stored your name in a cookie</h1>");
		out.close();
	}

}
