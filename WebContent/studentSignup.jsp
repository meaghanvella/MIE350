<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- make empty doc-type to support html5 attributes -->
<!DOCTYPE html>

<html lang="en">
<head>
	<title>SignUp Process</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/js/signup.js"/>" type="text/javascript"></script>
	
	<!-- Date Picker Javascript -->
	<!-- https://jqueryui.com/datepicker/ -->
	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbarNotSignedIn.jsp"%>

	<div class="container">
	<br>
	<!-- 2 Step Buttons -->
	<div class="stepwizard col-md-offset-3">
	    <div class="stepwizard-row setup-panel">
	      <div class="stepwizard-step">
	        <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
	        <p>Step 1</p>
	      </div>
	      <div class="stepwizard-step">
	        <a href="#step-2" type="button" class="btn btn-default btn-circle" disabled="disabled">2</a>
	        <p>Step 2</p>
	      </div>
	      <!-- <div class="stepwizard-step">
	        <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
	        <p>Step 3</p> -->
	      </div>
	    </div>
	  </div>
	  
	  <!-- Form groups -->
	  <form role="form" action="StudentController" method="post">
	    
	    <div class="row setup-content" id="step-1">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Basic Info</h2>
	          <p>Please fill in your personal information below.</p> <br>
	          </div>
	          <div class="form-group">
	            <label class="control-label">Name</label>
	            <input  maxlength="100" name = "Name" type="text" required="required" class="form-control" placeholder="Enter Full Name"  />
	          </div>
	          <div class="form-group">
	            <label class="control-label">Year</label>
	            <input maxlength="100" name = "Year" type="text" required="required" class="form-control" placeholder="What year are you in?" />
	          </div>
	          <div class="form-group">
	            <label class="control-label">Email</label>
	            <input maxlength="100" name = "Email" type="text" required="required" class="form-control" placeholder="Enter your email address" >
	          </div>
	          <div class="form-group">
	            <label class="control-label">Major</label>
	            <input maxlength="100" name = "Major" type="text" required="required" class="form-control" placeholder="What's your major?" >
	          </div>
	           <div class="form-group">
	            <label class="control-label">Password</label>
	            <input maxlength="100" name = "Password" type="password" required="required" class="form-control" placeholder="Create a password!" >
	          </div>
	          <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
	        </div>
	      </div>
	    </div>
	   
	    <!-- <div class="row setup-content" id="step-2">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Choose a photo</h2>
	          <p>Link to an existing profile picture so recruiters know who you are!</p> <br>
	          </div>
	          <div class="form-group">
	            <label class="control-label">Image URL</label>
	            <input maxlength="200" type="text" required="required" class="form-control" placeholder="Enter the link to a photo that already exists online." />
	          </div>
	          <div class="form-group">
	            <label class="control-label">Brief Bio</label>
	            <textarea required="required" class="form-control" placeholder="Enter brief description of yourself."></textarea>
	          </div>
	          <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
	        </div>
	      </div>
	    </div> -->
	    
	    <div class="row setup-content" id="step-2">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Industry preference</h2>
	          <p>Select the industry you're most interested in.</p> <br>
	          </div>
	        <div class="col-auto">
	          <label for="inlineFormCustomSelect">Industry</label>
	          <select id="inlineFormCustomSelect" class="form-control">
	            <option selected>Choose...</option>
	            <option>Aerospace</option>
	            <option>Analytics</option>
	            <option>Education</option>
	            <option>Electronics</option>
	            <option>Energy</option>
	            <option>Fintech</option>
	            <option>Healthcare</option>
	            <option>Marketing &amp; Advertising</option>
	            <option>Photography</option>
	            <option>Robotics</option>
	            <option>Software</option>
	          </select>
	        </div>
	          <br>
	          <button class="btn btn-success btn-lg pull-right" type="submit">Finish</button>
	        </div>
	      </div>
	    </div>
	  </form>
	  
	</div>

</body>
</html>