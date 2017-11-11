package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class IndustryDao {
	
	private Connection connection;
	List<String> industries;
	
	public List<String> getAllIndustries() {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM ListIndustry");
			
			while (rs.next()) {
				String industry = rs.getString("Industry");
				industries.add(industry);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return industries;
		
	}

}
