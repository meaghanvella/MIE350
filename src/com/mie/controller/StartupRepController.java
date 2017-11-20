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
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StartupRepDao dao;
	private CompanyDao companyDao;
	//page for inserting startuprep
	private static String INSERT = "/repSignup.jsp";
	//page for editing startuprep
	//redirect if proper account creation
	private static String CREATE_SUCCESS = "/signupRedirect.jsp";
	//redirect if edit success
	private static String EDIT_SUCCESS = "/repHome.jsp";

	public StartupRepController() {
		super();
		dao = new StartupRepDao();
		companyDao = new CompanyDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
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
		 * the addStudent.jsp or the editStudent.jsp pages.
		 */

		HttpSession session = request.getSession(true);
		StartupRep s = (StartupRep) session.getAttribute("startup rep");
		String forward="";
		//if we're inserting, s is null
		if(s == null){
			s = new StartupRep();
			s.setEmail(request.getParameter("Email"));
			s.setName(request.getParameter("Name"));
			s.setPosition(request.getParameter("Position"));
			s.setIntroduction(request.getParameter("Introduction"));
			s.setPassword(request.getParameter("Password"));
			String startupName = request.getParameter("Startup");
			s.setStartup(startupName);
			s.setStartupID(companyDao.getCompanyIDByName(startupName));
			dao.addStartupRep(s);
			forward = CREATE_SUCCESS;
		}else{//we're editing now! woo!
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
