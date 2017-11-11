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

import com.mie.dao.StudentDao;
import com.mie.model.Student;

public class StudentController extends HttpServlet {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. 
	 * INSERT leads to the Create A Student page. 
	 * EDIT leads to the Edit A Student page.
	 * HOME leads to Student's home page.
	 //* LIST_STUDENT_PUBLIC leads to the public listing of students.
	 //* LIST_STUDENT_ADMIN leads to the admin-only listing of students (for them to modify student information).
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/studentSignup.jsp";
	private static String EDIT = "/editStudent.jsp";
	private static String HOME = "/StudentHome.jsp";
	private static String INSERT_SUCCESS = "";
	private static String EDIT_SUCCESS = "";

	private StudentDao dao;

	/**
	 * Constructor for this class.
	 */
	public StudentController() {
		super();
		dao = new StudentDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - INSERT will direct the servlet to let the user add a new student to the database. 
		 * - EDIT will direct the servlet to let the user edit student information in the database. 
		 * - HOME will direct the servlet to student's home page
		 //* - delete will direct the servlet to let the user delete a student in the database.
		 //* - listStudent will direct the servlet to the public listing of all students in the database. 
		 //* - listStudentAdmin will direct the servlet to the admin listing of all students in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			//assuming we get this from the session???
			String email = request.getParameter("Email");
			Student student = dao.getStudentByEmail(email);
			request.setAttribute("student", student);
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the createStudent.jsp or the editStudent.jsp pages.
		 */
		Student s = (Student) request.getAttribute("student");
		String forward="";

		if(s == null){
			s = new Student();
			s.setName(request.getParameter("Email"));
			s.setYear(request.getParameter("Name"));
			s.setMajor(request.getParameter("Position"));
			s.setPassword(request.getParameter("Introduction"));
			s.setEmail(request.getParameter("Password"));
			
			dao.addStudent(s);
			forward = INSERT_SUCCESS;
		}else{//we're editing now! woo!
			s.setName(request.getParameter("Email"));
			s.setYear(request.getParameter("Name"));
			s.setMajor(request.getParameter("Position"));
			s.setPassword(request.getParameter("Introduction"));
			dao.updateStudent(s);  
			forward = EDIT_SUCCESS;
		}
		

		/**
		 * Once the student has been added or updated, the page will redirect to
		 * the listing of students.
		 */
		// Note: It should redirect to the student page
		RequestDispatcher view = request.getRequestDispatcher(HOME);
		view.forward(request, response);
	}
}