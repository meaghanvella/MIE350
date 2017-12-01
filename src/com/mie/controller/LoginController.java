package com.mie.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.StartupRepDao;
import com.mie.dao.StudentDao;
import com.mie.dao.UserDao;
import com.mie.model.StartupRep;
import com.mie.model.Student;
import com.mie.model.User;

public class LoginController extends HttpServlet {
	/**
	 * This class handles the login functionality for both startup rep and student users.
	 */
	private static final long serialVersionUID = 1L;
	//insert invalid login
	private static String INVALID_LOGIN = "index.jsp";
	private static String STUDENT_LOGGED = "/studentHome.jsp";
	//insert startup home page
	private static String STARTUP_LOGGED = "/repHome.jsp";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */		
		String forward = "";
		User u = new User();
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		
		try {
			/**
			 * Try to see if the member can log in.
			 */
			/**
			 * If the isValid value is true, assign session attributes to the
			 * current user.
			 */
			
			//the user class is used to allow both startup reps and students to use the same login form
			u = UserDao.login(un,pw);

			if (u.isValid()) {
				HttpSession session = request.getSession(true);

				session.setAttribute("currentSessionUser", u);
				session.setAttribute("username", u.getEmail());
				session.setAttribute("type", u.getType());
				/**
				 * Check type of user using getType method in User
				 */
				if((u.getType()).equals("student")){
					//redirect to student dashboard
					StudentDao d = new StudentDao();
					Student s= d.getStudentByEmail(u.getEmail());
					session.setAttribute("student", s);
					forward = STUDENT_LOGGED;
				}
				else if((u.getType()).equals("startup rep")){
					//redirect to startup dashboard
					StartupRepDao d = new StartupRepDao();
					StartupRep s = d.getStartupRepByEmail(u.getEmail());
					session.setAttribute("startup rep", s);
					forward = STARTUP_LOGGED;

				}
			}else {
				//if invalid user, redirect to index.jsp
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
