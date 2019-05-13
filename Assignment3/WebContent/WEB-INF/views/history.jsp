<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order History</title>
</head>
<body bgcolor=#99FF99>
	<h1>Orders:</h1>
	<table cellpadding="30" cellspacing="2" border="1" id="tableOrderList">
		<tr>
			<th>Id</th>
			<th>First Name:</th>
			<th>Last name:</th>
			<th>Address:</th>
			<th>City:</th>
			<th>ZipCode:</th>
			<th>Country:</th>
			<th>Total:</th>
			<th>State:</th>
			<th>Feedback</th>
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.id }</td>
				<td>${order.first_name }</td>
				<td>${order.last_name }</td>
				<td>${order.address }</td>
				<td>${order.city }</td>
				<td>${order.zipcode }</td>
				<td>${order.country }</td>
				<td>${order.total }</td>
				<td>${order.state }</td>
				<td><a
					href="${pageContext.request.contextPath}/feedback?action=feedback&id=${order.id }&feedback=Good service!">Good
						service</a> <a
					href="${pageContext.request.contextPath}/feedback?action=feedback&id=${order.id }&feedback=Bad service!">Bad
						service</a> <span style="color: red"><%=(request.getAttribute("errMsg") == null) ? "" : request.getAttribute("errMsg")%></span>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/userInfo" class="but5">My
		Account </a>
</body>
</html>