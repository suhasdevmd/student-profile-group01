<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome!Please Select Dstn and Time</title>
</head>
<body>


	<br />
	<br>
	<br>
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="Register.jsp">Register For Carpooling</a></li>
				<li><a href="Suggestions.jsp">Suggestions</a></li>
				<li><a href="Complaints.jsp">Complaints</a></li>
				<li><a href="ViewAllRegisteredusers.jsp">View All
						registered Users</a></li>

			</ul>
		</div>
	</div>
<s:form action="welcome" method="post" namespace="/">
 
<h4>
	<s:select label="Destination" 
		headerKey="-1" headerValue="Select Destination"
		list="DestinationList" 
		name="destination" 
		value="defaultdestination" />
</h4> 
 
<h4>
	<s:select label="DepartureTime" 
		headerKey="-1" headerValue="Select DepartureTime" 
		list ="DepartureList"
		name="departuretime" 
		value="defaultdeparturetime" />
</h4> 
 
<s:submit value="submit" name="submit" />
 
</s:form>


</body>
</html>