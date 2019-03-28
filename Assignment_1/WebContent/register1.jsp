<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign up</title>
<script>
	function validate() {
		var firstname = document.form.first_name.value;
		var lastname = document.form.last_name.value;
		var email = document.form.email.value;
		var username = document.form.username.value;
		var password = document.form.password.value;
		var conpassword = document.form.conpassword.value;

		if (firstname == null || firstname == "") {
			alert("First Name can't be blank");
			return false;
		} else if (lastname == null || lastname == "") {
			alert("Last Name can't be blank");
			return false;
		} else if (email == null || email == "") {
			alert("Email can't be blank");
			return false;
		} else if (username == null || username == "") {
			alert("Username can't be blank");
			return false;
		} else if (password.length < 6) {
			alert("Password must be at least 6 characters long.");
			return false;
		} else if (password != conpassword) {
			alert("Confirm Password should match with the Password");
			return false;
		}
	}
</script>
</head>
<body bgcolor=#99FF99>
	<center><h1>New User Registration</h1></center>
	<form name="form" action="Register" method="post"
		onsubmit="return validate()">
		<table style="with: 50%" align="center">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" name="contact" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="conpassword" /></td>
			</tr>
			<tr>
				<td><span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register"></input><input type="reset" value="Reset"></input></td>
			</tr>
		</table>
	</form>
</body>
</html>