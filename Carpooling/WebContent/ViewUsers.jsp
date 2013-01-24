<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Pooling</title>
</head>
<body>
<h1>Registered Users</h1>
<s:form action="Confirm">
<table>
<tr> 
    <th><h4>Employee ID</h4></th>
    <th><h4>Name</h4></th>   
    <th><h4>Contact Number</h4></th>
    <th><h4>Email</h4></th>
    <th><h4>Car Name</h4></th> 
    <th><h4>Car NUmber</h4></th> 
    <th><h4>Capacity</h4></th>
    <th><h4>Destination</h4></th>
    <th><h4>Departure Time</h4></th>
    <th><h4>Weekday</h4></th>         
</tr>
<s:iterator value="userlist">                              
<tr>
   <td><h4><s:property  value="EmpId"/></h4></td>
   <td><h4><s:property value="EmpName"/></h4></td>
   <td><h4><s:property value="Telephone"/></h4></td>
   <td><h4><s:property value="EmailId"/></h4></td>
   <td><h4><s:property value="Carname"/></h4></td>
   <td><h4><s:property value="CarNo"/></h4></td>
    <td><h4><s:property value="capacity"/></h4></td>
     <td><h4><s:property value="destination"/></h4></td>
      <td><h4><s:property value="departuretime"/></h4></td>
 
  <td><h3>  <s:select  name="weekday" headerKey="-1" headerValue="Select Weekday"
        list="weekdaylist" ></s:select></h3></td>

</tr>
</s:iterator>

</table>
<h4><s:submit name="Inform"  value="Inform" /></h4>
</s:form>
</body>
</html>