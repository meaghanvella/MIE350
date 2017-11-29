package com.mie.model;

public class Company {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Company object.
	 */

	private String Name;
	private String Location;
	private String Industry;
	private int StartupID;
	private String Description;
	private String Size;
	private String Website;
	private String Hiring_Status;
	private String Stage;
	private String logo;
	
	public String getLogo(){
		return logo;	
	}
	
	public String getStage(){
		return Stage;
	}
	
	public String getHiring_Status(){
		return Hiring_Status;
	}
	
	public String getWeb(){
		return Website;
	}
	
	public String getSize(){
		return Size;
	}
	
	public int getID(){
		return StartupID;
	}
	
	public String getDescription(){
		return Description;
	}

	public String getName() {
		return Name;
	}

	public String getLocation() {
		return Location;
	}

	public String getIndustry() {
		return Industry;
	}
	
	public void setName(String newName) {
		this.Name = newName;
	}
	
	public void setLocation(String newLocation) {
		this.Location = newLocation;
	}
	
	public void setIndustry(String newIndustry) {
		this.Industry = newIndustry;
	}
	
	public void setID(int newID) {
		this.StartupID = newID;
	}
	
	public void setDescription (String newDescription) {
		this.Description = newDescription;
	}
	
	public void setSize(String newSize) {
		this.Size = newSize;
	}
	
	public void setWebsite (String newWeb) {
		this.Website = newWeb;
	}
	
	public void setHiring_Status (String newStatus) {
		this.Hiring_Status = newStatus;
	}

	public void setStage (String newStage) {
		this.Stage = newStage;
	}
	
	public void setLogo (String newLogo){
		this.logo=newLogo;
	}

	@Override
	public String toString() {
		return "Company [Company=" + Name + ", Location=" + Location
				+ ", Industry=" + Industry + "]";
	}
}
