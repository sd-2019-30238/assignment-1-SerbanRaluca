<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assignment3</title>
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

* {
	box-sizing: border-box
}

body {
	font-family: Verdana, sans-serif;
	margin: 0
}

.mySlides {
	display: none
}

img {
	vertical-align: middle;
}

/* Slideshow container */
.slideshow-container {
	max-width: 1000px;
	position: relative;
	margin: auto;
}

/* Next & previous buttons */
.prev, .next {
	cursor: pointer;
	position: absolute;
	top: 50%;
	width: auto;
	padding: 16px;
	margin-top: -22px;
	color: white;
	font-weight: bold;
	font-size: 18px;
	transition: 0.6s ease;
	border-radius: 0 3px 3px 0;
	user-select: none;
}

/* Position the "next button" to the right */
.next {
	right: 0;
	border-radius: 3px 0 0 3px;
}

/* On hover, add a black background color with a little bit see-through */
.prev:hover, .next:hover {
	background-color: rgba(0, 0, 0, 0.8);
}

/* Caption text */
.text {
	color: #f2f2f2;
	font-size: 15px;
	padding: 8px 12px;
	position: absolute;
	bottom: 8px;
	width: 100%;
	text-align: center;
}

/* Number text (1/3 etc) */
.numbertext {
	color: #f2f2f2;
	font-size: 12px;
	padding: 8px 12px;
	position: absolute;
	top: 0;
}

/* The dots/bullets/indicators */
.dot {
	cursor: pointer;
	height: 15px;
	width: 15px;
	margin: 0 2px;
	background-color: #bbb;
	border-radius: 50%;
	display: inline-block;
	transition: background-color 0.6s ease;
}

.active, .dot:hover {
	background-color: #717171;
}

/* Fading animation */
.fade {
	-webkit-animation-name: fade;
	-webkit-animation-duration: 1.5s;
	animation-name: fade;
	animation-duration: 1.5s;
}

@
-webkit-keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}
@
keyframes fade {
	from {opacity: .4
}

to {
	opacity: 1
}

}

/* On smaller screens, decrease text size */
@media only screen and (max-width: 300px) {
	.prev, .next, .text {
		font-size: 11px
	}
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
					class="but6">Log out </a><a
					href="${pageContext.request.contextPath}/cart" class="but6">My
					cart </a>
			</div>
		</div>
	</div>

	<div class="a" id="wrapper">
		<div id="content_inside">
			<div class="a">
				<div id="sidebar">
					<img src="images/title1.gif" alt="" width="174" height="30" /> <br></br>

					<ul id="list">
						<li class="color"><a
							href="${pageContext.request.contextPath}/product">All
								products</a></li>
						<li class="color"><a
							href="${pageContext.request.contextPath}/Category1Servlet">Sofas
								and armchairs</a></li>
						<li class="color"><a
							href="${pageContext.request.contextPath}/Category2Servlet">Tables
								and chairs</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Category3Servlet">Bedroom</a></li>
						<li class="color"><a
							href="${pageContext.request.contextPath}/Category4Servlet">Office</a></li>
						<li><a
							href="${pageContext.request.contextPath}/Category5Servlet">Outdoor</a></li>
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
							high-end design doesn't mean inaccessible.<br>
							<br>
						</p>
					</div>
				</div>
			</div>
			<div class="slideshow-container">

				<div class="mySlides fade">
					<div class="numbertext">1 / 3</div>
					<img src="images/slide3.jpg" style="width: 100%">
					<div class="text">Caption Text</div>
				</div>

				<div class="mySlides fade">
					<div class="numbertext">2 / 3</div>
					<img src="images/slide1.jpeg" style="width: 100%">
					<div class="text">Caption Two</div>
				</div>

				<div class="mySlides fade">
					<div class="numbertext">3 / 3</div>
					<img src="images/slide2.jpg" style="width: 100%">
					<div class="text">Caption Three</div>
				</div>

				<a class="prev" onclick="plusSlides(-1)">&#10094;</a> <a
					class="next" onclick="plusSlides(1)">&#10095;</a>

			</div>
			<br>

			<div style="text-align: center">
				<span class="dot" onclick="currentSlide(1)"></span> <span
					class="dot" onclick="currentSlide(2)"></span> <span class="dot"
					onclick="currentSlide(3)"></span>
			</div>

			<script>
				var slideIndex = 1;
				showSlides(slideIndex);

				function plusSlides(n) {
					showSlides(slideIndex += n);
				}

				function currentSlide(n) {
					showSlides(slideIndex = n);
				}

				function showSlides(n) {
					var i;
					var slides = document.getElementsByClassName("mySlides");
					var dots = document.getElementsByClassName("dot");
					if (n > slides.length) {
						slideIndex = 1
					}
					if (n < 1) {
						slideIndex = slides.length
					}
					for (i = 0; i < slides.length; i++) {
						slides[i].style.display = "none";
					}
					for (i = 0; i < dots.length; i++) {
						dots[i].className = dots[i].className.replace(
								" active", "");
					}
					slides[slideIndex - 1].style.display = "block";
					dots[slideIndex - 1].className += " active";
				}
			</script>

		</div>
	</div>
	<br />
	<br />

</body>
</html>