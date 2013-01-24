<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seats Available</title>
</head>
<body>
<h1>Seats Available</h1>
<s:form action="showrequestpage.action" method="post">
<table>
<tr> 
    <th><h2>Destination</h2></th>
    <th><h2>DepartureTime</h2></th>   
    <th><h2>Owner</h2></th>
    <th><h2>Car</h2></th>
    <th><h2>CarNo</h2></th> 
    <th><h2>OwnerEmailId</h2></th>          
</tr>
<s:iterator value="seatlist" var="seat">                              
<tr>
   <td><h4><s:property  value="destination" /></h4></td>
   <td><h4><s:property  value="departuretime"/></h4></td>
   <td><h4><s:property value="owner"/></h4></td>
   <td><h4><s:property value="car"/></h4></td>
   <td><h4><s:property value="carno"/></h4></td>
   <td><h4><s:property value="ownermailid"/></h4></td>
<!--<td><h4><a href="bookseat?carno=<s:property value="carno"/>" >bookseat?</a></h4> </td>  -->
<td><h4><a href="bookseat?empId=<s:property value="employeeId"/>" >bookseat?</a></h4> </td>
</tr>
</s:iterator>
<s:submit name="placerequest" key="label.placerequest" align="centre" > </s:submit>
</table>
</s:form>
</body>
</html>



