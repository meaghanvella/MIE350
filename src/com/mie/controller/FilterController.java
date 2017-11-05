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

public class FilterController extends HttpServlet {
	//This class is supposed to handle the following:
		//1) Spitting out all of the startups A-Z 
		//2) Spitting out 
	
	private static String search_companies = "insert url.jsp";
	private CompanyDao companyDao;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//So...this method should be responsible for taking in criteria selections
		
		List<String> industries = request.getParameter("industries");
		List<String> locations = request.getParameter("locations");
		
		//And...I think this is all it should do???? 
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This method should be responsible for actually spitting out the search results... 
		List<String> industries = request.getParameter("industries");
		List<String> locations = request.getParameter("locations");
		
		request.setAttribute("industries", industries);
		request.setAttributes("locations", locations);
		
		//Then, i guess the following is the output....:
		request.setAttributes("companies", companyDao.filter(industries, locations));
		
	}
	
	

	

}
