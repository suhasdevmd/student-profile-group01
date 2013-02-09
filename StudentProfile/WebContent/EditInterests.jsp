<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<head>
<title>Struts 2 - Manage Interests</title>
</head>
<body>
	<h2>Struts 2 - Manage Interests</h2>
	<s:actionerror />

	<form name="editInterests" action="editInterests">
		<s:iterator value="interestsList">
			<s:hidden name="interestID" />
			<s:textfield name="entity" />
			<s:textfield name="attribute" />
			<s:textfield name="value" />
			<s:textarea name="page" />
			<s:submit name="editInterest" value="Save" method="saveChanges" />
		</s:iterator>
	</form>
	<br />

</body>
</html>