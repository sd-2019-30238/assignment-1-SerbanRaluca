<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
</head>
<body bgcolor=#99FF99>
	<form method="post" action="add">
		<table align="center">
			<tr>
				<td>Code:</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Photo:</td>
				<td><input type="text" name="photo"></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add"></td>
			</tr>
		</table>

	</form>
</body>
</html>