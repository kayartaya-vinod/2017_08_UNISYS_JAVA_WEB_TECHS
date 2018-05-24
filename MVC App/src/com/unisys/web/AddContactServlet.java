package com.unisys.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.vinod.entity.Contact;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Contact c = new Contact();
		c.setCity("Bangalore");
		c.setState("Karnataka");
		c.setCountry("India");
		request.setAttribute("contact", c);
		request.getRequestDispatcher("/WEB-INF/pages/contact-form.jsp")
			.forward(request, response);
	}

}





