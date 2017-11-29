package com.mie.dao;

import com.mie.model.Event;
import com.mie.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
	private Connection connection;

	public EventDao() {
		connection = DbUtil.getConnection();
	}

	public void addEvent(Event event) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Event(EventName,StartupID,EventDate,EventTime,Location,Description) values (?, ?, ?, ?, ?, ?)");
			//dont need to insert EventId because automatically inserted
			
			// Parameters start with 1
			preparedStatement.setString(1, event.getEventName());
			preparedStatement.setInt(2, event.getStartupId());
			
			//need to doublecheck this
			preparedStatement.setDate(3, new java.sql.Date(event.getDate().getTime()));
			//Claire changed this line so the database doesn't look weird
			preparedStatement.setString(4, event.getEventTime()); //event.getEventTime()
			
			//this is ok
			preparedStatement.setString(5, event.getLocation());
			preparedStatement.setString(6, event.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public List<Event> getAllEvents() {
		List<Event> Events = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("Select * from Event ORDER BY EventDate");
			while (rs.next()) {
				Event event = new Event();
				
				//not sure if need eventID
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

	
	//if want to update - but not within functionality
	public void updateEvent(Event event) {


	}

}