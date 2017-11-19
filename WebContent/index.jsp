<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<body style="background-color:#E0FFFF;" background="img/briefcase-6-xxl.png">
	<div class="container-fluid text-center">
		<div class="container-fluid">
			
			<center>
				<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
				
				<p id="contentWrapper">
				<br> 
				<img src="img/StartU_logo.png" alt="img/StartU logo"
					style="width: 350px" class="center" />
					</p>
			</center>
			<hr>
			<!-- This is the sign up button -->
			<div class="container">
				<!-- Trigger the modal with a button -->
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#myModal">Sign Up</button>
					
					
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<h4 class="modal-title">
								
								Are you a <font color="#5cb85c"><b>student </font></b> or a <font color="#5bc0de"><b>start up
									representative?</font></b>
									</h4>
							</div>
							<div class="modal-body">

								<div class="row">

									<div class="col-sm-6" align="center">
										<div class="container-fluid">
											<img src="img/Business_Graduation_Cap.png" class="img-thumbnail"
												alt="Student logo" width="120" height="120"> 
										</div>
									</div>
									<div class="col-sm-6" align="center">

										<div class="container-fluid">
											<img src="img/Startup_rep_logo.png" class="img-thumbnail"
												alt="StartUp Rep" width="120" height="120"> 
										</div>
									</div>

								</div>
								<div class="row">
								<div class="col-sm-6" align="center">
								<a href="studentSignup.jsp" class="btn btn-success paddingleft paddingright" role="button" align="center">STUDENT</a>								
								</div>
								<div class="col-sm-6" align="center">
								<a href="repSignup.jsp" class="btn btn-info" role="button">STARTUP REP</a>
								
								</div>								
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<!-- This is the log in button -->
				<a href="login.jsp" class="btn btn-default btn-lg" role="button">Log In</a>
			</div>
			
		</div>
	</div>
</body>
</html>