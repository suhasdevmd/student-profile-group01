<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Car Pooling Website</title>
</head>
<body>

<font: italic 25px Georgia, "Times New Roman", Times, serif; color="#000000">
<b>

JOIN CAR POOL
</b>
</font:>
<br><br>
<s:form action="login.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>