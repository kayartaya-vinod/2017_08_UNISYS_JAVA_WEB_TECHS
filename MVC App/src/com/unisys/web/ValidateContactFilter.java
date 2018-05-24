package com.unisys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import co.vinod.entity.Contact;

@WebFilter("/save-contact")
public class ValidateContactFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// convert request params in to a Contact instace:
		Contact c = new Contact();
		c.setId(Integer.parseInt(request.getParameter("id")));
		c.setFirstname(request.getParameter("firstname"));
		c.setLastname(request.getParameter("lastname"));
		c.setGender(request.getParameter("gender"));
		c.setEmail(request.getParameter("email"));
		c.setPhone(request.getParameter("phone"));
		c.setCity(request.getParameter("city"));
		c.setState(request.getParameter("state"));
		c.setCountry(request.getParameter("country"));
		
		String strDob = request.getParameter("dob");
		
		// in case of any validation errors, we rediect to the contact-form.jsp
		// where it uses ${contact.blah}
		request.setAttribute("contact", c);
		
		// check for :
		// mandatory fields - firstname, email, phone
		// if dob is found, must be a valid java.utl.Date in yyyy-MM-dd format
		
		Map<String, String> errors = new HashMap<String, String>();
		if(c.getFirstname().trim().length()==0){
			errors.put("firstname", "Firstname is mandatory");
		}
		if(c.getEmail().trim().length()==0){
			errors.put("email", "Email is mandatory");
		}
		if(c.getPhone().trim().length()==0){
			errors.put("phone", "Phone is mandatory");
		}
		if(strDob.trim().length()>0){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				c.setDob(sdf.parse(strDob));
			} catch (Exception e) {
				errors.put("dob", "Invalid date. Please enter in YYYY-MM-DD format");
			}
		}
		
		if(errors.size()>0){
			// forward to the contact-form.jsp with errors
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/pages/contact-form.jsp")
				.forward(request, response);
		}
		else {
			// continue to the target servlet
			chain.doFilter(request, response);
		}
		

		
	}

	public void destroy() {
	}
}






