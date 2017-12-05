

<nav class="navbar navbar-fixed-bottom" style="background-color: #FFFFFF;">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
    
            <ul class="nav navbar-nav navbar-right">
            <li><a href="#resourcesModal" data-toggle="modal"><h5>Resources</h5></a></li>
            <li><a href="#aboutModal" data-toggle="modal"><h5>About Us</h4></a></li>
            <li><a href="#teamModal" data-toggle="modal"><h5>The Team</h4></a></li>
            <li><a href="#disclaimerModal" data-toggle="modal"><h5>Disclaimer</h4></a></li>
            </ul>
            
		</div>
     </div>
</nav>


       <!-- Resources Modal -->
			<div class="modal fade" id="resourcesModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p><%@ include file="resources.jsp"%></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</div>

            <!-- DisclaimerModal -->
			<div class="modal fade" id="disclaimerModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p><%@ include file="Disclaimer.jsp"%></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</div>
			
			     <!-- About Us Modal -->
			<div class="modal fade" id="aboutModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p><%@ include file="aboutUs.jsp"%></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</div>
		
		    <!-- Team Modal -->
			<div class="modal fade" id="teamModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p><%@ include file="team.jsp"%></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</div>
			
