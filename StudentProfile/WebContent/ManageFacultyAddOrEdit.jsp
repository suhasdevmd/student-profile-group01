<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set name="theme" value="'simple'" scope="page" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#myform #flag").hide();
		$("#myform #facultyID").hide();
		
		var flag = $("#myform #flag").val();
		//alert(flag); 
		if (flag == "EDIT") {
			$("#myform #nameList").hide();
			$("#myform #button").val("Save");
		} else{
			$("#myform #button").val("Assign Faculty");
			$("#myform #fname").hide();
			$("#myform #lname").hide();
			$("#myform #fnamelabel").hide();
		}
			
	});
</script>
<title>Manage Faculty</title>
</head>
<body>
	<s:form id="myform" action="addoreddit.action" method="POST">
		<s:textfield id="facultyID" name="facultyID"></s:textfield>
		<s:textfield id="flag" name="flag"></s:textfield>
		<s:label>Title :</s:label>
		<s:textfield name="title"></s:textfield>
		<br />
		<s:label id="fnamelabel">First Name :</s:label>
		<s:textfield id="fname" name="firstName" key="label.firstName"></s:textfield>
		<br />
		<%-- <s:label id="lname">Last Name :</s:label> --%>
		<s:textfield id="lname" name="lastName" key="label.lastName"></s:textfield>
		<br />
		<s:select id="nameList" list="nameList" name="userID" headerKey="-1" headerValue="--Select Name--"></s:select><br />
		<s:label>Gender :</s:label>
		<s:textfield name="gender"></s:textfield>
		<br />
		<s:label>Subject Name :</s:label>
		<s:select list="subjectList" name="subject" headerKey="-1" headerValue="--Select Subject--" value="subject"></s:select>
		<br />
		<s:if test=""></s:if>
		<s:submit id="button" name="commandButton" value="" align="center" />

	</s:form>
</body>
</html>