<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Home Page</title>
</head>
<body>
	<br />
	<h2 align="left">
		Welcome
		<s:property value="username" />
		!
	</h2>
	<s:actionmessage />
	<br />
	<h3 align="center">Admin Console</h3>

	<table border="1" align="center">
		<tr></tr>
		<tr>
			<td><s:url var="AdminHome" action="admin_home.action">
					<s:param name="function" value="'AddUpdateDeleteUser'"></s:param>
				</s:url> <s:a href="%{#AdminHome}">User Management</s:a></td>
			<td></td>
			<td><s:a href="managenews.action">News Management</s:a>
			</td>
			<td></td>
			<td><s:url var="ManageFaculty" action="managefaculty.action">
					<s:param name="function" value="'manageFaculty'"></s:param>
				</s:url> <s:a href="%{#ManageFaculty}">Faculty Management</s:a>
			</td>
			<td></td>
		</tr>
		<tr></tr>
		<tr>
			<td><s:a href="manageInterests.action">Announcements Management</s:a>
			</td>
			<td></td>
			<td><s:url var="add" action="addEnroll.action">
					<s:param name="addEnroll" value="'add'"></s:param>
				</s:url> <s:a href="%{#add}">Enrollment Rules Setup</s:a></td>
				<td></td>
			<td><s:a href="assignGrades.action">Grade Assignment</s:a>
			</td>
			<td></td>
		</tr>
		<tr></tr>
	</table>
	<p></p>
	<br />
	<br />
	<br />

</body>
</html>