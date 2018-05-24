package com.unisys.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello-jsp")
public class HelloJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// A Controller (usually a servlet) has following activites:
		
		// 1. read the request information (params, cookies, session, headers, etc)
		
		// 2. coordinate with Model (biz.logic/DAO/EJB session beans, etc)
		//    and invoke appropriate biz.methods passing the inputs
		
		// 3. store the resultant data (model) in a scope (request, session, etc)
		String title = "This is from Request scope";
		request.setAttribute("title", title);
		request.getSession().setAttribute("title", "This is from Session scope");
		getServletContext().setAttribute("title", "This is from Application scope");
		request.getSession().setAttribute("myName", "Vinod");

		// 4. forward the control to the VIEW (JSP, xhtml, velocity, freemarker, etc)
		String viewName = "/WEB-INF/pages/hello.jsp";
		System.out.println("Before going to the JSP");
		request.getRequestDispatcher(viewName).forward(request, response);
		System.out.println("After coming back from JSP");
		
	}

}
