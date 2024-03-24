/**
 * 
 */
function palindrome(){
	let name=document.getElementById("name").value
	let rev=""
	for(let i=0;i<name.length;i++){
		rev=name[i]+rev;
	}
	let val
	if(rev===name){
	val="yes"
	
	}
	else{
	val="no"
	}
	
	document.getElementById("ispalindrome").value=val
	
}