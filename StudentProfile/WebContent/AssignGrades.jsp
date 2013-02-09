<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<title>Struts 2 - Assign Grades</title>
</head>
<body>
	<h2>Struts 2 - Assign Grades</h2>
	<s:actionerror />
	<table border="1">
		<tr>
			<td>
				<div id="searchStudent">
					<form name="searchStudent" action="assignGrades">
						<s:label>Search :</s:label>
						<s:hidden name="type" value="search" />
						<s:textfield name="rollNumber" id="rollNumber" label="Roll Number"
							labelposition="left" />
						<s:submit name="searchStudent" id="searchStudent" value="Search" />
					</form>
				</div>
			</td>
			<s:if test="gradeValues!=null">
				<td>
					<div id="updateGrade">
						<form name="updateGrade" action="assignGrades">
							<s:hidden name="enrollmentID" />
							<s:hidden name="type" value="update"/>
							<s:label>Update Grade for EnrollmentID= <s:property value="enrollmentID"/>  </s:label>
							<s:select list="gradeValues" name="newGrade" id="newGrade" label="Select Grade" labelposition="left" />
							<s:submit name="updateGrade" id="updateGrade" value="Save" />
						</form>
					</div>
				</td>
			</s:if>
		</tr>
	</table>
	<br />
	<br />
	<hr />
	<form name="displayEnrollment" action="assignGrades">
		<display:table id="gradesList" name="gradesList"
			requestURI="/assignGrades.action" pagesize="3">
			<display:column property="enrollmentID" title="Enrollment #	" />
			<display:column property="rollNumber" title="Rollnumber" />
			<display:column property="studentName" title="Student Name" />
			<display:column property="subjectCode" title="Subject Code" />
			<display:column property="subjectName" title="Subject Name" />
			<display:column property="grade" title="Existing Grade" />
			<display:column title="Update">
				<s:url action="assignGrades.action" var="urlTag" escapeAmp="false">
					<s:param name="enrollmentID">${gradesList.enrollmentID}</s:param>
					<s:param name="type">edit</s:param>
				</s:url>
				<a href="<s:property value="#urlTag" />">Update Details</a>
			</display:column>
			<display:setProperty name="paging.banner.placement" value="bottom" />
			<display:setProperty name="paging.banner.item_name"
				value="Enrollment" />
			<display:setProperty name="paging.banner.items_name"
				value="Enrollments" />
			<display:setProperty name="basic.show.header" value="true" />
		</display:table>
	</form>
	<br />

</body>
</html>