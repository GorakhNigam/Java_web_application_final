<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<!--<h1>${message}</h1> 
	<h2>Login Successful ${student.getStdname()}</h2>
	<h3>Student Name ${student.getStdname()}</h3>
	<h3>Student Roll ${student.getStdroll()}</h3>
	<h3>Student Total ${student.getStdtotal()}</h3>  -->
	<h2>${name}</h2>
	<form action="validate">
	Usernamee <input type="text" name="empname"><br>
	<!-- Password <input type="password" name="password"><br> -->
	<input type="submit">
</body>
</html>