<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="container d-flex flex-column align-items-center justify-content-center">
			<h1>What is your question?</h1>
			<div class="newQuestionForm">
				<form action="/questions/new" method="post">
					<div>
						<label class="align-top" for="question">Question: </label>
						<textarea name="question" cols="30" rows="3"></textarea>
						<p class="text-danger"><c:out value="${errorQuestion}"/></p>
					</div>
					<div>
						<label for="tags">Tags: </label>
						<input type="text" name="tags"/>
						<p class="text-danger"><c:out value="${errorTags}"/></p>
						<p class="text-danger"><c:out value="${errorTags2}"/></p>
					</div>
					<div class="d-flex justify-content-end">
						<button class="btn btn-warning">Submit</button>
					</div>
				</form>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>