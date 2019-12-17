<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<%@ page import="com.demo.service.*"%>
<html>

<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="js/script.js"></script>
</head>

<body>
	<jsp:useBean id="service" class="com.demo.service.UserService" />
	
	<div class="row">
	
		<div class="col-md-6">

			<form method="post" action="insert.jsp">
		
				<div class="form-group">
					<label for="name">Name</label> 
					<input type="text" id="name"
						name="name" />
				</div>
		
				<div class="form-group">
					<label for="lastName">Last Name</label> 
					<input type="text" id="lastName" name="lastName" />
						
				</div>
		
				<div class="form-group">
					<label for="city">City</label> 
					<input type="text" id="city" name="city" />
						
				</div>
		
				<div class="form-group">
					<label for="zipCode">Zip Code</label> 
					<input type="text" id="zipCode" name="zipCode" />
						
				</div>
	
					<input type="submit" value="OK" />
				
			</form>
		</div>
	</div>

	<h2>Users List</h2>

	<%
		List<User> list = service.findAll();
	%>

	<div class="row">

		<%
			for (User user : list) {
		%>

		<div class="col-sm-4">
			<div class="panel panel-info">
				<div class="panel panel-heading">

					<span><%=user.getName()%></span> <a
						href="delete.jsp?id=<%=user.getId()%>"><img
						src="images/delete.png" /></a>

				</div>

				<div class="panel panel-body">
					<div class="border border-primary">
						<%=user.getLastName()%>
					</div>
					<div class="border border-primary">
						<%=user.getCity()%>
					</div>
					<div class="border border-primary">
						<%=user.getZipcode()%>
					</div>
				</div>
			</div>
		</div>


		<%
			}
		%>

	</div>


</body>
</html>
