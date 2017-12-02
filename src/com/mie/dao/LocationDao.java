package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class LocationDao {
	/**
	 * This class handles retrieving all locations interaction with the ListLocation table
	 */
	private Connection connection;
	List<String> locations;
	
	public List<String> getAllLocations() {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ListLocation");
			
			while (rs.next()) {
				String industry = rs.getString("Location");
				locations.add(industry);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return locations;
		
	}

}