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

<%@ include file="navbar.jsp"%>
<br />
<!--  Code taken from W3 schools -->
 <ul class="nav nav-pills nav-justified">
    <li class="active"><a href="StudentHome.jsp">Home</a></li>
    <li><a href="/StartU/CompanyController?action=listCompany">Startups</a></li>
    <li><a href="listEvent.jsp">Events</a></li>
  </ul>


<center>
<h1> Welcome, Student!</h1>
<p> Welcome to your StartU dashboard! Choose an above tab to get started</p>
<br />
<img src="https://assets.merriam-webster.com/mw/images/article/art-wap-article-main/egg-3442-e1f6463624338504cd021bf23aef8441@1x.jpg">
<br />
<br />
<b>Full Name</b>
<p>name@mail.utoronto.ca</p>
<br />

	<!--  Code modified from https://bootsnipp.com/snippets/featured/squarespace-like-modal -->
	<div class="center"><button data-toggle="modal" data-target="#squarespaceModal" class="btn btn-primary center-block">Edit Profile</button></div>
	
	<!-- line modal -->
	<div class="modal fade" id="squarespaceModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">¡¿</span><span class="sr-only">Close</span></button>
				<h3 class="modal-title" id="lineModalLabel">My Modal</h3>
			</div>
			<div class="modal-body">
				
	            <!-- content goes here -->
				<form>
	              <div class="form-group">
	                <label for="exampleInputEmail1">First Name</label>
	                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="First Name">
	              </div>
	              <div class="form-group">
	                <label for="exampleInputPassword1">Last Name</label>
	                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Last Name">
	              </div>
	              <div class="form-group">
	                <label for="exampleInputFile">Profile Photo</label>
	                <input type="file" id="exampleInputFile">
	                <p class="help-block">Input your stuff</p>
	              </div>
	              <div class="checkbox">
	                <label>
	                  <input type="checkbox"> Check me out
	                </label>
	              </div>
	              <button type="submit" class="btn btn-default">Submit</button>
	            </form>
	
			</div>
			<div class="modal-footer">
				<div class="btn-group btn-group-justified" role="group" aria-label="group button">
					<div class="btn-group" role="group">
						<button type="button" class="btn btn-default" data-dismiss="modal"  role="button">Close</button>
					</div>
					<div class="btn-group btn-delete hidden" role="group">
						<button type="button" id="delImage" class="btn btn-default btn-hover-red" data-dismiss="modal"  role="button">Delete</button>
					</div>
					<div class="btn-group" role="group">
						<button type="button" id="saveImage" class="btn btn-default btn-hover-green" data-action="save" role="button">Save</button>
					</div>
				</div>
			</div>
		</div>
	  </div>
	</div>

</center>

</body>
</html>