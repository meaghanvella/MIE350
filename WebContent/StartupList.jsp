
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

<%@ include file="views/common/navbar.jsp"%>
<br />
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    <li><a href="StudentHome.jsp">Home</a></li>
    <li class ="active"><a href="/CompanyController?action=listCompany">Startups</a></li>
    <li><a href="listEventUser.jsp">Events</a></li>
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
    
    
    <h1><c:out value="${Industry.size()}" /> a</h1>
    <h1><c:out value="${Company.size()}" /> b</h1>
    <c:forEach items="${Industry}" var="industry">
		   <h1><c:out value="${industry.getIndustry()}"/></h1>
	</c:forEach>
	<h1>1</h1>
    
    
     <h4>List of Startups recently added</h4>
     
	<c:forEach items="${CompanyDao.getAllIndustries()}" var="company">
     <p class="card-text"><c:out value="${company}" /></p>
   </c:forEach>
 
  
 
<div class="card" style="width: 20rem;">
  <c:forEach items="${Company}" var="company">
  <div class="card-block">
    <h4 class="card-title"><td align="center"><c:out value="${company.getName()}" />
    		</td></h4>
    <p class="card-text"><c:out value="${company.getDescription()}" /></p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
  </c:forEach>
</div>


</div>
  
  
  
</div>

</body>
</html>