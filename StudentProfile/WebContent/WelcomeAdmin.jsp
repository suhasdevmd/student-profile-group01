<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Home Page</title>
</head>
<body>
	<h2 align="center">
		welcome ,
		<s:property value="username" />
		!
	</h2>
	<s:actionmessage />
	<h3 align="center">Student Profile Project</h3>
	<form action="">
		<s:submit value="view profile" name="viewprofile" action="ViewProfile" />
		
		<s:url var="AdminHome" action="admin_home.action">
			<s:param name="function" value="'AddUpdateDeleteUser'"></s:param>
		</s:url>
		<s:a href="%{#AdminHome}">Admin Home</s:a>
		
		<s:submit value="Manage News" name="managenews" action="managenews"/>

		<s:submit value="Manage Interests" name="manageInterests"
			action="manageInterests" />
		<s:url var="ManageFaculty" action="managefaculty.action">
			<s:param name="function" value="'manageFaculty'"></s:param>
		</s:url>
		<s:a href="%{#ManageFaculty}">ManageFaculty</s:a>
		<a href="enroll.action">Enroll</a>
		
		<s:url var="add" action="addEnroll.action">
			<s:param name="addEnroll" value="'add'"></s:param>
		</s:url>
		<s:a href="%{#add}">Add Enrollment Rules</s:a>
		
		<s:submit value="Assign Grades" name="assignGrades"
			action="assignGrades" />
		<!-- 
	<s:submit value="Friends" name="Friends" action="friends"/>
	<s:submit value="Subjects" name="Subjects" action="subject"/>
	<s:textfield id="rollNumber" name="rollNumber"  /> 
	<s:submit value="Search" name="Search" action="search"/>
	<s:submit value="Grades" name="Grades" action="headergrades"/>
	</form>
	-->
		<p></p>
		<br />
		<br />
		<br />
		<h2 align="center">Content goes here.</h2>
</body>
</html>