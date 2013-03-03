<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Announcements</title>
</head>
<body>
	<h4 align="center">Announcements</h4>
</body>
<marquee  scrollAmount=2 width="300" height="60" direction="up" onmouseover="this.stop();" onmouseout="this.start();">
<s:if test="%{#session.InterestsList != null}">
	<table>
		<s:iterator value="#session.InterestsList">
			<tr>
				<td><ul><li><a href="manageInterests.action?entityID=<s:property value="interestID"/>"><s:property value="value" /></a></li></ul></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
</marquee>
<s:else>
    	No data to display
	</s:else>


</html>