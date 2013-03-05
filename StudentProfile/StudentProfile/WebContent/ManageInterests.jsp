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
	<table border="1">
		<tr>
			<td>
				<div id="Interests">
					<form name="interests" action="manageInterests">
						<s:label>Interest :</s:label>
						<s:hidden name="type" value="interest" />
						<s:textfield name="interest" id="value" label="Category :"
							labelposition="left" />
						<s:submit name="addInterest" id="addInterest" value="Add" />
					</form>
				</div></td>
			<td>
				<div id="SubCat">
					<form name="subCat" action="manageInterests">
						<s:label>Subcategory :</s:label>
						<s:hidden name="type" value="subcat" />
						<s:select label="Select Category" list="interestCategories"
							name="selectedInterest" labelposition="left"/>
						<s:textfield name="subcat" id="value" label="Sub Category :"
							labelposition="left" />
						<s:submit name="addSubCat" id="addSubCat" value="Add"/>
					</form>
				</div></td>
		</tr>
	</table>
	<br />
	<br />
	<hr />
	<form name="displayInterests" action="manageInterests" >
	<!-- 
		<table border="1">
			<tr>
				<th><h3>Entity</h3></th>
				<th><h3>Attribute</h3></th>
				<th><h3>Value</h3></th>
				<th><h3>Status</h3></th>
				<th><h3>Edit</h3></th>
				<th><h3>Toggle Status</h3></th>
			</tr>

			<s:iterator value="interestsList">
				<tr>
					<td><s:property value="entity" /></td>
					<td><s:property value="attribute" />
					</td>
					<td><s:property value="value" /></td>
					<td><s:property value="status" /></td>
					<td>Edit</td>
					<td>Toggle</td>
				</tr>
			</s:iterator>
		</table>
		 -->
		 <display:table id="interestsList" name="interestsList"
			requestURI="/manageInterests.action" pagesize="3" >
			<display:column property="entity" title="Entity" />
			<display:column property="attribute" title="Attribute"/>
			<display:column property="value" title="Value"/>
			<display:column property="status" title="Status"/>
			<display:column>
				<s:url action="manageInterests.action" var="urlTag" escapeAmp="false" encode="true">
					<s:param name="interestID">${interestsList.interestID}</s:param>
					<s:param name="type">edit</s:param>
				</s:url>
				<a href="<s:property value="#urlTag" />">Update Details</a>
			</display:column>
			<display:column>
				<s:url action="manageInterests.action" var="urlTag" escapeAmp="false">
					<s:param name="interestID">${interestsList.interestID}</s:param>
					<s:param name="isValid">true</s:param>
					<s:param name="type">toggle</s:param>
				</s:url>
				<a  href="<s:property value="#urlTag" />">toggle</a>
			</display:column>
			<display:setProperty name="paging.banner.placement" value="bottom" />
			<display:setProperty name="paging.banner.item_name" value="Interest" />
			<display:setProperty name="paging.banner.items_name" value="Interests" />
			<display:setProperty name="basic.show.header" value="true" />
		</display:table>
	</form >
	<br />

</body>
</html>