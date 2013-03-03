<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EnrollmentPage</title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />

<style type="text/css">
.body {
	align: left;
	background-color: grey;
	border: 4px solid grey;
	float: left;
	width: auto;
	min-width:200px;
	height: 150px;
	overflow-y: scroll;
	text-align: left;
	color: black;
	margin-top: 10px;
}
</style>


<script>
	function handleChange(value) {
		window.location = "enroll?semester=" + value; //or you can submit a form from here or make an ajax call
	}
</script>
</head>

<body>

	<div style="margin: 20px;">

		<form action="postenrollment" method="post">
			
			<table align="center">
				<tr>
				<tr>
				<tr>
				<tr>

					<s:label theme="simple">Select Semester : </s:label>

					<s:select label="semester" theme="simple" name="semester"
						headerKey="-1" headerValue="Select semester"
						list="#{'01':'1', '02':'2' , '03':'3' , '04':'4'}"
						value="semester" onchange="handleChange(this.value)" />

					
					<td><s:label theme="simple">SubjectsList</s:label>
						<div class="body">

							<s:checkboxlist list="subjectlist" label="Subjects"
								name="subject" theme="vertical-checkbox" value="defaultSelected"></s:checkboxlist>

						</div></td>
				</tr>
			</table>



			<s:submit align="centre" label="Enroll" name="Enroll" value="Enroll"
				cssClass="button" />
		</form>

	</div>
</body>
</html>