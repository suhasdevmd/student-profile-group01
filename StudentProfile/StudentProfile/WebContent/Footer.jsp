<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<body>

	<h4 align="center">News</h4>
</body>
<marquee  scrollAmount=2 width="300" height="60" direction="up" onmouseover="this.stop();" onmouseout="this.start();">
<s:if test="%{#session.newsList != null}">
	<table>
		<s:iterator value="#session.newsList">
			<tr>
				<td><b><s:property value="newsTitle" /> :</b></td>
				<td><s:property value="newsContent" /></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
</marquee>
<s:else>
    	No data to display
	</s:else>
</marquee>

</html>