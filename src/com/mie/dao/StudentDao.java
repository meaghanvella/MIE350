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
	 * This class handles all of the interaction with the Student Table including:
	 * - insert
	 * - update
	 * - getting student by email
	 */
	
	private Connection connection;
	
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
			preparedStatement.setString(6, student.getIndustry());
			
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
					.prepareStatement("update Student set Name=?, Year=?, Major=?, Email=?, Password=?, Industry=?"
							+ " where Email=?");
			// Parameters start with 1
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getYear());
			preparedStatement.setString(3, student.getMajor());
			preparedStatement.setString(4, student.getEmail());
			preparedStatement.setString(5, student.getPassword());
			preparedStatement.setString(6, student.getIndustry());
			preparedStatement.setString(7, student.getEmail());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student getStudentByEmail(String email){
		/**
		 * This method gets a student by their email.
		 */
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
				student.setIndustry(rs.getString("Industry"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return student;
	}
	

}