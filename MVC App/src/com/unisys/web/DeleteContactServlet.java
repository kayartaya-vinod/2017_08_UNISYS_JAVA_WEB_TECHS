package com.unisys.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.vinod.dao.ContactsRepository;
import co.vinod.dao.DaoException;

@WebServlet("/delete-contact")
public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int pageNum = Integer.parseInt(request.getParameter("page"));

		try {
			// use the model (dao)
			ContactsRepository dao = new ContactsRepository();
			dao.deleteContact(id);
			response.sendRedirect("list-all?page=" + pageNum);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

	}

}
