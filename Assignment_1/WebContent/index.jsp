<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assignment_1</title>
<style>
.a div {
	display: inline-block;
}

div.scrollmenu {
	background-color: #333;
	overflow: auto;
	white-space: nowrap;
}

div.scrollmenu a {
	display: inline-block;
	color: white;
	text-align: center;
	padding: 14px;
	text-decoration: none;
}

div.scrollmenu a:hover {
	background-color: #777;
}
</style>
</head>
<body bgcolor=#99FF99>
	<div class="a" id="header">
		<div id="header_inside">
			<img src="images/header.jpg" alt="setalpm" width="1500" height="222"
				border="0" usemap="#Map" /><br />
			<div class="scrollmenu">
				<a href="${pageContext.request.contextPath}/" class="but1_active">Home
					Page </a> <a href="${pageContext.request.contextPath}/userInfo"
					class="but5">My Account </a> <a
					href="${pageContext.request.contextPath}/contact" class="but6">Contacts
				</a> <a href="${pageContext.request.contextPath}/login" class="but6">Login
				</a> <a href="${pageContext.request.contextPath}/register" class="but6">Register
				</a> <a href="${pageContext.request.contextPath}/LogoutServlet"
					class="but6">Log out </a>
			</div>
		</div>
	</div>

	<div class="a" id="wrapper">
		<div id="content_inside">
			<div class="a">
				<div id="sidebar">
					<img src="images/title1.gif" alt="" width="174" height="30" /> <br></br>

					<ul id="list">
						<li class="color"><a href="#">OFFICE</a></li>
						<li class="color"><a href="#">Tables</a></li>
						<li><a href="#">OUTDOOR</a></li>
						<li class="color"><a href="#">BATHROOM</a></li>
						<li><a href="#">KITCHEN</a></li>
					</ul>
				</div>
				<div class="a" id="main_block">
					<div class="inline">
						<img src="images/title2.gif" alt="" width="191" height="30" /> <br></br>

						<p>
							We believe that aesthetics should be an integral part of daily
							life.<br> This is the principle that drives us to create
							products that can make everyday a little bit better and
							beautiful.<br> We bring high-quality, unique and
							contemporary designs, that are affordable to everyone.<br>
							Designs that make life, work, and play better.<br> To us,
							high-end design doesn't mean inaccessible.
						</p>
					</div>
				</div>
			</div>
			<div id="items">
				<div class="item">
					<img src="images/item1.jpg" alt="" width="202" height="173" /><br />
					<span>$99</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
				<div class="item">
					<img src="images/item2.jpg" alt="" width="202" height="173" /><br />
					<span>$150</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
				<div class="item">
					<img src="images/item3.jpg" alt="" width="202" height="173" /><br />
					<span>$250</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
				<div class="item">
					<img src="images/item4.jpg" alt="" width="202" height="173" /><br />
					<span>$120</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
				<div class="item">
					<img src="images/item5.jpg" alt="" width="202" height="173" /><br />
					<span>$1255</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
				<div class="item">
					<img src="images/item6.jpg" alt="" width="202" height="173" /><br />
					<span>$215</span><a href="index2.html" class="view">View</a><a
						href="#" class="buy">Buy this Product</a>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />
	<p>
		Copyright &copy;. All rights reserved. Design by <a
			href="http://www.bestfreetemplates.info" target="_blank"
			title="Best Free Templates">BFT</a>
	</p>
	<map name="Map">
		<area shape="rect" coords="78,45,312,119" href="index.html">
		<area shape="poly" coords="670,87,719,78,727,123,677,130" href="#">
		<area shape="poly" coords="776,124,818,152,793,189,751,160" href="#">
		<area shape="poly" coords="834,52,885,61,878,105,828,96" href="#">
	</map>

</body>
</html>