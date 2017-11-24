package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CompanyDao;
import com.mie.model.Company;

public class SearchController {
	
	//Adopted from the MIE 350 sample application code 
	//waiting on Meaghan, tbh....
	
	private static final long serialVersionUID = 1L;
	private static String SEARCH_COMPANY = "/SearchStartupResult.jsp";
	//^^^Fill in with the appropriate JSP page afterwards 
	private CompanyDao dao;
	
	/**
	 * Constructor for the class 
	 */
	public SearchController() {
		super();
		dao = new CompanyDao();
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	/**
	 * Responsible for retrieving the search term entered by the user
	 */
		String keyword = request.getParameter("keyword");
		RequestDispatcher view = request.getRequestDispatcher(SEARCH_COMPANY);
		request.setAttribute("keyword", keyword);
		request.setAttribute("startup", dao.searchCompanyByKeyword(keyword));
		
		//Redirect to the results page: 
		view.forward(request, response);
	}
	
	//there are two key variables above 
	

}
