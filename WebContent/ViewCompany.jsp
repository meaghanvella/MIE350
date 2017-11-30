<%@ page import="com.mie.model.*" %>
<%@ page import="com.mie.dao.*" %>
<%@ page import="com.mie.controller.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<head>
<title>MIE350 Sample Web App</title>
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
		<li class="active"><a href="CompanyController?action=listCompany">Startup
				List</a></li>
		<li><a href="SearchStartup.jsp">Search a Startup</a></li>
		<li><a href="EventController?action=listEvent">Events</a></li>
	</ul>


	<div class="row content">
		<div class="col-sm-1 content"></div>
		<div class="col-sm-7 content">
			<br>
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="${startup.getLogo()}" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h1 class="media-heading">
							<b><c:out value="${startup.getName()}" /></b>
						</h1>
						<h4>
							<b>Industry:</b>
							<c:out value="${startup.getIndustry()}" />
							</h3>
							<h4>
								<b>Location:</b>
								<c:out value="${startup.getLocation()}" />
								</h3>
								<h4>
									<b>Size:</b>
									<c:out value="${startup.getSize()}" />
									</h3>
									<h4>
										<b>Stage:</b>
										<c:out value="${startup.getStage()}" />
										</h3>
					</div>
				</div>

			</div>
			<div class="container-fluid text-left">
				<h4>
					<b>About:</b>
					<c:out value="${startup.getDescription()}" />
					</h3>
					<h4>
						<b>Website: </b>
						<c:out value="${startup.getWeb()}" />
						</h3>
			</div>
		</div>

		<div class="col-sm-4">
			<center>
				<H3>
					<b> Company Reps </b>
				</H3>
			</center>

			<c:forEach items="${rep}" var="rep">

				<div class="card" height=200px>
					<div class="media">
						<center>

							<h3 class="media-title">
								<b><c:out value="${rep.getName()}" /></b>
							</h3>
							<img src="img_avatar1.png" class="media-object"
								style="width: 100px">


							<div class="media-body">

								<i><c:out value="${rep.getPosition()}" /></i>
						</center>
						<hr>
						<p class="media-text">
							<c:out value="${rep.getIntroduction()}" />
						</p>
						<!-- need to insert email here -->
						<hr>
						<center>
							<a class="btn btn-primary">Contact me</a>
						</center>
					</div>
				</div>

			</c:forEach>

			<% int repCount = 0;%>
			<c:forEach items="${rep}" var="rep">
				<% repCount++;%>
			</c:forEach>
			
			<% int iterate= 0;%>
			
			
			<% if (repCount>0) { %>
			<div class="container">
			
				<h2>Dynamic Tabs</h2>
				<ul class="nav nav-tabs">
					<% if (repCount>=1) { %>
					<li class="active"><a data-toggle="tab" href="#home">Rep 1</a></li>
					<%} %>
					<% if (repCount>=2) { %>
					<li><a data-toggle="tab" href="#menu1">Rep 2</a></li>
					<%} %>
					<% if (repCount>=3) { %>
					<li><a data-toggle="tab" href="#menu2">Rep 3</a></li>
					<%} %>
				</ul>
				<div class="tab-content">
				<c:forEach items="${rep}" var="rep">
			<%iterate++; %>
				<% if (iterate==1) { %>
					<div id="home" class="tab-pane fade in active">
						<h3>HOME</h3>
						<b><c:out value="${rep.getName()}" /></b>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
							sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.</p>
					</div>
					<%} %>
					<% if (iterate==2) { %>
					<div id="menu1" class="tab-pane fade">
						<h3>Menu 1</h3>
						<b><c:out value="${rep.getName()}" /></b>
						<p>Ut enim ad minim veniam, quis nostrud exercitation ullamco
							laboris nisi ut aliquip ex ea commodo consequat.</p>
					</div>
					<%} %>
					<% if (iterate==3) { %>
					<div id="menu2" class="tab-pane fade">
						<h3>Menu 2</h3>
						<b><c:out value="${rep.getName()}" /></b>
						<p>Sed ut perspiciatis unde omnis iste natus error sit
							voluptatem accusantium doloremque laudantium, totam rem aperiam.</p>
					</div>
					<%} %>
</c:forEach>
				</div>
				<%} %>
			
			</div>
		</div>
		<br /> <br />
		<br />
		<br /> <br />
</body>
</html>



