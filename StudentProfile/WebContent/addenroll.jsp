<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Enrolment Rules</title>
</head>
<body>



	<s:form action="addEnroll" method="POST">

		<table>

			<tr>
				<s:select label="subject" id="subject" name="subject" headerKey="-1"
					headerValue="Select Subject" list="subjList"
					value="selectedSubject" required="true" />
			</tr>
			<tr>
				<s:select label="faculty" id="faculty" name="faculty" headerKey="-1"
					headerValue="Select Faculty"
					list="facList" value="selectedFaculty"
					required="true" />
			</tr>
			<tr>
				<td><s:label name="duedate" value="Due Date"></s:label>
				</td>
				<td><sd:datetimepicker name="duedate"
						displayFormat="dd-MM-yyyy" value="%{today}" /></td>
			</tr>

			<tr>
				<td><s:label name="StudentCount" value="Student Count"></s:label>
				</td>
				<td><s:textfield name="count" id="count"></s:textfield></td>
			</tr>


		</table>

	<s:submit name="Add Enroll" value="Add Enroll"></s:submit>

	</s:form>

</body>
</html>