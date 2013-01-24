<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Place Request</title>
</head>
<body>
<h2>Place Request</h2>
<s:form action="placerequest.action" method="post" validate="true">
<%-- 	<s:label name="id"  label="Id"/> <s:property value="username"/> --%>
   <%--   ID :   <s:label name="id"/>             <s:property value="username"/>--%>
    <s:textfield name="id" key="id" label="Id" size="20" />
    <s:textfield name="name" key="name" label="Name" size="20" />
    <s:textfield name="email" key="email" label="Email" size="60" />
    <s:select  name="destination" key="destination"  label="Destination"
       list="DestinationList"
       />
    <s:select  name="departuretime" key="departuretime" label="DepartureTime"
        list="DepartureList"  
      />
   <s:submit name="send" key="label.send" align="center" />
</s:form>
</body>
</html>