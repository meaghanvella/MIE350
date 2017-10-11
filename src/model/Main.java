package model;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
	public static Connection dbCon;
	public static StudentList students;
	public static StartUpRepList reps;
	public static StartupList startups;
	public static HashMap<String, String> skills;
	public static ArrayList<String> majors;
	public static ArrayList<String> industries;
	public static ArrayList<String> locations;
	public static ArrayList<String> hiring;

	
	public static void main(String[] args) {
	//copied from CMS
		
		dbCon = null;
		try {
			Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException cfe) {
			System.out.println("Failed loading the JDBC driver.");
			cfe.printStackTrace();
		}
		try {
			dbCon = DriverManager.getConnection(DBConstants.DB_CrsSystem);
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		try {
			dbCon.setAutoCommit(false); // to manage a transaction with multiple
										// SQL statements
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		//Create student account test code 
		/*
		students = new StudentList();
		ArrayList<Object> s = new ArrayList<Object>();
		ArrayList<String> industryInterest = new ArrayList<String>();
		ArrayList<String> skills = new ArrayList<String>();
		
		s.add("ct.nguyen@mail.utoronto.ca");
		s.add("claudia nguyen");
		s.add("password123");
		s.add("Third year Indy, unhireable");
		s.add("Indy");
		industryInterest.add("finance");
		industryInterest.add("technology");
		s.add(industryInterest);
		skills.add("Java");
		skills.add("Project Management");
		skills.add("C");
		skills.add("Simul8");
		s.add(skills);
		s.add("9057771111");
		s.add("2019");
		
		Iterator<Object> it = s.iterator();
		
		CreateStudentCommand c = new CreateStudentCommand();
		c.execute(it);
		*/
		//end create student account test code
		
		//copied from CMS
		try {
			dbCon.commit();
			dbCon.close();
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		
	}
	
	//copied from CMS
	public static boolean runUpdate(String qStr) {
		String queryString = qStr;
		boolean result = false;
		Statement statement;
		PreparedStatement preparedStatement;
		if (dbCon == null) {
			return result;
		}
		try {
			statement = dbCon.createStatement();
			preparedStatement = dbCon.prepareStatement(queryString);
			preparedStatement.execute();
			result = true;
			statement.close();
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}

		return result;
	}
	
	//copied from CMS
	public static ResultSet runSelect(String qStr) {
		String queryString = qStr;
		ResultSet inputList = null;
		Statement statement;
		if (dbCon == null) {
			return inputList;
		}
		try {
			statement = dbCon.createStatement();
			inputList = statement.executeQuery(queryString);
		} catch (SQLException se) {
			SQLExceptionHandler.handleException(se);
		}
		return inputList;
	}
	
 /*  need to populate the Collections for this instance of the 
  * program; these methods will use runselect to get tuples from 
  * db and add them to the appropriate Collection*/
	public static void readInStudents(){}
	public static void readInReps(){}
	public static void readInStartups(){}
	public static void readInSkills(){}
	public static void readInMajors(){}
	public static void readInIndustries(){}
	public static void readInLocations(){}
	public static void readInHiringStatus(){}

	/*Iterators*/
	public static Iterator returnIteratorForStudentList(){return null;}
	public static Iterator returnIteratorForStartupList(){return null;}
	public static Iterator returnIteratorForRepList(){return null;}
	
	/*Inserting into db*/
	public static void insertStudent(Student s){
		students.Insert(s);
	} //calls StudentList to insert the student tuple into  db
	public static boolean insertStartup(){return false;} //calls StartupList to insert the startup tuple into db
	public static boolean insertStartupRep(){return false;} //calls StartupRepList to insert the startup rep tuple into db
	public static boolean insertLoginfo(){return false;} //calls DigestHash to insert the login/digest tuple into the db
	
	
	/*Adding to Collections*/
	public static void addStudent(Student s){students.add(s);} //adds student into Studentlist map 
	public static boolean addStartup(){return false;} //adds startup into StartupList map 
	public static boolean addStartupRep(){return false;} //adds rep into StartupRepList map
	public static boolean addLoginfo(String email, String encryptedPassword){return false;} //adds Loginfo into DigestHash map 

	/*Functionality-related*/
	public static boolean verifyPassword(){return false;} //calls disgests.verifyPassword given username and password input

	
	/*need to add more – all commands will have a corresponding 
	 * method in Main to connect with Collections stored in main*/


}
