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
	<form action="AdminView" method="post">
	<table>
	<tr>
		<td>SerialNo </td>  <td><c:out value="${empls.serialNo}"></c:out></td>
		</tr>
		<tr>
		<td>Employee Name </td>  <td><c:out value="${empls.employeeName}"></c:out></td>
		</tr>
		<tr>
		<td>Employee Id </td> <td><c:out value="${empls.emailId}"></c:out></td>
		</tr>
		<tr>
		<td>Source </td> <td><c:out value="${empls.source}"></c:out></td>
		</tr>
		<tr>
		<td>Destination </td><td><c:out value="${empls.destination}"></c:out></td>
		</tr>
		<tr>
		<td>Travel Purpose </td> <td><c:out value="${empls.travelPurpose}"></c:out></td>
		</tr>
		<tr>
		<td>Travel Mode </td> <td><c:out value="${empls.travelMode}"></c:out></td>
		</tr>
		<tr>
		<td>Duration </td> <td><c:out value="${empls.duration}"></c:out></td>
		</tr>
		<tr>
		<td style="color:red">Status </td> <td><input type="text" name="status" value="<c:out value="${empls.status}"></c:out>"></td>
		</tr>
	</table>
		<input type="submit">
	</form>	
</body>
</html>