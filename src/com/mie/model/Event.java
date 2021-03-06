package com.mie.model;
import com.mie.dao.CompanyDao;

import java.util.Date;
import java.sql.Time;

/**
 * This class stores Event information and contains getters and setters
 * **/
public class Event {	
	private int eventId;
	private String eventName;
	private int startupId;
	private Date date;
	private String eventTime;
	private String location;
	private String description;
	

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getStartupId() {
		return startupId;
	}

	public void setStartupId(int startupId) {
		this.startupId = startupId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEventTime() {
		return eventTime;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//this method gets the startup the event is posted under
	public Company getStartup(){
		CompanyDao cd = new CompanyDao();
		return cd.getCompanyByID(this.startupId);
	}

	@Override
	public String toString() {
		return "Event [eventName=" + eventName + ", "
				+ ", startupId=" + startupId + ", date=" + date
				+ ", eventTime=" + eventTime + ", location=" + location
				+ ", description=" + description + "]";
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


}