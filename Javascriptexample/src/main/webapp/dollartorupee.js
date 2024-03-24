/**
 * 
 */
function dollartorupee(){
	let dollar=parseInt(document.getElementById("dollar").value)
	let rupee=dollar*82
	document.getElementById("rupee").value=rupee
	
	
}
function rupeetodollar(){
	let rupee=	parseInt(document.getElementById("rupee").value)
	let dollar=rupee/82;
	document.getElementById("dollar").value=dollar
}
function reversefuction(){
	let val=document.getElementById("original").value
	let rev=""
	for(let i=0;i<val.length;i++){
	rev=val[i]+rev
	}
	document.getElementById("reverse").value=rev
}
