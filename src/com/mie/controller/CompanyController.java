package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CompanyDao;
import com.mie.model.Company;

public class CompanyController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String LIST_COMPANY_PUBLIC = "/StartupList.jsp";
	private static String VIEW_COMPANY_PUBLIC = "/ViewCompany.jsp";

	private CompanyDao dao;

	/**
	 * Constructor for this class.
	 */
	public CompanyController() {
		super();
		dao = new CompanyDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 *  - listCompany will
		 * direct the servlet to the public listing of all companies in the
		 * database. 
		 */
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("listCompany")) {
			forward = LIST_COMPANY_PUBLIC;
			request.setAttribute("Company", dao.getAllCompanies());
		} 
		else if(action.equalsIgnoreCase("viewPage")) {
			forward = VIEW_COMPANY_PUBLIC;
			int startupID = Integer.parseInt(request.getParameter("startupID"));
			request.setAttribute("startup", dao.getCompanyByID(startupID));
		}
	
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

}