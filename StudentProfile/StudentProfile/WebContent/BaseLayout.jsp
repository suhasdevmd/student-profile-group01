<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:insertAttribute name="title" ignore="true" />
</title>
<link rel="stylesheet" type="text/css" media="all" href="style.css" />
<meta name="keywords"
	content="glossy box, web design, colorful background, free templates, website templates, CSS, HTML" />
<meta name="description"
	content="Glossy Box | free website template with a colorful background" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<link href="css/jquery.ennui.contentslider.css" rel="stylesheet"
	type="text/css" media="screen,projection" />
<script>
	history.forward();
</script>
</head>
<body id="home">



	<div id="templatemo_wrapper_outer">
		<div id="templatemo_wrapper">
			<div class="cleaner_h20"></div>


			<s:if test="%{#session.login == 'true'}">

				<div id="header">
					<tiles:insertAttribute name="header" />
				</div>




				<div id="templatemo_content_wrapper">
					<div id="wrap">


						<div id="sidebar">
							<tiles:insertAttribute name="menu" />
						</div>

						<div id="content">
							<tiles:insertAttribute name="body" />
						</div>

					</div>


					<div class="cleaner_h10"></div>

					<div id="footer" style="margin-left: 10px;">
						<tiles:insertAttribute name="footer" />
					</div>

					<div id="footer1" style="margin-right: 10px;">
						<tiles:insertAttribute name="footer1" />
					</div>
				</div>

			</s:if>
			<s:else>
				<div id="content">
					<tiles:insertAttribute name="body" />
				</div>
			</s:else>



			<div id="templatemo_footer">

				Copyright © 2013 <a href="#">Team Blitzrahl</a>

			</div>


		</div>
	</div>

</body>
</html>