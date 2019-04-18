<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Admin Page</title>
</head>
<body bgcolor=#99FF99>
	<center>
		<h2>Admin's Home</h2>
	</center>
	<a href="${pageContext.request.contextPath}/products">Products</a> |
	<a href="${pageContext.request.contextPath}/orders">Update Order</a> |
	<a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a>
	<br> Hello Admin:
	<b>${loginedUser.userName}</b>

</body>
</html>