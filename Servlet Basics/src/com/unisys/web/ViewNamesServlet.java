package com.unisys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view-names")
public class ViewNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			out.println("<h2>No session for you, hence no names!</h2>");
		}
		else {
			List<String>	list = (List<String>) session.getAttribute("names");
			if(list==null || list.size()==0){
				out.println("<h2>You don't have any names</h2>");
			}
			else {
				out.println("<ol>");
				for(String name: list){
					out.printf("<li>%s</li>", name);
				}
				out.println("</ol>");
			}
		}
		out.close();
	}

}
