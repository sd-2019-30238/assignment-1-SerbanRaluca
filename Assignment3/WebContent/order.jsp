<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body bgcolor=#99FF99>
	<H1>Place Order</H1>
	Your order has been placed. Thank you for shopping.
	<%=(request.getAttribute("total")==null) ? "Sorry,no discount!Total must be higher than 1000!Total="+request.getAttribute("discountTotal"): "Total after discount:"+request.getAttribute("discountTotal")%>

	<FORM method=get action="product">
		<INPUT type=submit value="Resume Shopping">
	</FORM>

</body>
</html>