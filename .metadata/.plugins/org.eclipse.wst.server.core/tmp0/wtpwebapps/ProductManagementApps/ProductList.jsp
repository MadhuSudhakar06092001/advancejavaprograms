<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import= "com.Sathya.Servlet.*" import="java.util.Base64"%>
<!DOCTYPE html>
<html>
<head>

<title>Product List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body >
	<h1 class="text-success mb=1">list of available products</h1>
	<div>
		<a class="btn btn-success" href="AddProduct.html">add product</a>
	
	</div>
	<c:if test="${result==1}">
	<p class="text-center text-success">product inserted successful</p>
	</c:if>
	
	<div>
	</div>
	<c:if test="${val==1}">
	<p class="text-center text-success">Products after deletion successful</p>
	</c:if>
	
	<div>
		<input type="text" placeholder="search product">
	</div>
	<table class="table table-bordered table-striped">
		<thead class="thead-dark">
			<tr>
				<th> Product Id</th>
				<th> Product Name</th>
				<th> Product Price </th>
				<th>Product brand</th>
				<th>Made in</th>
				<th> manufacturing date</th>
				<th> expiry date</th>
				<th> image</th>
				<th>action</th>
			</tr>
		</thead>
			<tbody>
			<c:forEach var="product" items="<%=new ProductDao().findAll() %>">
				<tr>
				  	<td>${product.proid} </td>
					<td>${product.proName}</td>
					<td> ${product.proPrice}</td>
					<td>${product.proBrand}</td>
					<td>${product.proMadeIn}</td>
					<td>${product.proMfgDate}</td>
					<td>${product.proExpDate}</td>
					<td>
					<img src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.productImage) }" 
					alt="product Image" style="max-width:100px; max-height:100px;">
					</td>
					<td><a class="btn btn-success" href="DeleteProduct?proid=${product.proid}">delete</a>
						<a class="btn btn-success" href="EditServlet?proid=${product.proid}">Edit</a>
					</td>
				</tr>
				</c:forEach>
		</tbody>
			
			</table>
			</body>
			</html>
			
			