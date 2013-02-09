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
<title>Add User</title>
<script type="text/javascript" language="javascript">
	function validateForm() {
		var val = true;
		var a = document.forms["myForm"]["firstName"].value;
		var b = document.forms["myForm"]["lastName"].value;
		var c = document.forms["myForm"]["gender"].value;
		var d = document.forms["myForm"]["rollNumber"].value;
		var e = document.forms["myForm"]["userName"].value;
		var f = document.forms["myForm"]["role"].value;
		if (a == null || a == "" || b == null || b == "" || c == null
				|| c == "" || d == null || d == "" || e == null || e == ""
				|| f == null || f == "") {
			alert("All required fields must be filled out");
			val = false;
		}
		return val;
	}

	function checkRole() {
		var roleName = document.getElementById("roleName").value;
		if (roleName == "student") {
			document.getElementById("rollNumber").disabled = false;
		} else {
			document.getElementById("rollNumber").disabled = true;
		}
		alert(document.getElementById("rollNumber").disabled);
	}
</script>
<link rel="stylesheet" href="style.css">


</head>
<body>
	<br />
	<s:form name="myForm" action="addUser.action" method="post"
		onsubmit="return validateForm();">

		<s:if test="hasActionErrors()">
			<div class="error">
				<s:actionerror />
			</div>
		</s:if>

		<br />

		<s:label name="PERSONAL INFORMATION" />
		<table>
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
						displayFormat="dd-MM-yyyy" value="%{today}" /></td>
			</tr>
			<tr>
				<td><s:label name="gender" value="Gender"></s:label></td>
				<td><s:select label="GENDER" headerKey="Select gender"
						headerValue="Select gender" list="{'M', 'F'}" name="gender" /></td>
			</tr>
			<tr>
				<td><s:label name="permanentAddress" value="Permanent Address"></s:label>
				</td>
				<td><s:textfield name="permanentAddress"
						label="PERMANENT ADDRESS" required="true" /></td>
			</tr>
		</table>

		<s:label name="LOGIN DETAILS" />
		<table>
			<tr>
				<td><s:label name="userName" value="User Name"></s:label></td>
				<td><s:textfield name="userName" label="USERNAME"
						required="true" /></td>
			</tr>
			<!--  <tr>
				<td><s:label name="password" value="Password"></s:label></td>
				<td><s:textfield name="password" label="PASSWORD"
						required="true" /></td>
			</tr> -->
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
				<td><s:select id="roleName" label="ROLE NAME"
						headerKey="Select role" headerValue="Select role"
						list="#{'student':'student', 'faculty':'faculty'}" name="role"
						onchange="checkRole();" /></td>
			</tr>
			<tr>
				<td><s:label name="rollNumber" value="Roll Number"></s:label></td>
				<td><s:textfield id="rollNumber" name="rollNumber"
						label="ROLL NUMBER" disabled="true" required="false" /></td>
			</tr>
		</table>
		<h2 align="right">
			<s:submit value=" Add User " style="margin-right:40px" />
		</h2>

	</s:form>

</body>
</html>