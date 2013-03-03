<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Home Page</title>
<link rel="stylesheet" href="style.css" type="text/css" media="screen" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.tinycarousel.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#slider1').tinycarousel({
			pager : true,
			interval : true
		});
	});
</script>
</head>
<body>
	<div style="margin: 20px;">
		<h2 align="center">
			welcome ,
			<s:property value="%{#session.userName}" />
			!
		</h2>
		<s:actionmessage />
		<h3 align="center">Student Information System</h3>
		<form action=""></form>
		<div align="center" style="margin-left: 0px;">
			<div id="slider1">
				<a class="buttons prev" href="#">left</a>
				<div class="viewport">
					<ul class="overview">
						<!-- <li><img src="images/iiitb1.jpg" /></li>
						<li><img src="images/iiitb2.jpg" /></li>
						<li><img src="images/iiitb3.jpg" /></li>
						<li><img src="images/iiitb1.jpg" /></li>
						<li><img src="images/iiitb2.jpg" /></li>
						<li><img src="images/iiitb3.jpg" /></li> -->
						<li><img src="images/clg1.jpg" /></li>
						<li><img src="images/clg2.jpg" /></li>
					</ul>
				</div>
				<a class="buttons next" href="#">right</a>
			</div>

		</div>
	</div>
</body>
</html>