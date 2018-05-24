package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("./ex02.html");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// read parameter info from web.xml
		String bgcolor = getInitParameter("bgcolor");
		String fgcolor = getInitParameter("fgcolor");
		
		// read parameter info from the user (request)
		String username = req.getParameter("username");
		String password = req.getParameter("passcode");
		String[] favColors = req.getParameterValues("fav_colors");

		System.out.println("From inside the service method SaveDataServlet.");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.printf("<body style='color:%s; background-color:%s' >", fgcolor, bgcolor);
		out.printf("Confirm details: ");
		out.printf("Username = %s<br>", username);
		out.printf("Password = %s<br>", password);

		if (favColors == null || favColors.length == 0) {
			out.println("No favorite color chosen!<br>");
		} else {
			out.println("Your favorite colors: <br>");
			out.println("<ul>");
			for (String fc : favColors) {
				out.printf("<li style='color: %s'>%s</li>", fc, fc);
			}
			out.println("</ul>");
		}

		out.close();

	}

}
