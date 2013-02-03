<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<script>
	$(document).ready(function() {
		$("#myform #sem1subject").hide();
		$("#myform #sem2subject").hide();
		$("#myform #sem3subject").hide();
		$("#myform #sem4subject").hide();

		$("#myform #sem").change(function() {
			if ($("#myform #sem").val() == 1) {
				$("#myform #sem1subject").show("slow");
				$("#myform #sem2subject").hide();
				$("#myform #sem3subject").hide();
				$("#myform #sem4subject").hide();

			} else if ($("#myform #sem").val() == 2) {
				$("#myform #sem1subject").hide();
				$("#myform #sem2subject").show("slow");
				$("#myform #sem3subject").hide();
				$("#myform #sem4subject").hide();
			} else if ($("#myform #sem").val() == 3) {
				$("#myform #sem1subject").hide();
				$("#myform #sem3subject").show("slow");
				$("#myform #sem2subject").hide();
				$("#myform #sem4subject").hide();
			} else if ($("#myform #sem").val() == 4) {
				$("#myform #sem1subject").hide();
				$("#myform #sem4subject").show("slow");
				$("#myform #sem2subject").hide();
				$("#myform #sem3subject").hide();
			}
		});

	});
</script>
<title>Grades</title>
</head>
<body>
	<s:actionerror />
	
	
	<s:form id="myform" action="grades.action" method="post">

		<s:select list="#{'1':'Sem 1', '2':'Sem 2', '3':'Sem 3', '4':'Sem 4'}"
			name="sem" id="sem" headerKey="-1" headerValue="Select Semester"></s:select>

		<s:select list="sem1subjectlist" name="sem1subject" id="sem1subject"
			headerKey="-1" headerValue="Select Subject"></s:select>

		<s:select list="sem2subjectlist" name="sem2subject" id="sem2subject"
			headerKey="-1" headerValue="Select Subject"></s:select>

		<s:select list="sem3subjectlist" name="sem3subject" id="sem3subject"
			headerKey="-1" headerValue="Select Subject"></s:select>

		<s:select list="sem4subjectlist" name="sem4subject" id="sem4subject"
			headerKey="-1" headerValue="Select Subject"></s:select>

		<s:submit value="Search" align="center" />

		<table>
			<tr>
				<th>Subject</th>
				<th>Subject Code</th>
				<th>Grade</th>
				<th>Result</th>
			</tr>

			<s:iterator value="gradesList">
				<tr>
					<td><s:property value="subjectName" />
					</td>
					<td><s:property value="subjectCode" />
					</td>
					<td><s:property value="grade" />
					</td>
					<td><s:property value="result" />
					</td>
				</tr>
			</s:iterator>
		</table>

	</s:form>

</body>
</html>