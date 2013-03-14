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
				<s:textfield labelposition="left" label="semester" id="semester" name="semester" required="true" />
			</tr>
			<tr>
				<td><s:label name="duedate" value="Due Date"></s:label>
				</td>
				<td><sd:datetimepicker name="duedate"
						displayFormat="dd-MM-yyyy" value="%{'today'}" /></td>
			</tr>
		</table>

	<s:submit name="AddEnroll" value="Add Enroll" ></s:submit>

	</s:form>

</body>
</html>