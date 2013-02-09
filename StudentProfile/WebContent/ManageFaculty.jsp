<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Faculty</title>
</head>
<body>
<s:form action="managefaculty.action" method="POST">
	<table>
		<tr>
			<th>Title</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Subject</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<s:iterator value="facultyList">
			<tr>
				<td><s:property value="title" />
				</td>
				<td><s:property value="firstName" />
				</td>
				<td><s:property value="lastName" />
				</td>
				<td><s:property value="subjectName" />
				</td>
				<td> <a href="managefaculty?editID=<s:property value="facultyID"/>">Edit</a> 
				</td>
				<td> <a href="managefaculty?deleteID=<s:property value="facultyID"/>">Delete</a> 
				</td>
			</tr>
		</s:iterator>
	</table>
	<s:submit name="commandButton" value="Add Faculty" align="center" />
</s:form>	
</body>
</html>