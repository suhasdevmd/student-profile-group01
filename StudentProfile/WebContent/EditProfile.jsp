

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>

<sx:head />




<title>Edit Profile</title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />

<style type="text/css">
.body {
	align: right;
	background-color: pink;
	border: 4px solid blue;
	float: right;
	width: 150%;
	height: 150px;
	overflow-y: scroll;
	text-align: left;
	color: #000fff;
	margin-top: 10px;
}
</style>

</head>



<s:form action="EditProfileInDB.action" method="post"
	enctype="multipart/form-data">


	<body>
		<br>
		<br>
		<br>
		<br>



		<table align="center">
			<tr>
				<td><table>
						<tr class="success">
							<td></td>
							<td><s:property value="rollNo" /></td>

						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>


						<tr>
							<td><s:label theme="simple">FirstName*</s:label></td>
							<td><s:textfield name="FName" placeholder="Enter First Name" />
							</td>
						</tr>
						<tr>
							<td><s:label theme="simple">MiddleName</s:label></td>
							<td><s:textfield name="MName"
									placeholder="Enter Middle Name" theme="simple" /></td>
						</tr>
						<tr>
							<td><s:label theme="simple">LastName*</s:label></td>
							<td><s:textfield name="LName" placeholder="Enter Last Name"
									theme="simple" /></td>
						</tr>
						<tr>
							<td><s:label theme="simple">Secret Question</s:label></td>
							<td><s:textfield name="secretQuestion" placeholder="Enter Secret Question"
									theme="simple" /></td>
						</tr>
						<tr>
							<td><s:label theme="simple">Secret answer</s:label></td>
							<td><s:textfield name="secretAnswer" placeholder="Enter Secret Answer"
									theme="simple" /></td>
						</tr>
						<tr class="success">

							<sx:datetimepicker name="DOB" displayFormat="dd-MMM-yyyy"
								label="Date of Birth*" value="DOB" />
						</tr>

						<tr class="success">
							<td><s:label theme="simple">Upload Image</s:label></td>
							<td>
								<%-- <s:file name="userImage"
									placeholder="" label="User Image"
									theme="simple" /> --%> <s:file name="userImage"
									label="User Image" placeholder="image"/>
							</td>
						</tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr></tr>
						<tr>
							<td></td>
							<td><s:submit value="Update" name="UpdateProfile" /></td>
						</tr>
					</table> <br></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><s:label theme="simple">Interests</s:label>
					<div class="body">

						<s:checkboxlist list="interests" label="Interest List"
							name="selectedInterestList" theme="vertical-checkbox"
							value="defaultSelected"></s:checkboxlist>

					</div></td>
			</tr>
		</table>



		<s:if test="hasActionMessages()">
			<div class="welcome">
				<s:actionmessage />
			</div>
		</s:if>
</s:form>


</body>
</html>