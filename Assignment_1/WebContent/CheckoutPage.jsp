<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<script>
	function validate() {
		var firstname = document.form.firstname.value;
		var lastname = document.form.lastname.value;
		var address = document.form.address.value;
		var city = document.form.city.value;
		var zipcode = document.form.zipcode.value;
		var country = document.form.country.value;

		if (firstname == null || firstname == "") {
			alert("First Name can't be blank");
			return false;
		} else if (lastname == null || lastname == "") {
			alert("Last Name can't be blank");
			return false;
		} else if (address == null || address == "") {
			alert("Address can't be blank");
			return false;
		} else if (city == null || city == "") {
			alert("City can't be blank");
			return false;
		} else if (zipCode==null || zipcode=="") {
			alert("ZipCode can't be blank.");
			return false;
		} else if (country==null || country=="") {
			alert("Conuntry can't be blank.");
			return false;
		}
	}
</script>
</head>
<body bgcolor=#99FF99>
	<table cellpadding="30" cellspacing="2" border="1">
		<tr>
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
			<td colspan="5" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>
		<form action="order"  method="post">
			<h1 align="center">Checkout</h1>
			First name: <input type="text" name="firstname"><br>
			Last name: <input type="text" name="lastname"><br>

			Address: <input type="text" name="address"><br>
			City: <input type="text" name="city"><br> 
			Zip Code: <input type="text" name="zipcode"><br> 
			Country: <input type="text" name="country"><br> 
			<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			<input type="submit" value="Confirm">
		</form>
</body>
</html>