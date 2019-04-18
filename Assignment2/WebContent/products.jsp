<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Products</title>


<style>
.a div {
	display: inline-block;
}

.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropbtn:hover, .dropbtn:focus {
	background-color: #3e8e41;
}

#myInput {
	border-box: box-sizing;
	background-image: url('searchicon.png');
	background-position: 14px 12px;
	background-repeat: no-repeat;
	font-size: 16px;
	padding: 14px 20px 12px 45px;
	border: none;
	border-bottom: 1px solid #ddd;
}

#myInput:focus {
	outline: 3px solid #ddd;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f6f6f6;
	min-width: 230px;
	overflow: auto;
	border: 1px solid #ddd;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}
</style>

</head>
<body bgcolor=#99FF99>

	<div align="right">
		<a href="${pageContext.request.contextPath }/Admin.jsp">Home</a>
	</div>
	<table cellpadding="50" cellspacing="2" border="1"
		id="tableProductList">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Remove</th>
			<th>Discount</th>
		</tr>
		<c:forEach var="product" items="${products }">
			<tr>
				<td>${product.code }</td>
				<td>${product.name }</td>
				<td><img
					src="${pageContext.request.contextPath }/images/${product.photo }"
					width="300"></td>
				<td>${product.price }</td>
				<td align="center"><a
					href="${pageContext.request.contextPath }/products?&action=remove&code=${product.code }">Remove</a>
					<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
				</td>
				<td><a
					href="${pageContext.request.contextPath}/products?&action=addDiscount&code=${product.code}&price=${product.price}&discount=10">
						ApplyDiscount:10%</a> <a
					href="${pageContext.request.contextPath}/products?&action=addDiscount&code=${product.code}&price=${product.price}&discount=15">
						ApplyDiscount:15%</a> <a
					href="${pageContext.request.contextPath}/products?&action=addDiscount&code=${product.code}&price=${product.price}&discount=20">
						ApplyDiscount:20%</a></td>
			</tr>
		</c:forEach>
	</table>
	<div align="left">
		<a href="${pageContext.request.contextPath }/products?&action=add">Add
			new product</a>
	</div>



</body>
</html>