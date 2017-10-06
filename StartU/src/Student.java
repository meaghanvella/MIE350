import java.util.ArrayList;
import java.util.Iterator;


public class Student extends User{
	private String major;
	private ArrayList<String> industryInterest;
	private ArrayList<String> skills;
	private String phoneNumber;
	private String graduatingYear;
	
	@Override
	public void init(Iterator args){//used for both update and add functionalities
		super.init(args);
		this.major = (String) args.next();
		this.industryInterest = (ArrayList<String>) args.next();
		this.skills = (ArrayList<String>) args.next();
		this.phoneNumber = (String) args.next();
		this.graduatingYear = (String) args.next();		
	} //will initialize and then add values ***if using iterator, need to make sure matches db order
	
	public void update(Student s){} //given new Student as input, will find Student associated with input email, create query to edit info and send to Main.runUpdate (need to add student casts)
	
	public void readNewStudentLoginfo(Iterator args){
		init(args);
	}

	public String getMajor() {
		// TODO Auto-generated method stub
		return this.major;
	}

	public ArrayList<String> getIndustryInterest() {
		// TODO Auto-generated method stub
		return industryInterest;
	}

	public ArrayList<String> getSkills() {
		// TODO Auto-generated method stub
		return skills;
	}


	public String getPhoneNumber() {
		// TODO Auto-generated method stub
		return this.phoneNumber;
	}

	public String getGraduatingYear() {
		// TODO Auto-generated method stub
		return this.graduatingYear;
	}
	
	
}
