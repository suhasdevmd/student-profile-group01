<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Student Information System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<meta name="keywords"
	content="glossy box, web design, colorful background, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Glossy Box | free website template with a colorful background" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
</head>
<body>

	<s:actionerror />
	<div id="templatemo_wrapper_outer">
		<div id="templatemo_wrapper">
			<div class="cleaner_h20"></div>
			<div id="templatemo_header">
				<div>
					<h1 style="color: white;">
						<strong>Student Information System</strong>
					</h1>
				</div>
				<div class="cleaner"></div>
			</div>

			<div
				style="border: 1px solid grey; border-radius: 5px; box-shadow: 1px 1px 5px white;height: 500px;">

				<div style="margin: 50px; padding: 10px; color: white;">


					<div style="float: left;">
						<img alt="College-logo" src="images/logo.jpg">
					</div>

					<div style="float: right;border: 1px solid grey; border-radius: 5px; box-shadow: 1px 1px 5px white;width: 250px;padding: 20px;margin-left: 10px;">
						<s:form action="login.action" method="post">
						
						
							<s:label value="Username"></s:label>
							<s:textfield name="username"  size="20" />
							<br>
							<s:label value="Password"></s:label>
							<s:password name="password"  size="20" />
							<br>
						<div style="float: left;">
							<s:submit value="Login" name="commandButton" id="Submit"
								align="left" cssClass="button" />
						</div><div style="float: right;">
							<!-- the below line -->
							<s:submit value="Forgot Password" name="commandButton"
								id="Forgot Password" align="left" cssClass="button" />
						</div>
						</s:form>
					</div>
					<br> <br> <br> <br> <br> <br> <br>
					<br> <br>
				</div>
			</div>
			
			
			<div id="templatemo_footer">

				Copyright © 2013 <a href="#">Team Blitzstrahl</a>

			</div>
			
		</div>
	</div>
</body>
</html>