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
	private static String INVALID_LOGIN = "/invalidLogin.jsp";
	private static String STUDENT_LOGGED = "/studentLoginSuccess.jsp";
	private static String STARTUP_LOGGED = "/startupLoginSuccess.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */		
		String forward = "";
		User u = new User();
		String un = request.getParameter("un");
		System.out.println(un);
		String pw = request.getParameter("pw");
		
		try {
			/**
			 * Try to see if the member can log in.
			 */
			/**
			 * If the isValid value is true, assign session attributes to the
			 * current member.
			 */
			u = UserDao.login(un,pw);

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
					forward = STUDENT_LOGGED;
				}
				else if((u.getType()).equals("startup rep")){
					//redirect to startup dashboard
					//response.sendRedirect("startupLogged.jsp");
					forward = STARTUP_LOGGED;

				}
			}

			else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
				forward = INVALID_LOGIN;
			}
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}

}
