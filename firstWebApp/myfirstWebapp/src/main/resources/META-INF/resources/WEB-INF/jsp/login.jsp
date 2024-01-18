<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">
		<title>login page</title>
	</head>
	<body>
		<div class = "container">
			<h1>Login</h1>
			
			<pre>${error}</pre>
			<form method = "post">
				Name : <input type = "text" name = "name"> <br>
				Password : <input type = "password" name = "password"> <br> 
				<input type = "submit" value = "submit">
			</form>
		
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		</div>
	</body>
</html>
