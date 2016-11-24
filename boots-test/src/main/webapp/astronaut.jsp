<%@page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
	<title>Bootstrap sample| Home</title>
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="/static/css/styles.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="nav navbar-nav">
				<ul class="nav navbar-nav">
					<li><a href="astronaut">Astronaut</a></li>
					<li><a href="new-astronaut">Manage Astronaut</a></li>
					<li><a href="all-astronauts">All Astronauts</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode== 'MODE_ASTRONAUT'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Astronaut Manager</h1>
		</div>
	</div>
	</c:when>

	<c:when test="${mode== 'MODE_ASTRONAUTS'}">
	<div class="container text-center" id="studentsDiv">
		<h3>My Astronauts</h3>
		<hr/>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Age</th>
						<th>Date register</th>
						<th>Status</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="student" items="${astronauts}">
						<tr>
							<td>${astronaut.astronautId}</td>
							<td>${astronaut.astronautName}</td>
							<td>${astronaut.status}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${astronaut.dateRegister}"/> </td>
							<td>${astronaut.status==true?'Yes':'No'}</td>
							<td><a href="update-astronaut?id=${astronaut.studentId }">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-astronaut?id=${astronaut.astronautId }">
							<span class="glyphicon glyphicon-trash"></span>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
	</div>
	</c:when>
	<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
		<div class="container text-center">
			<h3>Manager Astronaut</h3>
			<hr />
			<form class="form-horizontal" method="POST" action="save-astronaut">
				<input type="hidden" name="astronautId" value="${astronaut.astronautId}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${astronaut.astronautName}" name="astronautName"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Age</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${astronaut.age}" name="age"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Status</label>
					<div class="col-md-7">
						<input type="radio" class="col-sm-1"
						 name="status" value="true"/>
						 <div class="col-sm-1">Yes</div>
						 <input type="radio" class="col-sm-1"
						 name="status" value="false" checked="checked"/>
						 <div class="col-sm-1">No</div>
					</div>
				</div>
				
				<div class="form-group">
					<input type="submit" class="btn btn-primary" value="Save"/>
				</div>
				
			</form>
			
		</div>
	
	</c:when>
	

	</c:choose>
	
	
	
	
	

	<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js">
	</script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js">
	</script>
	
	
</body>
</html>
