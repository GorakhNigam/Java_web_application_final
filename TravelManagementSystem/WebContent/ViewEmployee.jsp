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
		<table border="1">
		<tr>
			<th>EmployeeName</th><th>EmpId</th><th>Source</th><th>Destination</th><th>TravelPurpose</th><th>TravelMode</th>
			<th>TravelExpense</th><th>DateFrom</th><th>DateTo</th>			
		</tr>
		<c:forEach var="emp" items="${empls}">
		<tr>
			<td><c:out value="${emp.employeeName}"></c:out></td>
			<td><c:out value="${emp.emailId}"></c:out></td>
			<td><c:out value="${emp.source}"></c:out></td>
			<td><c:out value="${emp.destination}"></c:out></td>
			<td><c:out value="${emp.travelPurpose}"></c:out></td>
			<td><c:out value="${emp.travelMode}"></c:out></td>
			<td><c:out value="${emp.travelExpense}"></c:out></td>
			<td><c:out value="${emp.duration}"></c:out></td>
		</tr>
		</c:forEach>
		</table>
</body>
</html>