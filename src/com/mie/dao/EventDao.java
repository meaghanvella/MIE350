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
					.prepareStatement("insert into Event(EventName,Startup,StartupID,EventDate,EventTime,Location,Description) values (?, ?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, event.getEventName());
			preparedStatement.setString(2, event.getStartup());
			preparedStatement.setInt(3, event.getStartupId());
			
			//need to doublecheck this
			preparedStatement.setDate(4, new java.sql.Date(event.getDate().getTime()));
			preparedStatement.setTime(5, event.getEventTime());
			
			//this is ok
			preparedStatement.setString(6, event.getLocation());
			preparedStatement.setString(7, event.getDescription());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
	public List<Event> getAllEvents() {
		List<Event> Events = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from Event");
			while (rs.next()) {
				Event event = new Event();
				
				//not sure if need eventID
				event.setEventId(rs.getInt("EventID"));
				event.setEventName(rs.getString("EventName"));
				event.setStartup(rs.getString("Startup"));
				event.setStartupId(rs.getInt("StartupID"));
				event.setDate(rs.getDate("EventDate"));
				event.setEventTime(rs.getTime("EventTime")); //need to double check format of time
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