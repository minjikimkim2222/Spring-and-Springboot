<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>login page</title>
	</head>
	<body>
		Welcome to the login page!
		
		<pre>${error}</pre>
		<form method = "post">
			Name : <input type = "text" name = "name"> <br>
			Password : <input type = "password" name = "password"> <br> 
			<input type = "submit" value = "submit">
		</form>
		
	</body>
</html>
