package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Company;
import com.mie.util.DbUtil;

public class CompanyDao {
	/**
	 * This class handles all of the Company-related methods
	 * (Display 1 or display all)
	 */
	
	public CompanyDao() {
		connection = DbUtil.getConnection();
	}
	
	private Connection connection;
	
	//The following method returns a SINGLE company object based on the ID
	//This is supposed to be used when conjuring the company's info page 
	public Company getCompanyByID(int ID) {
		
		Company company = new Company();
		
		try {
			String query = "SELECT * FROM Startup WHERE StartupID=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setInt(1, ID);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return company;
	}
	
	//The following method returns ALL companies in the database sorted alphabetically (by name)
	public List<Company> getAllCompanies() {
		/**
		 * This method returns the list of all companies in the form of a List
		 * object.
		 */
		List<Company> companies = new ArrayList<Company>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM Startup ORDER BY Name");
			while (rs.next()) {
				Company company = new Company();
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
				
				companies.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return companies;
	}
	
	
public List<Company> getCompanyByIndustry(String industry) {
		
		
		List<Company> companies = new ArrayList<Company>();
		try {
			String query = "SELECT * FROM Startup WHERE Industry=?";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1, industry);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Company company = new Company();
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
				
				companies.add(company);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return companies;
	}
	
	public List<Company> filter_single(String industry, String location) {
		List<Company> companies = new ArrayList<Company>();
		try {
			//Just need to account for the different cases here: 
			//For now, let's just suppose that if either of industry or location is not selected...
			//then that means we're getting a "" empty string
			//I'm sure there's a way to make parameters optional (and then subsequently check...
			//to see if those parameters were passed in or not 
			
			//We're going to go with .isEmpty() to check this (for now)
			
			ResultSet rs = null;
			
			//1) Something from both is selected
			if (!(industry.isEmpty()) && !(location.isEmpty())) {
				String query = "SELECT * FROM Company WHERE (Industry=?) OR (Location=?)";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, industry);
				pst.setString(2, location);
				rs = pst.executeQuery();
			}
			//2) Only an Industry is selected
			else if (!(industry.isEmpty()) && location.isEmpty()) {
				String query = "SELECT * FROM Company WHERE (Industry=?)";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, industry);
				rs = pst.executeQuery();
			}
			//3) Only a Location is selected
			else if (industry.isEmpty() && !(location.isEmpty())) {
				String query = "SELECT * FROM Company WHERE (Location=?)";
				PreparedStatement pst = connection.prepareStatement(query);
				pst.setString(1, location);
				rs = pst.executeQuery();
			}
			//4) Nothing is selected 
			else {
				String query = "SELECT * FROM Company";
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(query);
			}
			
			//At this point, we should have a result set and we can populate the companies list:
			while(rs.next()) {
				Company company = new Company();
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
				
				//Finally...just add this Company object into the list: 
				companies.add(company);
			}
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return companies;
	}
	
	
	public ArrayList<Company> searchCompanyByKeyword(String keyword) {
		ArrayList<Company> results = new ArrayList<Company>();
		
		try {
			
			String query = "SELECT * FROM Startup WHERE Name LIKE ? OR Description LIKE ? OR Location LIKE ? OR Industry LIKE ? OR Stage LIKE ?;";
			PreparedStatement prep = connection.prepareStatement(query);
			prep.setString(1, "%" + keyword + "%");
			prep.setString(2, "%" + keyword + "%");
			prep.setString(3, "%" + keyword + "%");
			prep.setString(4, "%" + keyword + "%");
			prep.setString(5, "%" + keyword + "%");
			
			//Execute query & generate result set: 
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()) {
				Company company = new Company();
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
				
				results.add(company);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	
	
	
	//Next, we need a method that will conjure a set of companies according to certain filters
	public List<Company> filter(List<String> industry_criteria, List<String> location_criteria) {
		
		List<Company> companies = new ArrayList<Company>();
		int num_industry_criteria = industry_criteria.size();
		int num_location_criteria = location_criteria.size();
				
		try {
			
			String query = "SELECT * FROM Company";
			
			ResultSet rs = null;
			
			//You know what...let's just break this down into the 4 cases: 
			
			//1) BOTH are EMPTY
			if((num_industry_criteria == 0) && (num_location_criteria == 0)) {
				//Just return ALL startups sorted A-Z
				query = query + " SORT BY Name";
				Statement stmt = connection.createStatement();
				rs = stmt.executeQuery(query);
			}
			
			//2) BOTH are NON-ZERO
			else if((num_industry_criteria > 0) && (num_location_criteria > 0)) {
				
				//FIRST, handle all of the industry criteria:
				query = query + " WHERE (Industry=";
				for(int i=0; i < num_industry_criteria; i++) {
					query = query + "?)";
					//Next, just check to see if we're on the last entry again: 
					if(!(i == (num_industry_criteria - 1))) {
						//In this case, we are NOT done yet and need to set up the next criteria entry: 
						query = query + " OR Industry=";
					}
				}
				
				//Next, handle all of the location criteria: 
				query = query + " AND (Location=";
				for(int i=0; i < num_location_criteria; i++) {
					query = query + "?)";
					//Next, just check to see if we're on the last entry again: 
					if(!(i == (num_location_criteria - 1))) {
						//In this case, we are NOT done yet and need to set up the next criteria entry: 
						query = query + " OR Location=";
					}
				}
				
				
				//At this point, that one big prepared statement is all done...
				//Next, would be actually setting the parameters for the prepared statement: 
				PreparedStatement pst = connection.prepareStatement(query);
				
				int j=0;
				for(int i=0; i < num_industry_criteria; i++) {
					pst.setString((i+1), industry_criteria.get(i));
					j = i+1;
				}
				
				//Next, we need to add in all of the location criteria (while being mindful of the index): 
				//Let's make an statement index variable...
				int pst_index = j+1;
				for(int k=0; k < num_location_criteria; k++) {
					pst.setString(pst_index, location_criteria.get(k));
					pst_index = pst_index + 1;
				}
				
				//So...hopefully at this point, all of the parameters have been set 
				//If the above is true, then we can actually go ahead and exute the query: 
				rs = pst.executeQuery();
				
			}
			
			
			//3) Only Industry Criteria
			else if((num_industry_criteria > 0) && (num_location_criteria == 0)) {
				
				query = query + " WHERE Industry=";
				
				for(int i=0; i < num_industry_criteria; i++) {
					query = query + "?";
					//Next, just check to see if we're on the last entry again: 
					if(!(i == (num_industry_criteria - 1))) {
						//In this case, we are NOT done yet and need to set up the next criteria entry: 
						query = query + " OR Industry=";
					}
				}
				
				//Okay, now that the prepared statement string is there, we can actually create the object:
				PreparedStatement pst = connection.prepareStatement(query);
				
				//Now, of course, we need to actually set all of the parameters for the query...
				for(int i=0; i < num_industry_criteria; i++) {
					pst.setString((i+1), industry_criteria.get(i));
				}
				
				//Once this loop is done, we should be ready to actually run the prepared statement:
				rs = pst.executeQuery();
			}
		
			
			//4) Only Location Criteria 
			else if((num_industry_criteria == 0) && (num_location_criteria > 0)) {
				
				query = query + " WHERE Location=";
				
				for(int i=0; i < num_location_criteria; i++) {
					query = query + "?";
					//Next, just check to see if we're on the last entry again: 
					if(!(i == (num_location_criteria - 1))) {
						//In this case, we are NOT done yet and need to set up the next criteria entry: 
						query = query + " OR Location=";
					}
				}
				
				//Okay, now that the prepared statement string is there, we can actually create the object:
				PreparedStatement pst = connection.prepareStatement(query);
				
				//Now, of course, we need to actually set all of the parameters for the query...
				for(int i=0; i < num_location_criteria; i++) {
					pst.setString((i+1), location_criteria.get(i));
				}
				
				//Once this loop is done, we should be ready to actually run the prepared statement:
				rs = pst.executeQuery();
				
			}
			
			//Remember to actually play populate the companies list with the result set at the end... 
			while(rs.next()) {
				Company company = new Company();
				company.setName(rs.getString("Name"));
				company.setID(rs.getInt("StartupID"));
				company.setDescription(rs.getString("Description"));
				company.setSize(rs.getString("Size"));
				company.setLocation(rs.getString("Location"));
				company.setIndustry(rs.getString("Industry"));
				company.setWebsite(rs.getString("Website"));
				company.setHiring_Status(rs.getString("Hiring_Status"));
				company.setStage(rs.getString("Stage"));
				company.setLogo(rs.getString("imgURL"));
				
				//Finally...just add this Company object into the list: 
				companies.add(company);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//FINALLY....return the damn companies list: 
		return companies; 
	
	}

}
