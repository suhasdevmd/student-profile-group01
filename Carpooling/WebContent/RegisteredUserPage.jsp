<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome!Please Select Dstn and Time</title>
</head>
<s:a href="Unregister">Unregister from carpooling</s:a>
<s:a href="feedback">Suggestions/Complaints</s:a>
<s:a href="Registered_Users">ViewAllregisteredUsers</s:a>
<s:a href="ModifyCarpoolingDetails">Modify CarpoolingDetails</s:a>
<body>
    <h2>Welcome To CarPooling</h2>
    
    <s:form action="welcome" namespace="/">
 
<h4>
	<s:select label="Destination" 
		headerKey="-1" headerValue="Select Destination"
		list="DestinationList" 
		name="yourdestination" 
		value="defaultdestination" />
</h4> 
 
<h4>
	<s:select label="DepartureTime" 
		headerKey="-1" headerValue="Select DepartureTime" 
		list ="DepartureList"
		name="yourDepartureTime" 
		value="defaultdeparturetime" />
</h4> 
 
<s:submit value="submit" name="submit" />
 
</s:form>
</body>
</html>