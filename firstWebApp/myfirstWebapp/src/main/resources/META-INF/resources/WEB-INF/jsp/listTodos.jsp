<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<link href = "webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel = "stylesheet">
		<title>List Todos Page</title>
	</head>
	<body>
		<div class = "container">
			<h1>Your Todos</h1>
	 		<table class = "table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Deadline</th>
						<th>is Done?</th>
						<th>delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items = "${todos}" var = "todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.deadline}</td>
							<td>${todo.done}</td>
							<td> <a href = "delete-todo?id=${todo.id}" class = "btn btn-warning">DELETE</a> <td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href = "add-todo" class = "btn btn-success">Add Todo</a>
			<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
			<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		</div>
	</body>
</html>