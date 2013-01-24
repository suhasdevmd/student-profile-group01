<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Pooling</title>
</head>
<body>
 <h2>Welcome !</h2>
    <s:form action="welcome.action" method="post">
     <s:select  name="destination" key="destination"  label="Destination"
       list="#{'1':'Vijayanagar','2':'Malleshwaram','3':'Rajajinagar','4':'Indranagar' }"
       />
       <s:select  name="departuretime" key="departuretime"  label="DepartureTime"
        list="#{'1':'5.00pm', '2':'6.00pm', '3':'7.00pm', '4':'8.00pm'}"  
      />
   <s:submit method="execute" align="center" />
</s:form>
</body>
</html>-->

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome!Please Select Destination and Time</title>
</head>
<s:a href="register">Register For Carpooling</s:a>
<s:a href="feedback">Suggestions/Complaints</s:a>
<s:a href="View_All_Registered_users">ViewAllRegisteredUsers</s:a>
<body>
    <h2>Welcome To CarPooling</h2>
    
    <s:form action="welcome" method="post" namespace="/">
 
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