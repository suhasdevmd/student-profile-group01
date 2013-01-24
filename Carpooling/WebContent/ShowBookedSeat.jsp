<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CarPooling Website</title>
</head>
<body>

Hi you have booked your seat <s:property value="CarNo"/> <s:property value="Carname"/> belonging to  <s:property value="EmpName"/> EmployeeId <s:property value="EmpId"/> 
<s:property value="EmailId"/> on <s:property value="departuretime"/> to <s:property value="destination"/> <br /><br />
 Do you want to cancel your seat ? Please click here <a href="cancel?empId=<s:property value="employeeId"/>" >cancel?</a>
</body>
</html>