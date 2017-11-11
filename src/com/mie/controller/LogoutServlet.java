package com.mie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	/**
	 * This class handles all aspects of the logout action.
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * When the user logs out of the system, redirect them to the public
		 * home page (index.jsp).
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//is this the right page?
		request.getRequestDispatcher("index.jsp").include(request, response);

		/**
		 * Invalidate the current member's session and set its status to false.
		 */
		HttpSession session = request.getSession(false);
		session.invalidate();

		/**
		 * Print out a message indicating the user has been logged out.
		 */
		out.print("You are successfully logged out!");

		out.close();
	}
}