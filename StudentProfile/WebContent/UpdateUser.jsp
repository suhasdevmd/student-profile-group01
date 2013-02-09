<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sd" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<sd:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Update User</title>
<link rel="stylesheet" href="style.css">


</head>
<body>
	<br />

	<s:form action="UpdateUser.action" method="post">

		<s:if test="hasActionErrors()">
			<div class="error">
				<s:actionerror />
			</div>
		</s:if>

		<br />

		<s:label name="PERSONAL INFORMATION" />
		<table>
			<s:hidden value="userID" />

			<tr>
				<td><s:label name="firstName" value="First Name"></s:label></td>
				<td><s:textfield name="firstName" label="FIRST NAME"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="middleName" value="Middle Name"></s:label></td>
				<td><s:textfield name="middleName" label="MIDDLE NAME"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="lastName" value="Last Name"></s:label></td>
				<td><s:textfield name="lastName" label="LAST NAME"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="dateOfBirth" value="Date of birth"></s:label>
				</td>
				<td><sd:datetimepicker name="dateOfBirth"
						displayFormat="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td><s:label name="gender" value="Gender"></s:label></td>
				<td><s:textfield name="gender" label="GENDER" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label name="permanentAddress" value="Permanent Address"></s:label>
				</td>
				<td><s:textfield name="permanentAddress"
						label="PERMANENT ADDRESS" required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="photograph" value="Photograph"></s:label></td>
				<td><s:textfield name="photograph" label="PHOTOGRAPH"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="rollNumber" value="Roll Number"></s:label></td>
				<td><s:textfield name="rollNumber" label="ROLL NUMBER"
						required="true" /></td>
			</tr>
		</table>

		<s:label name="LOGIN DETAILS" />
		<table>
			<tr>
				<td><s:label name="userName" value="User Name"></s:label></td>
				<td><s:textfield name="userName" label="USERNAME"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="password" value="Password"></s:label></td>
				<td><s:textfield name="password" label="PASSWORD"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="secretQuestion" value="Secret Question"></s:label>
				</td>
				<td><s:textfield name="secretQuestion" label="SECRET QUESTION"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="secretAnswer" value="Secret Answer"></s:label>
				</td>
				<td><s:textfield name="secretAnswer" label="SECRET ANSWER"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="role" value="Role"></s:label></td>
				<td><s:select label="ROLE NAME" headerKey="Select role"
						headerValue="Select role" list="{'admin', 'student', 'faculty'}"
						name="role" /></td>
			</tr>
		</table>
		<h2 align="right">
			<s:submit value=" Update User " style="margin-right:40px" />
		</h2>

	</s:form>

</body>
</html>