<%@ include file="navbar.jsp"%>
<%@ include file="footbar.jsp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<body>

<br />
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    
    <!-- You need to modify the actions so that it points to the controllers
         Or have a nav bar instead of changing it each time   -->
    
    <li class="active"><a href="StudentHome.jsp">Home</a></li>
    <!-- Note: modify below when search finished -->
    <li><a href="StartupList.jsp">Startups</a></li>
    <li><a href="EventController?action=listEvent">Events</a></li>  
    </ul>



<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-sm-2 sidenav">
            <!-- You can put left sidebar links here if you want to. -->
        </div>
        <div class="col-sm-8 text-left">
 
            <h1>All Events In Database</h1>

            The time is now <b><%=new java.util.Date()%></b>.<br> <br>

            <table class="table table-hover  sortable"">
                <thead>
                <tr>
                    <th>Event Id</th>
                    <th>Name</th>
                    <th>Location</th>
                    <th>Time & Date</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${events}" var="event">
                    <tr>
                        <td align="center"><c:out value="${event.getEventId()}" /></td>  
                        <b><td align="center"><c:out value="${event.getEventName()}" /></td></b>
                        <td align="center"><c:out value="${event.getLocation()}" /></td>
                        <td align="center"><fmt:formatDate pattern="yyyy-MMM-dd"
										value="${event.getDate()}" /></td>
                        <td align="center"><c:out value="${event.getDescription()}" /></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <br/> <br/>
   
        </div>
        <div class="col-sm-2 sidenav">
            <!-- You can put right sidebar links here if you want to. -->
        </div>
  
    </div>
</div>

<% // @ include file="../footer.jsp"%>
</body>
</html>