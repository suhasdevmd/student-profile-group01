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
		//alert(document.getElementById("rollNumber").disabled);
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

		
		<table>
			<tr>
			<td><s:label value="PERSONAL INFORMATION" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><s:label value="First Name"></s:label></td>
				<td><s:textfield name="firstName" 
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Middle Name"></s:label></td>
				<td><s:textfield name="middleName" 
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Last Name"></s:label></td>
				<td><s:textfield name="lastName" 
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Date of birth"></s:label>
				</td>
				<td><sd:datetimepicker name="dateOfBirth"
						displayFormat="dd-MM-yyyy" value="%{'today'}" /></td>
			</tr>
			<tr>
				<td><s:label value="Gender"></s:label></td>
				<td><s:select headerKey="Select gender"
						headerValue="Select gender" list="{'M', 'F'}" name="gender" /></td>
			</tr>
			<tr>
				<td><s:label value="Permanent Address"></s:label>
				</td>
				<td><s:textfield name="permanentAddress"
						 required="true" /></td>
			</tr>
			
			<tr>
			<td><s:label value="LOGIN DETAILS" cssStyle="color:red"/></td>
			</tr>
			
			
			<tr>
				<td><s:label value="User Name"></s:label></td>
				<td><s:textfield name="userName" 
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Secret Question"></s:label>
				</td>
				<td><s:textfield name="secretQuestion"
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Secret Answer"></s:label>
				</td>
				<td><s:textfield name="secretAnswer" 
						required="true" /></td>
			</tr>
			<tr>
				<td><s:label value="Role"></s:label></td>
				<td><s:select id="roleName"
						headerKey="Select role" headerValue="Select role"
						list="#{'student':'student', 'faculty':'faculty'}" name="role"
						onchange="checkRole();" /></td>
			</tr>
			<tr>
				<td><s:label value="Roll Number"></s:label></td>
				<td><s:textfield id="rollNumber" name="rollNumber"
						 disabled="true" required="false" /></td>
			</tr>
			<tr><td><br /></td></tr>
			<tr>
			<td></td>
			<td><s:submit value=" Add User " style="margin-right:40px" /></td>
			</tr>
		</table>
		
		
	</s:form>

</body>
</html>