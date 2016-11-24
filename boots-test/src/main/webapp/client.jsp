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
					<li><a href="/client">Client</a></li>
					<li><a href="new-client">Manage Client</a></li>
					<li><a href="all-clients">All clients</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
	<c:when test="${mode== 'MODE_CLIENT'}">
	<div class="container">
		<div class="jumbotron text-center" id="homeDiv">
			<h1>Welcome to Client Manager</h1>
		</div>
	</div>
	</c:when>
	
	<c:when test="${mode== 'MODE_CLIENTS'}">
	<div class="container text-center" id="clientsDiv">
		<h3>My Clients</h3>
		<hr/>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Num Membership</th>
						<th>Name</th>
						<th>Telephone</th>
						<th>Address</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="client" items="${clients}">
						<tr>
							<td>${client.numMembership}</td>
							<td>${client.name}</td>
							<td>${client.telephone}</td>
							<td>${client.address}</td>
							<td><a href="update-client?id=${client.numMembership}">
							<span class="glyphicon glyphicon-pencil"></span>
							</a></td>
							<td><a href="delete-client?id=${client.numMembership }">
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
			<h3>Manager Client</h3>
			<hr />
			<form class="form-horizontal" method="POST" action="save-client">
				<input type="hidden" name="id" value="${client.numMembership}" />
				<div class="form-group">
					<label class="control-label col-md-3">Name</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${client.name}" name="name"/>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-md-3">Telephone</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${client.telephone}" name="telephone"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">Address</label>
					<div class="col-md-7">
						<input type="text" class="form-control"
						 value="${client.address}" name="address"/>
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
