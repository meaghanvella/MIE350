package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.util.DbUtil;

public class IndustryDao {
	/**
	 * This class handles retrieving all industries interaction with the ListIndustry table
	 */
	public IndustryDao() {
		connection = DbUtil.getConnection();
	}
	
	private Connection connection;

	
	public List<String> getAllIndustries() {
		List<String> industries = new ArrayList<String>();
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
