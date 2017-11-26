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
	//allows the startup rep to add events to the event tab
	//posts to "Events" tab all events that were posted
	
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addEvent.jsp";
	
	//not going to be able to edit event
	//private static String EDIT = "/event/edit.jsp";
	//private static String LIST_EVENT_PUBLIC = "/event/listPublic.jsp";
	private static String LIST_EVENT_USER = "/listEvent.jsp";
	
	//need to modify this
	private static String INVALID_PERMISION = "/index.jsp";

	private EventDao dao;
	private CompanyDao companyDao;
	private UserDao UserDao;
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

		String forward = "";
		String action = request.getParameter("action");

		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
			//request.setAttribute("startups", companyDao.getAllCompanies());
		} else if (action.equalsIgnoreCase("listEvent")) {
			forward = LIST_EVENT_USER; //may need to change this dependent on front end changes
			request.setAttribute("events", dao.getAllEvents());
//			List companies = new ArrayList<>();
//			for(Event e: dao.getAllEvents()){
//
//			}
			//request.setAttribute("companies", companies);
		} else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		//Can only post even if the person logged in is the StartupRep
		
		/*User u = new User();
		
		String un = request.getParameter("un");
		String pw = request.getParameter("pw");
		u = UserDao.login(un,pw);*/

		String forward;

		HttpSession session = request.getSession(true);
		User u = (User) session.getAttribute("currentSessionUser");
		//session.getAttribute("username");
		//String type = session.getAttribute("type");

		if(u == null || (u.getType()).equals("student")){
			forward = INVALID_PERMISION;
		}
		else if((u.getType()).equals("startup rep")) {


			Event event = new Event();

			event.setEventName(request.getParameter("eventName"));
			event.setLocation(request.getParameter("location"));
			event.setDescription(request.getParameter("description"));

			//sets the date
			try {
				Date date = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("eventDate"));
				event.setDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			event.setEventTime(request.getParameter("eventTime"));

			String eventId = request.getParameter("eventId");

			// use logged in users company as the startup
			StartupRep sr = startupRepDao.getStartupRepByEmail(u.getEmail());
			event.setStartupId(sr.getStartupID());

			//need to test if this automatically adds Startup without needing to have dropdown list
			if (eventId == null || eventId.isEmpty()) {
				dao.addEvent(event);//only add it when this event DNE
			}
		
		/*else {
			event.setEventId(Integer.parseInt(eventid));
			dao.updateEvent(event);
		}*/

			request.setAttribute("events", dao.getAllEvents());

			forward = LIST_EVENT_USER;
		} else {

			request.setAttribute("events", dao.getAllEvents());

			forward = LIST_EVENT_USER;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);

		view.forward(request, response);
	}
}
