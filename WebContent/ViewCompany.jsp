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

	<%@ include file="footbar.jsp"%>
	<%@ include file="navbar.jsp"%>
<br />
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    <li><a href="studentHome.jsp">Home</a></li>
    <li  class="active"><a href="CompanyController?action=listCompany">Startup List</a></li>
    <li><a href="SearchStartup.jsp">Search a Startup</a></li>
    <li><a href="EventController?action=listEvent">Events</a></li>
  </ul>
	
	
	
	
	
	<div class="row content">
		<div class="col-sm-8 content">
		<br>
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="img_avatar1.png" class="media-object"
							style="width: 250px">
					</div>
					<div class="media-body">
						<h1 class="media-heading">
							<b><c:out value="${startup.getName()}"/></b>
							</h4>
							<h4>
								<b>Industry: <c:out value="${startup.getIndustry()}"/></b>
								</h3>
								<h4>
									<b>Location: <c:out value="${startup.getLocation()}"/></b>
									</h3>
									<h4>
										<b>Size: <c:out value="${startup.getSize()}"/></b>
										</h3>
										<h4>
											<b>Stage: <c:out value="${startup.getStage()}"/></b>
											</h3>
					</div>
				</div>

			</div>
			<div class="container-fluid text-left">
				<h4>
					<b>About: <c:out value="${startup.getDescription()}"/></b>
					</h3>
					<h4>
						<b>Website: <c:out value="${startup.getWeb()}"/></b>
						</h3>
			</div>
		</div>
		
		<div class="col-sm-4">
		<div class="container-fluid text-center">
		<H3><b> Company Reps </b> </H3>
		</div>
		
		<!-- CAROUSEL FROM W3 TUTORIAL, COMPANY REPS -->
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				
				<!-- Wrapper for slides -->
				<div class="carousel-inner" >
				<!-- INSERT LOOP HERE -->
				<c:forEach items="${rep}" var="rep">
					<div class="item active text-center">
					<!-- REP PICTURE, MAY NEED TO LINK LATER -->
					<center>
						<img src="https://assets.merriam-webster.com/mw/images/article/art-wap-article-main/egg-3442-e1f6463624338504cd021bf23aef8441@1x.jpg" style="width: 200px">
					</center>
							<h4>Name: <c:out value="${rep.getName()}" /></h3>
							<h4>About: <c:out value="${rep.getIntroduction()}" /></h3>
							
							<!-- NEED TO LINK TO PARTICULAR EMAIL HERE USING VARIABLE LATER -->
					
					<a href="mailto:getemail?Subject=Hello%20again"" class="btn btn-primary btn-sm" role="button">Contact Me</a>
					</div>
				</c:forEach>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span> <span
					class="sr-only">Previous</span>
				</a> 
				<a class="right carousel-control" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span> <span
					class="sr-only">Next</span>
				</a>
				
						
			</div>
		</div>

	</div>
							
</body>
</html>
