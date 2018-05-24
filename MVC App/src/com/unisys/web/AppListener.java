package com.unisys.web;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent evt) {
		System.out.println("Started the bootstrap for the MVC-App application...");
		ServletContext appScope = evt.getServletContext();
		ResourceBundle rb = ResourceBundle.getBundle("com.unisys.props.users");
		appScope.setAttribute("users", rb);
	}

	public void contextDestroyed(ServletContextEvent evt) {
		System.out.println("Shutting down the MVC-App application...");
	}

}
