<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>

	<h4 align="center">News and Announcements</h4>
</body>
<marquee  scrollAmount=2 width="300" height="100" direction="up">
<s:if test="%{#newsList != 'null'}">
	<table>
		<s:iterator value="#session.newsList">
			<tr>
				<td><s:property value="newsTitle" /> :</td>
				<td><s:property value="newsContent" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<s:else>
    	No data to display
	</s:else>
</marquee>

</html>