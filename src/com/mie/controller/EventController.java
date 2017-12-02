package com.mie.controller;

import com.mie.dao.CompanyDao;
import com.mie.dao.EventDao;
import com.mie.dao.StartupRepDao;
import com.mie.dao.UserDao;
import com.mie.model.Event;
import com.mie.model.StartupRep;
import com.mie.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

public class EventController extends HttpServlet {
	/**
	 * This class handles all the functionality related to Events, including: 
	 * (1) allowing startup reps to add events related to their startups
	 * (2) allowing both the student and startup reps to view events in the database
	 */
	
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addEvent.jsp";
	private static String LIST_EVENT_USER = "/listEvent.jsp";
	private static String LIST_EVENT_REP = "/repListEvent.jsp";
	private static String INVALID_PERMISION = "/index.jsp";

	private EventDao dao;
	private CompanyDao companyDao;
	private StartupRepDao startupRepDao;

	/**
	 * Constructor for this class.
	 */
	public EventController() {
		super();
		dao = new EventDao();
		companyDao = new CompanyDao();
		startupRepDao = new StartupRepDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method forwards users to different pages related to Events
		 * dependent on their actions 		 
		 **/
		
		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		} else if (action.equalsIgnoreCase("listEvent")) {
			forward = LIST_EVENT_USER;  
			request.setAttribute("events", dao.getAllEvents());

		} else if (action.equalsIgnoreCase("repListEvent")) {
			forward = LIST_EVENT_REP; 
			request.setAttribute("events", dao.getAllEvents());
		}
		else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/**
		 * This method checks if the current user is startup rep and only allows
		 * them to add Events related to their startups if they are the reps 
		 */
		
		String forward;
		HttpSession session = request.getSession(true);
		
		User u = (User) session.getAttribute("currentSessionUser");
	
		if(u == null || (u.getType()).equals("student")){
			forward = INVALID_PERMISION;
		}
		//Can only post even if the person logged in is the StartupRep
		else if((u.getType()).equals("startup rep")) {
			
			Event event = new Event();
			event.setEventName(request.getParameter("eventName"));
			event.setLocation(request.getParameter("location"));
			event.setDescription(request.getParameter("description"));

			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("eventDate"));
				event.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			event.setEventTime(request.getParameter("eventTime"));
			String eventId = request.getParameter("eventId");
			
			StartupRep sr = startupRepDao.getStartupRepByEmail(u.getEmail());
			event.setStartupId(sr.getStartupID());

			if (eventId == null || eventId.isEmpty()) {
				dao.addEvent(event);//only add Event when this event DNE
			}
			request.setAttribute("events", dao.getAllEvents());
			forward = LIST_EVENT_REP;
		} else {

			request.setAttribute("events", dao.getAllEvents());
			forward = LIST_EVENT_REP;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);

		view.forward(request, response);
	}
}
