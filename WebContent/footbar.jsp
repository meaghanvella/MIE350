            <!-- About Us Modal -->
			<div class="modal fade" id="aboutModal" tabindex="-1" role="dialog">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<p></p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
			</div>
		
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

<nav class="navbar navbar-fixed-bottom" style="background-color: #D1E6FF;">
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
            <li><a href="#resourcesModal" data-toggle="modal"><h4><b>Resources</b></h4></a></li>
            <li><a href="#aboutModal" data-toggle="modal"><h4><b>About Us</b></h4></a></li>
            </ul>
            
		</div>
     </div>
</nav>

