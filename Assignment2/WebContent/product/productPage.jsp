<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Product Page</title>


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
	<h2>Filter products:</h2>

	<div class="a" style="text-align: right">
		<a href="${pageContext.request.contextPath }/home">Home</a>
	</div>

	<div class="dropdown">
		<button onclick="myFunction()" class="dropbtn">Type</button>
		<div id="myDropdown" class="dropdown-content">
			<a href="${pageContext.request.contextPath}/Category1Servlet">Sofas
				and armchairs</a> <a
				href="${pageContext.request.contextPath}/Category2Servlet">Tables
				and chairs</a> <a
				href="${pageContext.request.contextPath}/Category3Servlet">Bedroom</a>
			<a href="${pageContext.request.contextPath}/Category4Servlet">Office</a>
			<a href="${pageContext.request.contextPath}/Category5Servlet">Outdoor</a>
		</div>
	</div>



	<script>
		/* When the user clicks on the button,
		 toggle between hiding and showing the dropdown content */
		function myFunction() {
			document.getElementById("myDropdown").classList.toggle("show");
		}
	</script>

	<div class="a">
		<form method="get" action="PriceServlet">
			<div data-role="rangeslider">
				<label for="price-min">Price min:</label> <input type="range"
					name="price-min" id="price-min" value="0" min="0" max="500">
				<label for="price-max">Price max:</label> <input type="range"
					name="price-max" id="price-max" value="500" min="0" max="500">
			</div>
			<input type="submit" data-inline="true" value="Submit">
		</form>
	</div>

	<div class="a">
		<form method="post" name="frm" action="search">
			<table border="0" width="300" align="left" bgcolor="#99FF99">
				<tr>
					<td colspan=2 style="font-size: 12pt;" align="center">
						<h3>Search Product:</h3>
					</td>
				</tr>
				<tr>
					<td><b>Name:</b></td>
					<td>: <input type="text" name="pid" id="pid">
					</td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="submit"
						name="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</div>
	<br></br>

	<table cellpadding="70" cellspacing="2" border="1"
		id="tableProductList">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Photo</th>
			<th>Price</th>
			<th>Buy</th>
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
					href="${pageContext.request.contextPath }/cart?&action=buy&code=${product.code }">Buy</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>