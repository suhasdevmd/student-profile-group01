<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Enrollment</title>
</head>
<body>

	<s:form action="updateEnroll" method="POST">

		<table>

			<s:hidden name="ruleID"></s:hidden>

			<tr>
				<%-- <td><s:label name="newsAuthor" value="  Author Name :"></s:label>
					</td> --%>
				<td><s:textfield name="semester" label="Semester "
						id="semester" readonly="true">
					</s:textfield></td>
			</tr>
			<tr>
				<%-- <td><s:label name="newsContent" value="  Content :"></s:label>
					</td> --%>
				<td><s:textfield name="dueDate" label="Due Date"
						id="dueDate">
					</s:textfield></td>
			</tr>
		</table>
		<br />

		<s:submit name="UpdateRules" id="UpdateRules" value="Update Rules"
			align="left">
		</s:submit>


	</s:form>


</body>
</html>