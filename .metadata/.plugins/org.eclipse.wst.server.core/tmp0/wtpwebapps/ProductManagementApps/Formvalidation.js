function validateForm(){
	var proid=document.getElementById('productId').value
	var proName=document.getElementById('productName').value
	var proPrice=document.getElementById('productPrice').value
	var proMadeIn=document.getElementById('productMadeIn').value
	var proBrand=document.getElementById('productBrand').value
	var proMfgDate=document.getElementById('productMfgDate').value
	var proExpDate=document.getElementById('productExpDate').value
	if(proid.trim()===""||proName.trim()===""||proPrice.trim()===""||proBrand.trim()===""){
	alert("all fields must be filled out")
	return false
	}
	if(proName.length>50 ||proBrand.length>50)
	{
		alert("length must be less than 50")
		return false
	}
	if(parseFloat( proPrice)<0){
		alert("value of price must be positive");
	return false
	}
	

	return true
}