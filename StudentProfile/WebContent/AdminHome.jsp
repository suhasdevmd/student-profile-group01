<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Administrator</title>
</head>
<body>
			<br />
			<s:label value="Administration"></s:label>
			<br />
				<s:url var="AddUpdateDeleteUser" action="admin_home">
				<s:param name="function" value="'AddUpdateDeleteUser'"></s:param>
				</s:url>
				<s:a href="%{#AddUpdateDeleteUser}">Add/Update/Delete User</s:a>
			
</body>
</html>