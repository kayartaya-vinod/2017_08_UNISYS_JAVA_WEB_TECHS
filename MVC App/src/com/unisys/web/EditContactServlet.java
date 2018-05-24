package com.unisys.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.vinod.dao.ContactsRepository;
import co.vinod.dao.DaoException;
import co.vinod.entity.Contact;

@WebServlet("/edit-contact")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		if(strId==null){
			response.sendRedirect("list-all");
			return;
		}
		
		int id = Integer.parseInt(strId);
		try {
			ContactsRepository dao = new ContactsRepository();
			Contact c = dao.retrieveContact(id);
			request.setAttribute("contact", c);
			request.setAttribute("pageTitle", "Edit contact details");
			request.setAttribute("btnCaption", "Update details");
			String view = "/WEB-INF/pages/contact-form.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} catch (DaoException e) {
			throw new ServletException(e);
		}
	}

}
