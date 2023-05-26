<html>
<head>
<%@include file="./base.jsp" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div class="container mt-3 mb-5">
	<div class="row>">
		<div class="col-md-12">
			<h1 class="text-center mb-3">Books Listing</h1>
		<div class="tableHeading d-flex flex-row float-right">
			<a href="add-product" type="submit" class="btn btn-primary float-end pull-right">Add New Book</a>
		</div>
			
				<table class="table">
				  <thead class="thead-light">
				    <tr>
				      <th scope="col">Book Code</th>
				      <th scope="col">Book Name</th>
				      <th scope="col">Author</th>
				      <th scope="col">Date Added</th>
				      <th scope="col">Actions</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  <c:forEach items="${products }" var="p">
				    <tr>
				      <td>${p.id }</td>
				      <td>${p.name }</td>
				      <td>${p.author }</td>
				      <td>${p.date_added }</td>
				      <td>
				      		<a href="update/${p.id }" type="submit" class="btn btn-outline-success">Update</a>
				      		<a href="delete/${p.id }" type="submit" class="btn btn-outline-danger">Delete</a>
				      </td>
				    </tr>		
				   </c:forEach>		    

				  </tbody>
				</table> 
		</div>
	</div>
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
