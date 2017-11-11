package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Company;
import com.mie.model.StartupRep;
import com.mie.util.DbUtil;

public class StartupRepDao {
	
	private Connection connection;
	
	public StartupRepDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void addStartupRep(StartupRep rep) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("INSERT INTO StartupRep(Name, Position, Introduction, Email, Password, Startup, StartupID) VALUES(?, ?, ?, ?, ?, ?)");
			pst.setString(1, rep.getName());
			pst.setString(2, rep.getPosition());
			pst.setString(3, rep.getIntroduction());
			pst.setString(4,  rep.getEmail());
			pst.setString(5,  rep.getPassword());
			pst.setString(6, rep.getStartup());
			pst.setInt(7, rep.getStartupID());
			//BE CAREFUL with the startupID...that's not something that will be inputted by the user...
			//Based on the startup that they input, we'll have to look up the ID in the Startup table 
			pst.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateStartupRep(StartupRep rep) {
		
		try {
			PreparedStatement pst = connection.prepareStatement("UPDATE STUDENT SET Name=?, Position=?, Introduction=?, Password=?, Startup=?, StartupID=? WHERE email=?");
			pst.setString(1, rep.getName());
			pst.setString(2, rep.getPosition());
			pst.setString(3, rep.getIntroduction());
			pst.setString(4, rep.getPassword());
			pst.setString(5, rep.getStartup());
			pst.setInt(6, rep.getStartupID());
			pst.setString(7, rep.getEmail());
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	 
	//get startup reps by startup 
	public List<StartupRep> getRepsByStartup(Company company) {
		
		//Get the ID of the startup itself:
		int startupID = company.getID();
		//Create list to store the startup rep objects: 
		List<StartupRep> reps = new ArrayList<StartupRep>();
		
		try{ 
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM StartupRep WHERE StartupID=?");
			pst.setInt(1, startupID);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				StartupRep rep = new StartupRep();
				rep.setName(rs.getString("Name"));
				rep.setPosition(rs.getString("Position"));
				rep.setIntroduction(rs.getString("Introduction"));
				rep.setEmail(rs.getString("Email"));
				rep.setPassword(rs.getString("Password"));
				rep.setStartup(rs.getString("Startup"));
				rep.setStartupID(rs.getInt("StartupID"));
				
				reps.add(rep);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return reps;
		
	}

}
