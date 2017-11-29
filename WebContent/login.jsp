<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Login Portal</title>
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
<!-- navbar with only the Start U logo -->
	<%@ include file="navbarNotSignedIn.jsp"%>
	
 
            <div class="loginform">
                <br> <br>
                <h1>Log In</h1>
                <br> <br>
                <form action="LoginController">
               
                <div class="form-group login-form">
                    <label for="un">Email:</label> <input type="text"
                        class="form-control" name="un">
                <br>
                    <label for="pw">Password:</label> <input type="password"
                        class="form-control" name="pw">
                </div>
                <br>
				<input type="submit"
						class="btn btn-info" value="Submit">                
				</form>
				<br /> <br />
            </div>
      
</body>
</html>