<%@page import="java.util.ArrayList"%>
<%@page import="org.freeworld.logchanger.model.LogData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
<header>
   <nav>
         <input type="checkbox" id="css-toggle-menu" name="css-toggle-menu"> 
         <ul class="main">
				<!-- <li><a href="index.html"><img class="bottom" src="img/serverdekho.png"></a></li>  -->
				<li><a href="index.html">Home</a></li>
				<li><a href="memory.html">Memory</a></li>
				<li><a href="threads.html">Threads/Classes</a></li>
				<li><a href="cpumem.html">System</a></li>
				<li><a href="GetLoggerServlet">Log Level</a></li>
			</ul>
         <label for="css-toggle-menu" id="css-toggle-menu"></label> 
   </nav>
</header>
	<div class="container">

		<div class="container-fluid">
			<h1 align="center" style="color: white;">Log Level Tool</h1>
		</div>

		<div class="jumbotron">
			<div>
				<div class="panel-body">

					<form action="ChangeLoggerServlet" role="form">
						<div class="form-group">
							<table class="table table-condensed">
								<tbody>
									<td><select name="logger" class="form-control">
									<option selected="selected">Logger ---- Current log level</option>
											<%
											    final ArrayList logList = (ArrayList) request.getAttribute("loglist");
											    for (int i = 0; i < logList.size(); i += 1) {
											        LogData logdata = (LogData) logList.get(i);
											%>
											<option value="<%=logdata.getLogger()%>">
												<%=logdata.getLogger() + " - " + logdata.getLogLevel()%>
												<%
												    }
												%>
											
									</select></td>
									<td><select name="level" class="form-control">
									<option selected="selected">Log Level</option>
											<option value="ERROR">ERROR</option>
											<option value="INFO">INFO</option>
											<option value="DEBUG">DEBUG</option>
											<option value="TRACE">TRACE</option>
											<option value="WARN">WARN</option>
									</select></td>
									<td>
										<button type="submit" class="btn btn-primary btn-md">Submit</button>
									</td>
								</tbody>
							</table>

						</div>
					</form>
				</div>
			</div>
		</div>
		<h1 align="center" style="color: white;">OR</h1>

		<div class="jumbotron">

			<!-- FOR EDITABLE LOGGER -->

			<div>
				<div class="panel-body">

					<form action="ChangeLoggerServlet" role="form">
						<div class="form-group">
							<table class="table table-condensed">
								<tbody>
									<td><input type="text" class="form-control" name="logger"
										size="60"
										placeholder="Enter New Logger not present in the drop down above">
									</td>
									<td><select name="level" class="form-control">
											<option selected="selected">Log Level</option>
											<option value="ERROR">ERROR</option>
											<option value="INFO">INFO</option>
											<option value="DEBUG">DEBUG</option>
											<option value="TRACE">TRACE</option>
											<option value="WARN">WARN</option>
									</select></td>
									<td>
										<button type="submit" class="btn btn-primary btn-md">Submit</button>
									</td>
								</tbody>
							</table>

						</div>
					</form>
				</div>
			</div>
		</div>


	</div>
<link href="css/menu.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/google-apis-font.css" rel="stylesheet">
<link href="css/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">	
</body>
</html>