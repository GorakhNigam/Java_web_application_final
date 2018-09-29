<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% String user = request.getParameter("username");
	String pass = request.getParameter("password");
	if(user.equals("Manager") && pass.equals("Manager"))
	{%><jsp:forward page="AdminView.jsp"></jsp:forward>
	<%} else { %>
	Unauthorised aceess...
	<jsp:include page="Login.jsp"></jsp:include>
	<%} %>
	<%--<h2>Welcome <%out.println(user);} %></h2> --%>
</body>
</html>