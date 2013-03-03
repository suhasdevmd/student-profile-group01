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
		if($("#myform #userName").val() == null || $("#myform #userName").val() == ""){
			$("#myform #Q").hide();
			$("#myform #A").hide();
		}
		$("#myform #userName").change(function(){
			$("#myform #Q").show("slow");
		});
		$("#myform #Q").change(function(){
			$("#myform #A").show("slow");
		});
	
	});
</script>
<title>Forgot Password</title>
</head>
<body>
	<s:form id="myform" action="forgotpassword.action" method="POST">
		<table>
			<%-- <tr>
				<td><s:label>Enter Rollnumber</s:label>
				</td>
				<td><s:textfield name="rollnum"></s:textfield>
				</td>
			</tr> --%>
			<tr>
				<td><s:label>Enter Username</s:label>
				</td>
				<td><s:textfield id="userName" name="userName"></s:textfield>
				</td>
			</tr>
			
			<tr id="Q">
				<td><s:label>Enter your Secret Question</s:label>
				</td>
				<td><s:textfield name="Question"></s:textfield>
				</td>
			</tr>
			
			<tr id="A">
				<td><s:label>Enter your Secret Answer</s:label>
				</td>
				<td><s:textfield name="Answer"></s:textfield>
				</td>
			</tr>
	
		</table>
		<s:submit value="Submit" align="center" />
	</s:form>
	<s:actionmessage/>
	<s:actionerror/>
</body>
</html>