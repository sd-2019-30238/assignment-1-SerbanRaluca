<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1> Place Order </H1>
<!--Invalidate the session-->
<%
session.invalidate();
%>
Your order has been placed. Thank you for shopping.
<P>
<FORM method=get action="ProductList.jsp">
<INPUT type=submit value="Resume Shopping">
</FORM>
</P>
</body>
</html>