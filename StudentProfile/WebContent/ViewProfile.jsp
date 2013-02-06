<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri ="/struts-tags"%>
<html>
<head>
<title>View Profile</title>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<s:actionerror />
	<s:form action="EditProfile.action" method="post">
		<table align="center">
			<tr class="success">
				<td></td>
				<td><s:property value="RollNo" /></td>

			</tr>
			<tr class="success">

				<td><s:label theme="simple">Name:  </s:label></td>
				<td></td>
				<td><s:property value="name" /></td>
			</tr>

			<tr class="success">

				<td><s:label theme="simple">DOB:  </s:label></td>
				<td></td>
				<td><s:property value="DOB" /></td>
			</tr>

			<tr class="success">

				<td><s:label theme="simple">Interests:  </s:label>
				<td></td>
				<td><s:select theme="simple" headerKey="-1"
						headerValue="--Interests--" id="interests" name="interests"
						list="interests" /></td>

			</tr>

		</table>

		<br>
		<table align="right">

			<s:submit value="Edit Profile" name="EditProfile" />


		</table>


	</s:form>
</body>
</html>