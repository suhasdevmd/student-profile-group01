<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Register Form CarPooling</title>
</head>
 
<body>
<h2>Register your Car here for Carpooling</h2>
 
<s:form action="registerSubmit.action" method="post" validate="true">
	<s:textfield name="id" key="employeeid" size="20" />
    <s:textfield name="name" key="name" size="20" />
    <s:textfield name="email" key="email" size="20" />
    <s:textfield name="telephone" key="telephone" size="20" />
    
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

<h4>
	<s:select label="Capacity" 
		headerKey="-1" headerValue="Select Capacity" 
		list ="CapacityList"
		name="capacity" 
		value="defaultcapacity" />
</h4>
 
    
  <s:textfield name="carname" key="carname" size="20" />
  <s:textfield name="carnumber" key="carnumber" size="20" />
  
    <s:submit  align="center" />
</s:form>
</body>
</html>