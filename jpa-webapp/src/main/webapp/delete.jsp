<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>
<%@ page import="com.demo.model.*"%>
<%@ page import="com.demo.service.*"%>
<html>

<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="js/script.js"></script>
</head>

<body>
	<jsp:useBean id="service" class="com.demo.service.UserService" />

	<%
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = service.findUser(id);

		service.removeUser(user);
		
		response.sendRedirect("index.jsp");
	%>

</body>