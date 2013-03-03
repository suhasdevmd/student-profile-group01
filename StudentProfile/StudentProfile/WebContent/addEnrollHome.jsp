<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Enrollment Home</title>
</head>
<body>


	<s:form action="addEnroll" method="POST">


		<s:url var="add" action="addEnroll.action">
			<s:param name="addEnroll" value="'addnew'"></s:param>
		</s:url>
		<s:a href="%{#add}">Add Enrollment Rules</s:a>




		<table>
			<tr>
				<td>Subject</td>
				<td>Faculty</td>
				<td>DueDate</td>
				<td>Student Count</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>


			<s:iterator value="enrollList">
				<tr>
					<td><s:property value="subjectID"></s:property></td>
					<td><s:property value="facultyID"></s:property></td>
					<td><s:property value="dueDate"></s:property></td>
					<td><s:property value="studentCount"></s:property></td>
					<td><a
						href="updateEnroll.action?upd_id=<s:property value = "ruleID" />">Update</a>
					</td>
					<td><a
						href="updateEnroll.action?del_id=<s:property value = "ruleID" />">Delete</a>
					</td>
				</tr>
			</s:iterator>

		</table>


	</s:form>









</body>
</html>