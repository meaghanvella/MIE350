
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.mie.dao.CompanyDao"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>All of the startups in the database</title>
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
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    <li><a href="studentHome.jsp">Home</a></li>
    <li  class="active"><a href="CompanyController?action=listCompany">Startup List</a></li>
    <li><a href="SearchStartup.jsp">Search a Startup</a></li>
    <li><a href="EventController?action=listEvent">Events</a></li>
  </ul>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <p>Filter by...</p> 
      <div class="form-group">
		<label for="sel1">Industry:</label>
		<select class="form-control" id="sel1">
		    <option> Aerospace </option>
		    <option> Analytics </option>
		    <option> Education </option>
		    <option> Electronics </option>
		    <option> Energy </option>
		    <option> Fintech </option>
		    <option> Healthcare </option>
		    <option> Marketing & Accounting </option>
		    <option> Photography </option>
		    <option> Robotics </option>
		    <option> Software </option>
		    <option> Tech </option>
		</select>
	</div>
    </div>
    <div class="col-sm-9">
    
     <h4>List of Startups recently added</h4>
    <!--  
	<c:forEach items="${CompanyDao.getAllIndustries()}" var="company">
     <p class="card-text"><c:out value="${company}" /></p>
   </c:forEach>
 -->
  
 
 <% int colCount = 0;%>
 <c:forEach items="${Company}" var="company">
	 <% if(colCount == 0){%>
	 	<div class="row">
	 <% }%>
	  <div class="col-sm-4">
	    <div class="card" height=200px>
	      <div class="card-body">
	        <h4 class="card-title"> <c:out value="${company.getName()}" /> </h4>
	        <p class="card-text"> <c:out value="${company.getDescription()}"/> </p>
	        <a href="#" class="btn btn-primary">More Info</a>
	      </div>
	    </div>
	  </div>
	  <% colCount++;%>
	 <% if(colCount == 3){%>
	 	</div>
	 	<br/>
	 	<%colCount = 0; %>
	 <% }%>
</c:forEach>
 
</div>
  
  
  
</div>

</body>
</html>