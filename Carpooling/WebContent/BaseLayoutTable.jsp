<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<table >

		<tr>
			<td id="header" colspan="2"><tiles:insertAttribute name="header" />
			
		</tr>
		<tr>
			<td class="logo" colspan="2"><tiles:insertAttribute name="logo" />
			
		</tr>
		<tr>
			<td id="header2" colspan="2"><tiles:insertAttribute name="header2" />
		</tr>
		<tr>
			<td class="input"><tiles:insertAttribute name="info" /></td>
			<td class="content"><tiles:insertAttribute name="content" /></td>
		</tr>
		<tr>
			<td class="footer" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>


	</table>


</body>
</html>
