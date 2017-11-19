
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
	<!-- 3 Step Buttons -->
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
	      <div class="stepwizard-step">
	        <a href="#step-3" type="button" class="btn btn-default btn-circle" disabled="disabled">3</a>
	        <p>Step 3</p>
	      </div>
	    </div>
	  </div>
	  
	  <!-- Form groups need to modify all actions to controller -->
	  <form role="form" action="StartupRepController" method="post">
	    
	    <div class="row setup-content" id="step-1">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Basic Info</h2>
	          <p>Please fill in your personal information below.</p> <br>
	          </div>
	       	 <div class="form-group">
	            <label class="control-label">Full Name</label>
	            <input name="fullName" maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Full Name"  />
	          </div>
	          <div class="form-group">
	            <label class="control-label">Email</label>
	            <input name="email" maxlength="100" type="text" required="required" class="form-control" placeholder="Enter your email address" >
	          </div>
	          <div class="form-group">
	            <label class="control-label">Create Password</label>
	            <input name="password" maxlength="100" type="password" required="required" class="form-control" placeholder="Choose a password that you'll remember!" >
	          </div>

	          <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
	        </div>
	      </div>
	    </div>
	    
	    <div class="row setup-content" id="step-2">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Choose a photo</h2>
	          <p>Link to an existing profile picture so students know who you are!</p> <br>
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
	    </div>
	    
	    <div class="row setup-content" id="step-3">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <h2>Your Company</h2>
	          <p>Which company are you representing?</p> <br>
	          </div>
	        <div class="col-auto">
	          <label for="inlineFormCustomSelect">Company</label>
	          <select id="inlineFormCustomSelect" class="form-control">
	            <option selected>Choose...</option>
                <!-- dynamically pull from db -->
                <c:forEach items="${startups}" var="startup">
                    <option value="<c:out value="${startup.getID()}" />"><c:out value="${startup.getName()}" /></option>
                </c:forEach>
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