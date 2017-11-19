package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.FailedLoginException;

import com.mie.model.Student;
import com.mie.util.DbUtil;

public class StudentDao {
	/**
	 * This class handles all of the Student-related methods
	 * (add/update/delete/get).
	 */
	
	private Connection connection;
	
	//claudia: need these static fields to support static method login
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	
	public StudentDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void addStudent(Student student) {
		/**
		 * This method adds a new student to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Student(Name,Year,Major,Email,Password,Phone) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getYear());
			preparedStatement.setString(3, student.getMajor());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getPhone());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStudent(Student student) {
		/**
		 * This method updates a student's information into the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Student set Name=?, Year=?, Major=?, Email=?, Password=?, Phone=?"
							+ " where Email=?");
			// Parameters start with 1
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getYear());
			preparedStatement.setString(3, student.getMajor());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.setString(7, student.getEmail());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//claudia: ???? I don't think we need this??? 
	public List<Student> getAllStudents() {
		/**
		 * This method returns the list of all students in the form of a List
		 * object.
		 */
		List<Student> students = new ArrayList<Student>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting students from table");
			ResultSet rs = statement.executeQuery("select * from Student");
			while (rs.next()) {
				Student student = new Student();
				student.setName(rs.getString("Name"));
				student.setYear(rs.getString("Year"));
				student.setMajor(rs.getString("Major"));
				student.setEmail(rs.getString("Email"));
				student.setPassword(rs.getString("Password"));
				student.setPhone(rs.getString("Phone"));
				students.add(student);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return students;
	}
	
	public Student getStudentByEmail(String email){
		Student student = new Student();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Student where email=?");
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				student.setName(rs.getString("Name"));
				student.setYear(rs.getString("Year"));
				student.setMajor(rs.getString("Major"));
				student.setEmail(rs.getString("Email"));
				student.setPassword(rs.getString("Password"));
				student.setPhone(rs.getString("Phone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}
	
//	//claudia: adding this to facilitate login functionality
//	public static Student login(String un, String pwd) throws FailedLoginException{
//		Student s = new Student();
//		Statement stmt = null;
//		
//		String searchQuery = "select * from Student where Email='"
//				+ un + "' AND Password='" + pwd + "'";
//		
//		try {
//			// connect to DB
//			currentCon = DbUtil.getConnection();
//			stmt = currentCon.createStatement();
//			rs = stmt.executeQuery(searchQuery);
//			boolean more = rs.next();
//
//			/**
//			 * If there are no results from the query, set the member to false.
//			 * The person attempting to log in will be redirected to the home
//			 * page when isValid is false.
//			 */
//			
//			if (!more) {
//				throw new FailedLoginException();
//			}
//
//			/**
//			 * If the query results in an database entry that matches the
//			 * username and password, assign the appropriate information to
//			 * the Member object.
//			 */
//			else if (more) {
//				String email = rs.getString("Email");
//				String password = rs.getString("Password");
//
//				member.setFirstName(firstName);
//				member.setLastName(lastName);
//				member.setValid(true);
//			}
//		}

//		catch (Exception ex) {
//			System.out.println("Log In failed: An Exception has occurred! "
//					+ ex);
//		}
//
//		return s;
//	}
//	
//claudia: commenting this out in case we need it later!
//	public Student getStudentById(int studentid) {
//		/**
//		 * This method retrieves a student by their StudentID number.
//		 * 
//		 * Currently not used in the sample web app, but code is left here for
//		 * your review.
//		 */
//		Student student = new Student();
//		try {
//			PreparedStatement preparedStatement = connection
//					.prepareStatement("select * from students where studentid=?");
//			preparedStatement.setInt(1, studentid);
//			ResultSet rs = preparedStatement.executeQuery();
//
//			if (rs.next()) {
//				student.setStudentid(rs.getInt("studentid"));
//				student.setFirstName(rs.getString("firstname"));
//				student.setLastName(rs.getString("lastname"));
//				student.setDob(rs.getDate("dob"));
//				student.setEmail(rs.getString("email"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return student;
//	}

}