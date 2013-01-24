<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Modify Form CarPooling</title>
</head>
 
<body>
<h2>Modify your Car here for Carpooling</h2>
 
<s:form action="modify.action" method="post">
	
    <s:textfield name="telephone" key="telephone" size="20" />
    <s:select label="Destination" 
		headerKey="-1" headerValue="Select Destination"
		list="DestinationList" 
		name="yourdestination" 
		value="defaultdestination" />
	
	<s:select label="DepartureTime" 
		headerKey="-1" headerValue="Select DepartureTime" 
		list ="DepartureList"
		name="yourDepartureTime" 
		value="defaultdeparturetime" />
	
		
  <s:textfield name="carname" key="carname" size="20" />
   <s:textfield name="carnumber" key="carnumber" size="20" />
   <s:select label="capacity" 
		headerKey="-1" headerValue="Select Capacity" 
		list ="CapacityList"
		name="yourCapacity"
		value="defaultCapacity" />
   
  
  <s:submit name="modify" method="execute" value="modify" label="modify" align="center" /> 
 
</s:form>


</body>
</html>