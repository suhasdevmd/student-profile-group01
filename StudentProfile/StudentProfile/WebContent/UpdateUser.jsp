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

		<table>
			<s:hidden name="userID" />
			<s:hidden name="rollNumber" />
			<s:hidden name="password" />
			<tr>
				<td><s:label value="PERSONAL INFORMATION" cssStyle="color:red" />
				</td>
			</tr>
			<tr>
				<td><s:label name="firstName" value="First Name"></s:label>
				</td>
				<td><s:textfield name="firstName" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label name="middleName" value="Middle Name"></s:label>
				</td>
				<td><s:textfield name="middleName" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label name="lastName" value="Last Name"></s:label>
				</td>
				<td><s:textfield name="lastName" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label name="dateOfBirth" value="Date of birth"></s:label>
				</td>
				<td><sd:datetimepicker name="dateOfBirth"
						displayFormat="dd-MMM-yyyy" value="dateOfBirth"/>
				</td>
			</tr>
			<tr>
				<td><s:label name="gender" value="Gender"></s:label>
				</td>
				<td><s:textfield name="gender" required="true" /></td>
			</tr>
			<tr>
				<td><s:label name="permanentAddress" value="Permanent Address"></s:label>
				</td>
				<td><s:textfield name="permanentAddress" required="true" />
				</td>
			</tr>
			
			<tr>
				<td><s:label value="LOGIN DETAILS" cssStyle="color:red" />
				</td>
			</tr>


			<tr>
				<td><s:label value="User Name"></s:label>
				</td>
				<td><s:textfield name="userName" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label value="Secret Question"></s:label></td>
				<td><s:textfield name="secretQuestion" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label value="Secret Answer"></s:label></td>
				<td><s:textfield name="secretAnswer" required="true" />
				</td>
			</tr>
			<tr>
				<td><s:label value="Role"></s:label>
				</td>
				<td><s:select id="roleName" headerKey="Select role"
						headerValue="Select role"
						list="#{'student':'student', 'faculty':'faculty'}" name="role"
						onchange="checkRole();" />
				</td>
			</tr>
			<tr>
				<td><s:label value="Roll Number"></s:label>
				</td>
				<td><s:textfield id="rollNumber" name="rollNumber"
						disabled="true" required="false" />
				</td>
			</tr>
			<tr>
				<td><br />
				</td>
			</tr>
			<tr>
				<td></td>
				<td><s:submit value=" Update User " style="margin-right:40px" />
				</td>
			</tr>
		</table>




	</s:form>

</body>
</html>