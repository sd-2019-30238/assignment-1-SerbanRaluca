<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>

<html>
<head>
<title>Cart Page</title>
</head>
<body bgcolor=#99FF99>

	<h2>My cart</h2>

	<table cellpadding="30" cellspacing="2" border="1">
		<tr>
			<th>Option</th>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.cart }">
			<c:set var="total"
				value="${total + item.product.price * item.quantity }"></c:set>
			<tr>
				<td align="center"><a
					href="${pageContext.request.contextPath }/cart?action=remove&code=${item.product.code }"
					onclick="return confirm('Are you sure?')">Remove</a></td>
				<td>${item.product.code }</td>
				<td>${item.product.name }</td>
				<td><img
					src="${pageContext.request.contextPath }/images/${item.product.photo }"
					width="120"></td>
				<td>${item.product.price }</td>
				<td>${item.quantity }</td>
				<td>${item.product.price * item.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
	<br>
	<div style="text-align: left">
		<a href="${pageContext.request.contextPath }/product">Resume
			Shopping</a>
	</div>

	<div style="text-align: center">
		<a href="${pageContext.request.contextPath }/checkout">Checkout</a>
	</div>

</body>
</html>