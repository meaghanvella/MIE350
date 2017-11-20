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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//insert invalid login
	private static String INVALID_LOGIN = "index.jsp";
	private static String STUDENT_LOGGED = "/StudentHome.jsp";
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
					StudentDao d = new StudentDao();
					Student s= d.getStudentByEmail(u.getEmail());
					session.setAttribute("student", s);
					forward = STUDENT_LOGGED;
				}
				else if((u.getType()).equals("startup rep")){
					//redirect to startup dashboard
					//response.sendRedirect("startupLogged.jsp");
					StartupRepDao d = new StartupRepDao();
					StartupRep s = d.getStartupRepByEmail(u.getEmail());
					session.setAttribute("startup rep", s);
					forward = STARTUP_LOGGED;

				}
			}else {
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
