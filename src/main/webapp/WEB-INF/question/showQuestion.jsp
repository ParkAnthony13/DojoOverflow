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
		<div class="container">
			<div>
				<h1><c:out value="${question.question}"/></h1>
				<p>
					<span>Tags: </span>
					<c:forEach items="${question.tags}" var="tag">
						<span style="border: 2px solid black; margin: 2px; padding: 2px;"><c:out value="${tag.subject}"/></span>
					</c:forEach>
				</p>
			</div>
			<div class="d-flex justify-content-between">
				<div class="left">
					<table class=table>
						<thead>
							<tr>
								<td>Answers</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${question.answers}" var="answer">
							<tr>
								<td>
									<c:out value="${answer.answer}"/>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="right">
					<h3>Add your answer:</h3>
					<form action="/questions/${question.id}" method="post">
						<label>Answer:</label>
						<input type="text" name="answer" />
						<p style="color:red;"><c:out value="${error}"/></p>
						<div class="d-flex justify-content-end">
							<button class="btn btn-warning">Answer it!</button>
						</div>
					</form>
					</div>
				</div>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>