<%@ page import="java.util.Date,java.text.*"%>

<%
	Date now = new Date();

	DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss SSS");
%>

<h4>Current Time:<%=df.format(now)%></h4>