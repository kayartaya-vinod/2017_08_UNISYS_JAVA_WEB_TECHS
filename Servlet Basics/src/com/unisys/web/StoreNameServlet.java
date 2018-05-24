package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/store-name")
public class StoreNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read the name from the request parameter
		String name = request.getParameter("name");
		
		// get/create a session
		HttpSession session = request.getSession();
		
		// get an ArrayList from the session
		ArrayList<String> namesList = (ArrayList<String>) session.getAttribute("names");
		
		// if not found, create and store the arraylist in session
		if(namesList==null){
			namesList = new ArrayList<String>();
			session.setAttribute("names", namesList);
		}
		
		// store the name in the arraylist
		namesList.add(name);
		
		// produce some response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("ex04.html");
		rd.include(request, response);
		
		rd = request.getRequestDispatcher("view-names");
		rd.include(request, response);
		
		out.printf("<h2>Name '%s' stored in session</h2>", name);
		out.close();
		
	}

}
