<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp" %>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-light bg-light">
  <h4 class="navbar-brand">LIBRARY</h4>
  <div >
  <form action="redirectTolog" method="get" class="form-inline d-flex flex-row space-between">
    <h5>Hello, User</h5>
    <button class="btn btn-outline-success my-2 my-sm-0 ml-5" type="submit">Logout</button>
    </form>
  </div>
</nav>


	<div class="container mt-5 mb-5">
		<h2>Add Book</h2>
		<form method="post" action="handle-product">
		
			<div class="form-group">
				<label for="id">Book ID:</label>
				<input type="text" class="form-control" id="id" name="id" ></input>
			</div>
		
			<div class="form-group">
				<label for="username">Book Name:</label>
				<input type="text" class="form-control" id="name" name="name">
			</div>
			
			<c:forEach items="${authors }" var="author">
				<h1>${authors.author }</h1>			
			</c:forEach>
			
			<div class="form-group">
				<label for="password">Book Author:</label>
				<select class="form-control" id="author" name="author">
				  <option>author1</option>
				  <option>author2</option>
				  <option>author3</option>
				  <option>author4</option>
				  <option>author5</option> 
				</select>
			</div>
			
			<div class="form-group">
				<label for="date_added">Date Added:</label>
				<input type="text" class="form-control" id="date_added" name="date_added" value="<jsp:useBean id="now" class="java.util.Date" /><fmt:formatDate value="${now}" type="date" dateStyle="long" />" readonly="readonly"></input>
			</div>
			
			<a href="${pageContext.request.contextPath }/" type="submit" class="btn btn-primary">Back</a>
			<button type="submit" class="btn btn-secondary">Add</button>
		</form>
	</div>
	
	<footer class="bg-primary text-center text-white position-absolute container-fluid">
    <!-- Copyright -->
    <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
        © 2023 Copyright:
        <a class="text-white" href="https://mdbootstrap.com/">Diwakar sharma</a>
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>