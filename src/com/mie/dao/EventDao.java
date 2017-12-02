package com.mie.dao;

import com.mie.model.Event;
import com.mie.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
	private Connection connection;
	/**
	 * This class handles interaction with the Event table including:
	 * - insert (add Event)
	 * - retrieval of all events contained in the Event table
	 */
	
	public EventDao() {
		connection = DbUtil.getConnection();
	}

	//this method inserts a new Event tuple into the Event table
	public void addEvent(Event event) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Event(EventName,StartupID,EventDate,EventTime,Location,Description) values (?, ?, ?, ?, ?, ?)");
		
			preparedStatement.setString(1, event.getEventName());
			preparedStatement.setInt(2, event.getStartupId());
			preparedStatement.setDate(3, new java.sql.Date(event.getDate().getTime()));
			preparedStatement.setString(4, event.getEventTime()); 
			preparedStatement.setString(5, event.getLocation());
			preparedStatement.setString(6, event.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//this method retrieves all the Events contained in the Event Table and stores them in a List
	public List<Event> getAllEvents() {
		List<Event> Events = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from Event ORDER BY EventDate");
			while (rs.next()) {
				Event event = new Event();
				event.setEventId(rs.getInt("EventID"));
				event.setEventName(rs.getString("EventName"));
				event.setStartupId(rs.getInt("StartupID"));
				event.setDate(rs.getDate("EventDate"));
				event.setEventTime(rs.getString("EventTime")); 
				event.setLocation(rs.getString("Location"));
				event.setDescription(rs.getString("Description"));
				
				Events.add(event);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Events;
	}

}