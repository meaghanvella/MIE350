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
<% 
	session = request.getSession();
	System.out.println(session);
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
	System.out.println(session.getAttribute("username"));
	System.out.println(session.getAttribute("currentSessionUser").getClass());
	
	%>


<head>
<title>StartU - View Company</title>
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
	<%@ include file="footbar.jsp"%>
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
							style="width: 175px">
					</div>
					<div class="media-body">
						<h1 class="media-heading">
							<b><c:out value="${startup.getName()}" /></b>
						</h1>
						<h4>
							<b>Industry:</b>
							<c:out value="${startup.getIndustry()}" />
						</h4>
						<h4>
							<b>Location:</b>
							<c:out value="${startup.getLocation()}" />
						</h4>
						<h4>
							<b>Size:</b>
							<c:out value="${startup.getSize()}" />
						</h4>
						<h4>
							<b>Stage:</b>
							<c:out value="${startup.getStage()}" />
						</h4>
						<h4>
							<b>Hiring Status:</b>
							<c:out value="${startup.getHiring_Status()}" />
						</h4>

					</div>
				</div>

			</div>
			<div class="container-fluid text-left">
				<h4>
					<b>About:</b>
					<c:out value="${startup.getDescription()}" />
				</h4>
				<h4>
					<b>Website: </b>
					<a href="${startup.getWeb()}"><c:out value="${startup.getWeb()}" /></a>
				</h4>
			</div>
		</div>

		<div class="col-sm-4">
		

			<%
				int repCount = 0;
			%>
			<c:forEach items="${rep}" var="rep">
				<%
					repCount++;
				%>
			</c:forEach>

			<%
				int iterate = 0;
			%>

			<%
				if (repCount > 0) {
			%>
				<center>
				<H3>
					<b> Company Reps </b>
				</H3>
			</center>
			<div class="container">
				<div class="card" style="width: 320px;">
					<div class="media">
						<ul class="nav nav-tabs">
							<%
								if (repCount >= 1) {
							%>
							<li class="active"><a data-toggle="tab" href="#home">Rep
									1</a></li>
							<%
								}
							%>
							<%
								if (repCount >= 2) {
							%>
							<li><a data-toggle="tab" href="#menu1">Rep 2</a></li>
							<%
								}
							%>
							<%
								if (repCount >= 3) {
							%>
							<li><a data-toggle="tab" href="#menu2">Rep 3</a></li>
							<%
								}
							%>
						</ul>
						<div class="tab-content">
							<c:forEach items="${rep}" var="rep">
								<%
									iterate++;
								%>
								<%
									if (iterate == 1) {
								%>
								<div id="home" class="tab-pane fade in active">
									<center>
										<h3 class="media-title">
											<b><c:out value="${rep.getName()}" /></b>
										</h3>
										<img
											src="data:image/png;base64,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"
											class="media-object" style="width: 120px"> 
											<br>
											<i><c:out
												value="${rep.getPosition()}" /></i>
									</center>
									<hr>
									<p class="media-text">
										<c:out value="${rep.getIntroduction()}" />
									</p>
									<!-- need to insert email here -->
									<hr>
									<center>
										<b>Contact me:</b> <c:out value="${rep.getEmail()}" /></a>
									</center>
								</div>
								<%
									}
								%>
								<%
									if (iterate == 2) {
								%>
								<div id="menu1" class="tab-pane fade">
									<center>

										<h3 class="media-title">
											<b><c:out value="${rep.getName()}" /></b>
										</h3>
										<img
											src="data:image/png;base64,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"
											class="media-object" style="width: 120px">
											<br> <i><c:out
												value="${rep.getPosition()}" /></i>
									</center>
									<hr>
									<p class="media-text">
										<c:out value="${rep.getIntroduction()}" />
									</p>
									<!-- need to insert email here -->
									<hr>
									<center>
										<b>Contact me:</b> <c:out value="${rep.getEmail()}" /></a>
									</center>
								</div>
								<%
									}
								%>
								<%
									if (iterate == 3) {
								%>
								<div id="menu2" class="tab-pane fade">
									<center>

										<h3 class="media-title">
											<b><c:out value="${rep.getName()}" /></b>
										</h3>
										<img
											src="data:image/png;base64,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"
											class="media-object" style="width: 120px">
											<br> <i><c:out
												value="${rep.getPosition()}" /></i>
									</center>
									<hr>
									<p class="media-text">
										<c:out value="${rep.getIntroduction()}" />
									</p>
									<!-- need to insert email here -->
									<hr>
									<center>
										<b>Contact me:</b> <c:out value="${rep.getEmail()}" /></a>
									</center>
								</div>
								<%} %>
							</c:forEach>
						</div>
						<%} %>

					</div>
				</div>
			</div>
			<br /> <br /> <br /> <br /> <br />
		</div>
	</div>
</body>
</html>



