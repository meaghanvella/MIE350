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

public class IndustryController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static String SEARCH_COMPANY = "/SearchStartupResult.jsp";
 
	private CompanyDao dao;
	
	/**
	 * Constructor for the class 
	 */
	public IndustryController() {
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
		request.setAttribute("startup", dao.getCompanyByIndustry(keyword));
		request.setAttribute("page", 1);
		
		
		//Redirect to the results page: 
		view.forward(request, response);
	}
	
	//there are two key variables above 
	

}
