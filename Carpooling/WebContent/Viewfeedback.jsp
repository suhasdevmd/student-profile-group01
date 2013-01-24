<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Pooling</title>
</head>
<body>
<h1>User Feedback</h1>
<s:form>
<table>
<tr> 
    <th><h4>Employee ID</h4></th>
    <th><h4>Feedback</h4></th>   
         
</tr>
<s:iterator value="feedbacklist">                              
<tr>
   <td><h4><s:property  value="Employee_id"/></h4></td>
   <td><h4><s:property value="feedback"/></h4></td>
   

</tr>
</s:iterator>

</table>

</s:form>
</body>
</html>