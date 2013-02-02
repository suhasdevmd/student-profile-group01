<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subjects</title>
</head>
<body>

	<%-- <s:select label="courses" name="courses" headerKey="-1"
		headerValue="Show Enrolled Courses/Show All"
		list="#{'01':'Enrolled Courses', '02':'Show All'}" value="selectedCourse"
		required="true" />
	 --%>


	<s:select label="courses" name="courses" headerKey="-1"
		headerValue="Show Enrolled Courses/Show All"
		list="#{'01':'Enrolled Courses', '02':'Show All'}"
		value="selectedCourse" required="true" />



	<s:if test="subject != null">

		<table border="1">
			<tr>
				<th>Subject Code</th>
				<th>Subject</th>
				<th>Faculty Name</th>
				<th>Semester</th>
				<th>Enrolled</th>
				<th>Grade</th>
			</tr>

			<s:iterator value="subject">
				<tr>
					<td align="center"><s:property value="subjectCode" />
					</td>
					<td align="center"><s:property value="subject" />
					</td>
					<td align="center"><s:property value="facultyName" />
					</td>
					<td align="center"><s:property value="semester" />
					</td>
					<td align="center"><s:property value="enrolStatus" />
					</td>
					<td align="center"><s:property value="grade" />
					</td>
				</tr>

				<tr>
					<td>
						<%-- <s:url id="subjct" namespace="/" action="logout">
							
						</s:url> <s:a errorText="Sorry your request had an error."
							href="%{subjct}">
						Logout
					</s:a> --%> <s:url var="Sub" action="syllabus">
							<s:param name="Subj" value="{subjectCode}"></s:param>
						</s:url> <s:a href="%{#Sub}"><s:property value="subjectCode"/></s:a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
	<s:else>
    	No data to display
	</s:else>


</body>
</html>