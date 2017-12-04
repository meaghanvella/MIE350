<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.mie.dao.*" %>
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

<html lang="en">
<head>
<title>StartU - Search Startups</title>
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
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<br />
  <ul class="nav nav-pills nav-justified">
    <li><a href="studentHome.jsp">Home</a></li>
    <li><a href="CompanyController?action=listCompany">Startup List</a></li>
    <li class="active"><a href="SearchStartup.jsp">Search a Startup</a></li>
    <li><a href="EventController?action=listEvent">Events</a></li>
  </ul>
  
  
  <%
   
	String email = (String) session.getAttribute("username");
	User u = (User) session.getAttribute("currentSessionUser");
	StudentDao studDao = new StudentDao(); 
	Student s= studDao.getStudentByEmail(email);
	String industry =s.getIndustry();

%>

	<%
	//not sure about this
		User member = (User) session.getAttribute("currentSessionUser");

		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
	%>

	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Search A Startup</h1>
				
				<h4> Enter a keyword to find a startup. This can be part of the name, industry, location or stage of the startup. </h4>
				<Br />
				<Br />
				<center>
					<form method="POST" action='SearchController' name="frmAddUser" class="form-inline">
						    <input type="text" name="keyword" value="<c:out value="${startup.searchword}" />"  class="form-control" placeholder="Search a Startup">
						    <input type="submit" class="btn btn-info" value="Submit" />
					</form>
				</center>
				
				<Br />
				<Br />
				

			</div>
			<div class="col-sm-2 sidenav">
			</div>
		</div>
	</div>


</body>
<%@ include file="footbar.jsp"%>
</html>

