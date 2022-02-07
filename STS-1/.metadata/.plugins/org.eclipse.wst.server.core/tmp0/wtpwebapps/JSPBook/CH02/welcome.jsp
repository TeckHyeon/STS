<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylsheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<nav class="navbar navbar-expan navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href=" ./welcome.jsp">Home</a>
			</div>
		</div>
	</nav>
	<%!String greeting = "Welcome to Web Shopping Mall";
	String tagline = "Welcome to Web Market!";%>
	<div class="jumbotron">
		<div class="contaniner">
			<h1 class="display-3">
				<%=greeting%>
			</h1>
		</div>
	</div>
	<main role="main">
		<div class="container">
			<div class="text-center">
				<h3>
					<%=tagline%>
				</h3>
			</div>
			<hr>
		</div>
	</main>
	<footer class = "container">
		<p> &copy; WebMarket</p>
	</footer>
</body>
</html>