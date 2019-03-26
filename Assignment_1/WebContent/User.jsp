<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>User Page</title>
</head>
<%
	if ((request.getSession(false).getAttribute("User") == null)) {
%>
<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>
<body  bgcolor=#99FF99>
	<%
		if (session.getAttribute("User") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<center>
		<h2>User's Home</h2>
	</center>
	Login Successful!<br>
	Welcome
	<%=request.getAttribute("userName")%>!
	
	
	<div style="text-align: left">
		<a href="<%=request.getContextPath()%>/home">Continue shopping</a>
	</div>

	<div style="text-align: right">
		<a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
	</div>

</body>
</html>