<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<h1 align="center">Student Profile Project</h1>

	<s:url var="Grades" action="headergrades.action">
		<s:param name="function" value="'Grades'"></s:param>
	</s:url>
	<s:a href="%{#Grades}">Grades</s:a>

</body>
</html>