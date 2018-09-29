<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateEmpl" method="post">
	<table>
		<tr>
		<td>Employee Name </td>  <td><input  type="text"   name="employeeName" value="<c:out value="${empls.employeeName}"></c:out>"></td>
		</tr>
		<tr>
		<td>Employee Id </td> <td><input type="text" name="emailId" value="<c:out value="${empls.emailId}"></c:out>"></td>
		</tr>
		<tr>
		<td>Source </td> <td><input type="text" name="source" value="<c:out value="${empls.source}"></c:out>"></td>
		</tr>
		<tr>
		<td>Destination </td><input type="text" name="destination" value="<c:out value="${empls.destination}"></c:out>">
		</tr>
		<tr>
		<td>Travel Purpose </td> <td><input type="text" name="travelPurpose" value="<c:out value="${empls.travelPurpose}"></c:out>"></td>
		</tr>
		<tr>
		<td>Travel Mode </td> <td><input type="text" name="travelMode" value="<c:out value="${empls.travelMode}"></c:out>"></td>
		</tr>
		<tr>
		<td>Duration</td> <td><input type="text" name="duration" value="<c:out value="${empls.duration}"></c:out>"></td>
		</tr>
		<tr>
		<td>Status </td> <td><input type="text" name="status" value="<c:out value="${empls.dateTo}" disabled></c:out>"></td>
		</tr>
	</table>
		<input type="submit">
	</form>	
</body>
</html>