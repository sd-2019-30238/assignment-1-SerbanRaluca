<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Staff Page</title>
</head>
<%
	if ((request.getSession(false).getAttribute("Staff") == null)) {
%>
<jsp:forward page="/login.jsp"></jsp:forward>
<%
	}
%>
<body>
	<%
		if (session.getAttribute("Staff") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	<center>
		<h2>Staff's Home</h2>
	</center>

	Welcome
	<%=request.getAttribute("userName")%>

	<div style="text-align: right">
		<a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a>
	</div>

</body>
</html>
