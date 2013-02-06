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
		$("#myform #gradesTable").show("slow");

		$("#myform #semester").change(function() {
			var sem = $("#myform #semester").val();

			var sub = document.myform.action + '?semPassedFromJS=' + sem;
			document.myform.action = sub;
			document.myform.submit();
		});
	});
</script>
<title>Grades</title>
</head>
<body>
	<s:actionerror />


	<s:form id="myform" action="grades.action" method="post">

		<s:select list="semesterList" name="semester" id="semester"
			headerKey="-1" headerValue="--Select Semester--"></s:select>

		<s:select list="subjectList" name="subject" id="subject"
			headerKey="-1" headerValue="--Select Subject--"></s:select>

		<s:submit value="Search" align="center" />

		<s:if test="gradesList != null">
			<table>
				<tr>
					<th>Subject</th>
					<th>Subject Code</th>
					<th>Grade</th>
					<th>Result</th>
				</tr>

				<s:iterator value="gradesList">
					<tr>
						<td><s:property value="subjectName" /></td>
						<td><s:property value="subjectCode" /></td>
						<td><s:property value="grade" /></td>
						<td><s:property value="result" /></td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
		<s:if test="aggregateList != null ">
			<h3>GPA Of Individual Semesters</h3>
			<table>
				<tr>
					<th>Semester</th>
					<th>GPA</th>
				</tr>
				<s:iterator value="aggregateList">
					<tr>
						<td><s:property value="semester" /></td>
						<td><s:property value="aggregate" /></td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="2">CGPA : <s:property value="cgpa"/> </td>
				</tr>
			</table>

		</s:if>
	</s:form>

</body>
</html>