<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logging Tool</title>
</head>
<style type="text/css">
body {
	background: black !important;
}
	/* Adding !important forces the browser to overwrite the default style applied by Bootstrap */
.table-bordered td {
	border: 0px solid #7C2513 !important;
	background-color: black !important;
	color: white !important;
}
</style>
<body>
	<div class="container">
		<%
				String message = (String) request.getAttribute("message");
		%>
		<div class="container-fluid"></div>
		<h3 align="center" style="color: white;">
			<%=message %>
		</h3>
		
		<br>
		<br>
		<a href="GetLoggerServlet">Go Back</a>
	</div>
	<link href="css/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
</body>
</html>