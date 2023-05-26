<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="d-flex flex-column min-vh-100 min-vw-100">
<form name = "redirectForm" action="redirectToLib" method="get" class="d-flex flex-grow-1 justify-content-center align-items-center">
<div class="container d-flex align-items-center justify-content-center d-flex flex-column">
<h1 class="text-center mb-10">Hello, ${credentials.username}</h1>
<button type="submit" class="btn btn-primary mt-10">Manage Books</button>
</div>
</form>
</div>
</body>
</html>

