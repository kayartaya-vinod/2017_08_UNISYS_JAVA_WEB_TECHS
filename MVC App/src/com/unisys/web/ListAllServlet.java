package com.unisys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.vinod.dao.ContactsRepository;
import co.vinod.dao.DaoException;
import co.vinod.entity.Contact;

@WebServlet("/list-all")
public class ListAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read the inputs (pageNum for example, not now)
		String strPage = request.getParameter("page");
		if (strPage == null) {
			strPage = "1";
		}
		int pageNum = Integer.parseInt(strPage);

		try {
			// use the model (dao)
			ContactsRepository dao = new ContactsRepository();
			List<Contact> data = dao.getAll(pageNum);

			// store the model data in the scope (request)
			request.setAttribute("contacts", data);
			request.setAttribute("pageNum", pageNum);

			// forward to the view (list.jsp)
			String view = "/WEB-INF/pages/list.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

}
