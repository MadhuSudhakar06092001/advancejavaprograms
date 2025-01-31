<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.Sathya.Servlet.Product" import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="Formvalidation.js" ></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-5 text-center">
		<h2 class="text-center font-italic mb-1">save product data</h2>
		<form method="post" action="./UpadateServlet" enctype="multipart/form-data" onsubmit="return validateForm()">
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proid">product Id</label>
				<input type="text" class="form-control-sm" id="productId" name="productId" value="${product.proid}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proname">product Name</label>
				<input type="text" class="form-control-sm" id="productName" name="productName" value="${product.proName}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proprice">product Price</label>
				<input type="number" class="form-control-sm" id="productPrice" name="productPrice" value="${product.proPrice}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proname">product Brand</label>
				<input type="text" class="form-control-sm" id="productBrand" name="productBrand" value="${product.proBrand}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proid">product MadeIn</label>
				<input type="text" class="form-control-sm" id="productMadeIn" name="productMadeIn" value="${product.proMadeIn}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proid">product MfgDate</label>
				<input type="date" class="form-control-sm" id="productMfgDate" name="productMfgDate" value="${product.proMfgDate}" required/>
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proid">product ExpDate</label>
				<input type="date" class="form-control-sm" id="productExpDate" name="productExpDate" value="${product.proExpDate}" required/>
			</div>
			<div class="form-group">
				<img alt="existing image" src="data:image/jpeg;base64,${Base64.getEncoder().encodeToString(product.productImage) }">
			
			
			</div>
			<div class="form-group">
				<label class="font-italic font-weight-bold" for="proid">product Image</label>
				<input type="file" class="form-control-file" id="productImage" name="productImage" value="${product.productImage}" accept="image/*" required/>
			</div>
			<div >
				<input type="submit" class="btn btn-success" value="save Product"/>
				<a href="ProductList.jsp" class="btn btn-primary">list of products</a>
			</div>
			
		</form>
	</div>
</body>
</html>