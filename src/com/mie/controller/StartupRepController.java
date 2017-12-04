package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.dao.CompanyDao;
import com.mie.dao.StartupRepDao;
import com.mie.dao.StudentDao;
import com.mie.model.Company;
import com.mie.model.StartupRep;
import com.mie.model.Student;

public class StartupRepController extends HttpServlet{
	/**
	 * This class handles startup rep profile add and edit functionality.
	 */
	private static final long serialVersionUID = 1L;
	private StartupRepDao dao;
	private CompanyDao companyDao;
	
	private static String INSERT = "/repSignup.jsp";
	private static String CREATE_SUCCESS = "/signupRedirect.jsp";
	private static String CREATE_FAILURE = "/incorrectSignup.jsp";
	private static String EDIT_SUCCESS = "/repHome.jsp";


	/**
	 * Constructor for the class
	 **/
	public StartupRepController() {
		super();
		dao = new StartupRepDao();
		companyDao = new CompanyDao();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		/**
		 * This method forwards the user to the rep signup page if the action = insert
		 * **/
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			//get all companies for dropdown list
			List<Company> companies = companyDao.getAllCompanies();
			request.setAttribute("startups", companies);
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the repHome.jsp or the repSignup.jsp (through modal) pages.
		 */

		HttpSession session = request.getSession(true);
		StartupRep s = (StartupRep) session.getAttribute("startup rep");
		String forward="";
		
		//if the startup rep doesn't exist, s is null
		//the following block adds the startup rep profile to the database
		
		if(s == null){
			//if startup rep already exists, do not try to add the user
			if(dao.startupRepExistsWithEmail(request.getParameter("Email"))){
				forward = CREATE_FAILURE;
			}else{
				s = new StartupRep();
				s.setEmail(request.getParameter("Email"));
				s.setName(request.getParameter("Name"));
				s.setPosition(request.getParameter("Position"));
				s.setIntroduction(request.getParameter("Introduction"));
				s.setPassword(request.getParameter("Password"));
				String startupId = request.getParameter("Startup");
				try {
					s.setStartupID(Integer.parseInt(startupId));
					dao.addStartupRep(s);
					forward = CREATE_SUCCESS;
				} catch (NumberFormatException e){
					forward = INSERT;
				}
			}

		}else{
			//if the startup rep exists, then edit
			s.setName(request.getParameter("Name"));
			s.setPosition(request.getParameter("Position"));
			s.setIntroduction(request.getParameter("Introduction"));
			s.setPassword(request.getParameter("Password"));
			dao.updateStartupRep(s);  
			forward = EDIT_SUCCESS;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}
