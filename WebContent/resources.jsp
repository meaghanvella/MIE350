<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang = "en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
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

<%@ include file="navbar.jsp"%>
<%@ include file="footbar.jsp"%>
<br />
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    <li><a href="studentHome.jsp">Home</a></li>
    <li><a href="CompanyController?action=listCompany">Startup List</a></li>
    <li><a href="SearchStartup.jsp">Search a Startup</a></li>
    <li><a href="EventController?action=listEvent">Events</a></li>
  </ul>
	<div class="row text-left"">
		<div class="col-sm-2">
		</div>
		<div class="col-sm-8">
	<center>
	<h2>Resources</h2>
	</center>
			<hr>
			<h4> Here are some helpful links to help further your professional development.
</h4>
<p>
<div class="container-fluid text-left paddingright">
For more professional development opportunities and career fairs at UofT:<br>
<a href="https://www.yourenext.ca/"> https://www.yourenext.ca</a>
<br>
<br>
Information on Canadian startups:<br>
<a href="http://www.canadianbusiness.com/profit500/2017-ranking-startup-50/"> http://www.canadianbusiness.com/profit500/2017-ranking-startup-50/</a>
<br>
<a href="https://toronto.startups-list.com/"> https://toronto.startups-list.com/</a>
<br><br>
Startup support:<br>
<a href="https://www.marsdd.com/">https://www.marsdd.com/</a><br>
<a href="https://hatchery.engineering.utoronto.ca/">https://hatchery.engineering.utoronto.ca/</a>
       
<br>
<br>
Broader networking opportunities:<br>
<a href="https://www.linkedin.com/uas/login"> https://www.linkedin.com/uas/login</a>



</div>
<hr>
	
<div class="col-sm-2">
</div>
</center>
		</div>
		</div>
		
	<div class="row text-left" >
	<br><br>
	</div>
</body>
</html>