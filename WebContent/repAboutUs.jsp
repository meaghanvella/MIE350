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
<%@ include file="repfootbar.jsp"%>
<br />
<!--  Code taken from W3 schools -->
	<ul class="nav nav-pills nav-justified">
		<li><a href="repHome.jsp">Home</a></li>

		<li><a href="EventController?action=insert">Add Event</a></li>
		<!--<li><a href="/EventController?action=listEvent">Events</a></li>-->
	</ul>

	<div class="row text-left"">
		<div class="col-sm-2">
		</div>
		<div class="col-sm-8">
		<center>
			<h2>Our Vision</h2>
			</center>
			<hr>
			<p>StartU is a web application designed to simplify recruitment for startups and students alike. It provides students with a platform to contact representatives from startups of interest and makes the recruitment process more efficient for both parties.
</p>
<p>
The application supports two types of users: Students and Startup Representatives.
<br>
<br>
Within StartU, students can:<br> 
<div class="container-fluid text-left paddingright">
       1. <b>Create</b> an account<br>
       2. <b>Log</b> in to the site<br>
       3. <b>Edit</b> account information<br>
       4. <b>View</b> startup events<br>
       5. <b>Search</b> through a list of startups<br>
       6. <b>View</b> startup representative profiles and contact information
       
       </div>
<br>
Startup Representatives can:<br>
<div class="container-fluid text-left paddingright">

1. <b>Create</b> an account<br>
2. <b>Log</b> in to the site <br>
3. <b>Edit</b> account information<br>
4. <b>Create</b> events for students to see<br>
</div>
<br>
This web application was created for MIE350, an undergraduate course at the University of Toronto.
</p>
<center>
	<h2>Our Team</h2>
	</center>

<hr>
	
<div class="col-sm-2">
</div>
</center>
		</div>
		</div>

		
	<div class="row text-left" >
	
<div class="col-sm-2">
</div>
	<div class="col-sm-4">
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="img/Hermanpuppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>Herman Chandi</b> 
							
							Position: bark-end dev
							<br>
							House: Ravenclaw
						
					</div>
				</div>

			</div>
			<br>
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="img/Clairepuppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
						
							<b>Claire Goldsmith</b>
							<br>
							Position: bootstrap chewer
							<br>
							House: Hufflepuff
					</div>
				</div>

			</div>
			<br>
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="img/Irenepuppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
					
							<b>Irene Halim</b>
							<br>
							Position:
							<br> House: 
					</div>
				</div>

			</div>
			<br>
			<div class="container-fluid text-left">
				<div class="media">
					<div class="media-left">
						<img src="img/Laurenpuppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>Lauren Ip</b>
							<br>
							Position: fluff-end dev
							<br> House: 
					</div>
				</div>

			</div></div>
		
			<div class="container-fluid text-left">
			<div class="col-sm-5">
				<div class="media">
					<div class="media-left">
						<img src="img/selenapart2.png" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>Selena Lu</b>
							<br>
							Position:
							<br>House: Slytherin
					</div>
				</div>

			<br>
			<div class="media">
					<div class="media-left">
						<img src="img/Claudiapuppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>Claudia Nguyen</b>
							<br>
							Position: bark-end dev<br>
							House: Slytherin
					</div>
				</div>
			<br>
			<div class="media">
					<div class="media-left">
						<img src="img/meaghan puppy.jpg" class="media-object"
							style="width: 150px">
					</div>
					<div class="media-body">
						<h4 class="media-heading">
							<b>Meaghan Vella</b>
							<br>
							Position:
							<br>
							House: Ravenclaw
					</div>
				</div>
		</div>	
		</div>		
		<div class="col-sm-1">
</div>
		
	</div>
	<div class="row text-left" >
	<br><br>
	</div>
</body>
</html>