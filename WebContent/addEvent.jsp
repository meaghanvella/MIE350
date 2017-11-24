<%@ include file="repfootbar.jsp"%>
<%@ include file="navbar.jsp"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Startup Representative - Add An Event</title>
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

<link rel="stylesheet" type="text/css" href="../../css/mystyle.css">

</head>
 <ul class="nav nav-pills nav-justified">    
    <li><a href="repHome.jsp">Home</a></li>
    <li class="active"><a href="addEvent.jsp">Add Event</a></li>
  </ul>
<body>

	<div class="row text-left">
		<div class="col-sm-2">
		</div>
        <div class="col-sm-8 text-left">
        <div class="container-fluid text-left">
            <h1>Add An Event</h1>

            <script>
                $(function() {
                    $('input[name=eventDate]').datepicker();
                });
            </script>
            Note: the Event ID is a fixed field and cannot be changed. <br>
            <br>

            <form method="POST" action='EventController' name="frmAddEvent">
			
                <label class="control-label"> Name: </label>
                <br> 
                <input maxlength="100" type="text" name="eventName" class="form-control" placeholder="Enter Event Name"
                                 value="<c:out value="${event.getEventName()}" />"><br>
              
                <label class="control-label"> Location:</label>
                <br> 
                <input maxlength="100" type="text" name="location" class="form-control" placeholder="Enter Event Location"
                                   value="<c:out value="${event.getLocation()}" />"><br>
                <label class="control-label">Date:</label>
                 <br> 
                 <input maxlength="100" type="text" name="eventDate" class="form-control" placeholder="Enter Event Date (mm/dd/yyyy)"
                                     value="<fmt:formatDate pattern="MM/dd/yyyy" value="${event.getDate()}" />"><br>

                <label class="control-label">Time: </label>
                <br> 
                <input maxlength="100" type="text" name="eventTime" class="form-control" placeholder="Enter Event Time"
                             value="<c:out value="${event.getEventTime()}" />"><br>

                <label class="control-label">Description:</label>
                <br> 
                <input maxlength="100" type="text" name="description" class="form-control" placeholder="Enter Event Description"
                              value="<c:out value="${event.getDescription()}" />"><br>

                <label class="control-label"> Startup:</label>
                <br>  
                <select name="startup" class="form-control">

                <c:forEach items="${startups}" var="startup" >
                    <option value="<c:out value="${startup.getID()}" />"><c:out value="${startup.getName()}" /></option>
                </c:forEach>

                </select>

                <br>
                <input type="submit" class="btn btn-primary" value="Submit" />
            </form>

        </div>
        <div class="col-sm-2">
		</div>
    </div>
</div>

</body>
</html>
