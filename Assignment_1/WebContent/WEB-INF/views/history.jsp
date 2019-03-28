<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order History</title>
</head>
<style>
table
{
    counter-reset: rowNumber;
}

table tr > td:first-child
{
    counter-increment: rowNumber;
}
                
table tr td:first-child::before
{
    content: counter(rowNumber);
    min-width: 1em;
    margin-right: 0.5em;
}

</style>
<body bgcolor=#99FF99>
<h1>Orders:</h1>
<table cellpadding="50" cellspacing="2" border="1"
		id="tableOrderList">
		<tr>
			<th>First Name:</th>
			<th>Last name:</th>
			<th>Address:</th>
			<th>City:</th>
			<th>ZipCode:</th>
			<th>Country:</th>
			<th>Total:</th>
			<th>State:</th>
		</tr>
		<c:forEach var="order" items="${orders}">
			<tr>
				<td>${order.first_name }</td>
				<td>${order.last_name }</td>
				<td>${order.address }</td>
				<td>${order.city }</td>
				<td>${order.zipcode }</td>
				<td>${order.country }</td>
				<td>${order.total }</td>
				<td>${order.state }</td>
			</tr>
		</c:forEach>
	</table>
    <a href="${pageContext.request.contextPath}/userInfo"
					class="but5">My Account </a>
</body>
</html>