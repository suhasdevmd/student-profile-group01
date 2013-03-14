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
		<table>
			<s:iterator value="interestsList" var="list">
				<tr>
					<td>Entity:</td>
					<td><s:hidden name="interestID" /> <s:if
							test="%{list.attribute == 'Subcategory'}">
							<s:textfield name="entity" />
						</s:if> <s:else>
							<s:hidden name="entity" />
							<s:text name="entity" />
						</s:else>
					</td>
				</tr>
				<tr>
					<td>Attribute:</td>
					<td>
					<s:hidden name="attribute" />
					<s:text name="attribute" />
					</td>
				</tr>
				<tr>
					<td>Value:</td>
					<td><s:textfield name="value" />
					</td>
				</tr>
				<tr>
					<td>Page:</td>
					<td><s:textarea name="page" cols="40" rows="10"/>
					</td>
				</tr>
				<tr>
					<td><s:submit name="editInterest" value="Save"
							method="saveChanges" />
					</td>
				</tr>
			</s:iterator>
		</table>
	</form>
	<br />

</body>
</html>