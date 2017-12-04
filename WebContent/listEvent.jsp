<%@ include file="navbar.jsp"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
	session = request.getSession();
	System.out.println(session);
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	System.out.println(session.getAttribute("username"));
	System.out.println(session.getAttribute("currentSessionUser").getClass());
	
	%>

<html lang = "en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Home Page</title>
</head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">

<br />
<!--  Code taken from W3 schools -->
  <ul class="nav nav-pills nav-justified">
    <li><a href="studentHome.jsp">Home</a></li>
    <li><a href="CompanyController?action=listCompany">Startup List</a></li>
    <li><a href="SearchStartup.jsp">Search a Startup</a></li>
    <li class="active"><a href="EventController?action=listEvent">Events</a></li>
  </ul>

<body>
<div class="container-fluid text-center">
    <div class="row">
    <div class="col-sm-2 text-left"></div>
        <div class="col-sm-8 text-left">
 			<div class="text-center">
            <h1>All Events in StartU</h1>

            The time is now <b><%=new java.util.Date()%></b>.<br> <br><br>
			</div>
            <table class="table table-hover  sortable table-bordered">
                <thead>
                <tr>
                 	<th>Startup Name</th>
                    <th>Event Name</th>
                    <th>Location</th>
                    <th>Date</th>
                    <th>Time</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td align="left"><c:out value="${event.getStartup().getName()}" /></td>
                        <b><td align="left"><c:out value="${event.getEventName()}" /></td></b>
                        <td align="left"><c:out value="${event.getLocation()}" /></td>
                        <td align="center"><fmt:formatDate pattern="yyyy-MMM-dd"
										value="${event.getDate()}" /></td>
						<td align="center" style="white-space:nowrap;"><c:out value="${event.getEventTime()}" /></td>				
                        <td align="left"><c:out value="${event.getDescription()}" /></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <br/> <br/> <br/> <br/> <br/> <br/>
   
        </div>
     <div class="col-sm-2 text-left"></div>
  
    </div>
</div>

</body>
</html>
<%@ include file="footbar.jsp"%>