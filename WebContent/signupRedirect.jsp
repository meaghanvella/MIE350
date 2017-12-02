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
	<meta http-equiv="refresh" content="3;url=index.jsp"/>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	
	<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>
	<%@ include file="navbarNotSignedIn.jsp"%>

	<div class="container">
	    <div class="row setup-content" id="step-1">
	      <div class="col-xs-6 col-md-offset-3">
	        <div class="col-md-12">
	          <div class=text-center>
	          <br> <br>
	          <span class="glyphicon glyphicon-ok checkmark"></span>
	          <h2>Thanks for signing up! Please log in again through the home page.</h2>
	          <p>Redirecting to the home page...</p>
		          <div class="spinner">
					  <div class="bounce1"></div>
					  <div class="bounce2"></div>
					  <div class="bounce3"></div>
				  </div> 
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
</body>
</html>