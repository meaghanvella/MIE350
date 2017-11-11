package com.mie.controller;

import com.mie.dao.CompanyDao;

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

public class FilterController extends HttpServlet {
	//This class is supposed to handle the following:
		//1) Spitting out all of the startups A-Z 
		//2) Spitting out filtered results of companies  
	
	private static String FILTERED_RESULTS = "/filteredResults.jsp";
	private CompanyDao companyDao;
	
	//Constructor:
	public FilterController() {
		super();
		companyDao = new CompanyDao();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This method should be responsible for taking in criteria selections
		
		Object industries = request.getAttribute("industries"); //assume it's called "industries"
		Object locations = request.getAttribute("locations"); //assume it's called "locations" 
		
		RequestDispatcher view = request.getRequestDispatcher(FILTERED_RESULTS);
		
		request.setAttributes("companies", companyDao.filter(industries, locations));
		//NOTE: All of the edge cases and conditional checks are accounted for within the filter function 
		
		//Finally, redirect to the results page once the filtered set of companies has been retrieved:
		view.forward(request, response); 
		
	}
	
	
	

	

}
