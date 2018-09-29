<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AddEmployee" method="post">
	<table>
	<tr>
		<td>EmployeeName</td>  <td><input type="text" name="employeeName" required></td>
	</tr>
	<tr>
		<td>EmailId</td>  <td><input type="text" name="emailId" required></td>
	</tr>
	<tr>
		<td>Source</td>  <td><input type="text" name="source" required></td>
	</tr>
	<tr>
		<td>Destination</td>  <td><input type="text" name="destination" required></td>
	</tr>
	<tr>
		<td>TravelPurpose</td>  <td><input type="text" name="travelPurpose" required></td>
	</tr>
	<tr>
		<td>TravelMode</td>  <td><input type="text" name="travelMode" required></td>
	</tr>
	 <tr>
		<td>Duration</td>  <td><input type="text" name="duration" required></td>
	</tr>
	
	</table>
	
	<input type="submit">
	</form>
</body>
</html>