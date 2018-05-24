package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/hello", "/hi" })
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("From inside the HelloServlet.doGet() method");
		
		// this has to be done before obtaining the output stream/writer
		response.setContentType("text/html");
		
		// get a writer
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello, world!</h1>");
		out.close();
		
	}

}
