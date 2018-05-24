package com.unisys.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.vinod.dao.ContactsRepository;
import co.vinod.entity.Contact;

@WebServlet("/save-contact")
public class SaveContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			Contact c = (Contact) request.getAttribute("contact");
			
			ContactsRepository dao = new ContactsRepository();
			if(c.getId()==0){
				dao.createContact(c);
				response.sendRedirect("./list-all");
			}
			else {
				dao.updateContact(c);
				response.sendRedirect("./edit-contact?id="+c.getId());
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
