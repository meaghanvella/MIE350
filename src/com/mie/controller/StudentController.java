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
import javax.servlet.http.HttpSession;

import com.mie.dao.IndustryDao;
import com.mie.dao.StudentDao;
import com.mie.model.StartupRep;
import com.mie.model.Student;

public class StudentController extends HttpServlet {
	/**
	 * This class handles student profile add and edit functionality.
	 */
    private static final long serialVersionUID = 1L;
	private static String INSERT = "/studentSignup.jsp";
	private static String INSERT_SUCCESS = "/signupRedirect.jsp";
	private static String EDIT_SUCCESS = "/studentHome.jsp";

	private StudentDao dao;
	private IndustryDao industryDao;

	/**
	 * Constructor for this class.
	 */
	public StudentController() {
		super();
		dao = new StudentDao();
		industryDao = new IndustryDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * This method forwards the user to the studentSignup page if the action = insert 
		 */
		
		String forward = "";
		String action = request.getParameter("action");
		
		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			request.setAttribute("industry", industryDao.getAllIndustries());
		} 
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves the information entered by the user in either studentSignup 
		 * (profile add) or studentHome (profile edit though modal) pages 
		 */
		
		HttpSession session = request.getSession(true);
		Student s = (Student) session.getAttribute("student");
		String forward="";
		
		//if the student doesn't exist, s is null
		//the following block adds the student profile to the database
		if(s == null){
			s = new Student();
			s.setName(request.getParameter("Name"));
			s.setYear(request.getParameter("Year"));
			s.setMajor(request.getParameter("Major"));
			s.setPassword(request.getParameter("Password"));
			s.setEmail(request.getParameter("Email"));
			
			dao.addStudent(s);
			forward = INSERT_SUCCESS;
		}else{
		//if the student exists, then edit
			s.setName(request.getParameter("Name"));
			s.setYear(request.getParameter("Year"));
			s.setMajor(request.getParameter("Major"));
			s.setPassword(request.getParameter("Password"));
			dao.updateStudent(s);  
			forward = EDIT_SUCCESS;
		}
		
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}
}