package com.unisys.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/add-contact", "/edit-contact", "/delete-contact", "/save-contact" })
public class SecurityFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		System.out.println("req.getContextPath() = " + req.getContextPath());
		System.out.println("req.getRequestURI() = " + req.getRequestURI());
		System.out.println("req.getPathInfo() = " + req.getPathInfo());
		System.out.println("req.getQueryString() = " + req.getQueryString());
		
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			// not logged in
			
			String URL = String.format("%s%s", 
					req.getRequestURI(),
					req.getQueryString()==null ? "" : "?"+req.getQueryString());
			session.setAttribute("URL", URL);
			
			resp.sendRedirect("./login");
		} else {
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
	}

}
