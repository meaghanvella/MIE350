package com.mie.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.UserDao;
import com.mie.model.User;
//done by claudia: 
//SOME NOTES:
//TO DO: add proper redirect pages and figure out which session attributes to assign
//this class takes input from the login jsp through the parameters "un" and "pw" for username and password
//this class assigns the session attributes username and type according to login information and user type (student or startup)
public class LoginController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		User u = new User();
		
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		u = UserDao.login(un,pw);
		
		try {
			/**
			 * Try to see if the member can log in.
			 */
			/**
			 * If the isValid value is true, assign session attributes to the
			 * current member.
			 */
			if (u.isValid()) {
				HttpSession session = request.getSession(true);
				//claudia: tbh, not sure where these are used later...
				//pls add a note if they are (if not, can delete)
				session.setAttribute("currentSessionUser", u);
				session.setAttribute("username", u.getEmail());
				session.setAttribute("type", u.getType());
				/**
				 * Redirect to the members-only home page.
				 */
				if((u.getType()).equals("student")){
					//redirect to student dashboard
					response.sendRedirect("StudentLoginSuccess.jsp");
					
				}
				else if((u.getType()).equals("startup rep")){
					//redirect to startup dashboard
					//response.sendRedirect("startupLogged.jsp");
				}
			}

			else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
				response.sendRedirect("invalidLogin.jsp");
			}

		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
	
	

}
