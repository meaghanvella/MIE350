package com.mie.controller;

import com.mie.dao.CompanyDao;
import com.mie.dao.EventDao;
import com.mie.model.Event;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

public class EventController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addEvent.jsp";
	
	//not going to be able to edit event
	//private static String EDIT = "/event/edit.jsp";
	//private static String LIST_EVENT_PUBLIC = "/event/listPublic.jsp";
	
	//need to modify naming of this
	private static String LIST_EVENT_USER = "/listEventUser.jsp";

	private EventDao dao;
	private CompanyDao companyDao;

	/**
	 * Constructor for this class.
	 */
	public EventController() {
		super();
		dao = new EventDao();
		companyDao = new CompanyDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			request.setAttribute("startups", companyDao.getAllCompanies());
		} else if (action.equalsIgnoreCase("listEvent")) {
			forward = LIST_EVENT_USER; //may need to change this dependent on front end changes
			request.setAttribute("events", dao.getAllEvents());
		} else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Check if they are logged in

		Event event = new Event();
		
		event.setEventName(request.getParameter("eventName"));
		event.setLocation(request.getParameter("location"));
		event.setDescription(request.getParameter("description"));
		event.setStartupId(Integer.parseInt(request.getParameter("startup")));

		//sets the date
		try {
			Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("eventDate"));
			event.setDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		event.setEventTime(request.getParameter("eventTime"));
		
		String eventId = request.getParameter("eventId"); 
		
		if (eventId == null || eventId.isEmpty()) {
			dao.addEvent(event);//only add it when this event DNE
		} 
		
		/*else {
			event.setEventId(Integer.parseInt(eventid));
			dao.updateEvent(event);
		}*/

		RequestDispatcher view = request
				.getRequestDispatcher(LIST_EVENT_USER);

		request.setAttribute("events", dao.getAllEvents());

		view.forward(request, response);
	}
}
