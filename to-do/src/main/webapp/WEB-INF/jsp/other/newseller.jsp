<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    .footer {
  position: relative;
  /*bottom: 0; */
  /*width: 100%; */
  /* Set the fixed height of the footer here */
  height: 250px;
  margin-top:-200px;
  background-color:#D4DCDF;
  clear: both;
}

    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>
		    			<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home</a></li>
        <li><a href="newseller">New seller</a></li>
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>

	<c:choose>
	
	<c:when test="${mode == 'MODE_HOME'}">
			<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Welcome </h1>
				</div>
			</div>
		</c:when>
		
			<c:when test="${mode == 'MODE_DETAILS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>Seller List</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Id</th>
								<th>Seller Name</th>
								<th>Contact First Name</th>
								<th>Contact Last Name</th>
								<th>Address</th>
								<th>City</th>
								<th>ZIP</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sellerList" items="${sellerList}">
								<tr>
									<td>${sellerList.id}</td>
									<td>${sellerList.sellerName}</td>
									<td>${sellerList.firstName}</td>
									<td>${sellerList.lastName}</td>
									<td>${sellerList.address1}</td>
									<td>${sellerList.city}</td>
									<td>${sellerList.zip}</td>
									<td><a href="updateseller?id=${sellerList.id}"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a href="deleteseller?id=${sellerList.id}"><span class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
	<c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">


		<div class="container">
		  <h2>Seller Details</h2> <br>
		  <form action="/newseller" method="post">
		  	<input type="hidden" name="id" value="${sellerobj.id}"/>
 				<div class="form-group"> 
<%-- 						<input type="hidden" class="form-control" name="name" value="${sessionScope.username}"/> 
 --%>						</div>				 
<!-- 					</div> -->
		    <div class="form-group">
		      <label >Seller Name:</label>
		      <input type="text" class="form-control"  placeholder="Enter seller Name" name="sellerName" value="${sellerobj.sellerName}">
		    </div>
		     <div class="form-group">
		      <label >Contact Person First Name:</label>
		      <input type="text" class="form-control"  placeholder="Enter Contact Person First Name" name="firstName" value="${sellerobj.firstName}">
		    </div>
		    <div class="form-group">
		      <label >Contact Person Last Name:</label>
		      <input type="text" class="form-control"  placeholder="Enter Contact Person Last Name" name="lastName" value="${sellerobj.lastName}">
		    </div>
		    <div class="form-group">
		      <label >Address 1 :</label>
		      <input type="text" class="form-control"  placeholder="Enter Address 1" name="address1" value="${sellerobj.address1}">
		    </div>
		     <div class="form-group">
		      <label >Address 2 :</label>
		      <input type="text" class="form-control"  placeholder="Enter Address 2" name="address2" value="${sellerobj.address2}">
		    </div>
		     <div class="form-group">
		      <label >city : </label>
		      <input type="text" class="form-control"  placeholder="Enter city" name="city" value="${sellerobj.city}">
		    </div>
		     <div class="form-group">
		      <label >State :</label>
		      <input type="text" class="form-control"  placeholder="Enter State Name" name="state" value="${sellerobj.state}">
		    </div>
		    <div class="form-group">
		      <label >Zip :</label>
		      <input type="text" class="form-control"  placeholder="Enter Zip" name="zip" value="${sellerobj.zip}">
		    </div>
		    <div class="form-group">
		      <label >Phone number:</label>
		      <input type="text" class="form-control"  placeholder="Enter Phone Number" name="phone" value="${sellerobj.phone}">
		    </div>
		     <div class="form-group">
		      <label >Fax: </label>
		      <input type="text" class="form-control"  placeholder="Enter Fax" name="fax" value="${sellerobj.fax}">
		    </div>
		     <div class="form-group">
		      <label >Username:</label>
		      <input type="text" class="form-control" id="username" placeholder="Enter Username" name="username" value="${sellerobj.username}">
		    </div>
		     <div class="form-group">
		      <label >Password:</label>
		      <input type="text" class="form-control" id="password" placeholder="Enter Password" name="password" value="${sellerobj.password}">
		    </div>
		    
		     <c:if test="${mode=='MODE_NEW'}">
		     <div class="form-group">
		      			<label >Re-enter Password:</label>
		     		 	<input type="text" class="form-control" id="zip" placeholder="Re-enter Password" name="reenterPassword">
		    	</div>
		    	

			
			 </c:if>
		   
		     <button type="submit" class="btn btn-default">Submit</button>
		     <button type="button" class="btn btn-default">Cancel</button>
		     		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		  </form>
		  <br>
		  <br>
		</div>

	</c:when>
	</c:choose>


<footer class="container-fluid text-center">
  <p></p>
</footer>

</body>
</html>
