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
			<div class="questionList">
				<h1>Questions Dashboard</h1>
				<table class="table">
					<thead>
						<tr>
							<td>Questions</td>
							<td>Tags</td>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${questions}" var="question">
						<tr>
							<td><a href="/questions/${question.id}"><c:out value="${question.question}"/></a></td>
							<td>
								<c:forEach items="${question.tags}" var="tag">
									<c:out value="${tag.subject}"/>
								</c:forEach>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<div class="d-flex justify-content-end">
					<a href="/questions/new">New Question</a>
				</div>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>