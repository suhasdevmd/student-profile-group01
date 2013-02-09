<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>
	<%-- <p>
		<s:url id="testUrlId" namespace="/" action="logout">
		</s:url>
		<s:a errorText="Sorry your request had an error." href="%{testUrlId}">
		Logout
		</s:a>
	</p> --%>

	<img alt="photo" src="images/student.jpg">
	<br/><a href="ViewProfile.action">Profile</a> | <a href="logout.action">Logout</a>
	<h5>Name: <s:property value="%{#session.userName}" /> </h5>
	<s:if test="%{#session.role == 'student'}">
	<h5>Roll No : <s:property value="%{#session.rollNumber}"/></h5>
	</s:if>
	<s:else><h5>Faculty/Admin</h5></s:else>

</body>
</html>