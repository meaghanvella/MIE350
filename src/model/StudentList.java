package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class StudentList{
private HashMap<String, Student> map = new HashMap<String, Student>();
	
	public void add(Student s){
		map.put(s.getEmail(), s);
	}  //adds a User object to the corresponding student hashmap)
	
	public boolean get(){return false;} //returns a user based on email
	public Iterator iterator(){return null;} //returns an iterator of users (to be used in search?)
	
	
	public void Insert(Student s) {
		//for every industry interest value and skill
		ArrayList<String> skills = s.getSkills();
		ArrayList<String> industryInterest = s.getIndustryInterest();
		String skill;
		String interest = "";
		
		for(String sk: skills){
			for(String i: industryInterest){
				String qStr= "INSERT INTO students Values ('" + s.getEmail() + "', '" + s.getName() + "', '" + s.getDigest()
						+ "', '" + s.getDesc() + "', '" + s.getMajor() + "', '" + i + "', '" + sk + "', '" + s.getPhoneNumber() + "', '" + s.getGraduatingYear() + "')";
				Main.runUpdate(qStr);
			}
			
		}
		
		
	}
}
