
/*let apples=parseInt(prompt("enter the no of apples "))
let oranges=parseInt(prompt("enter the no of oranges "))


function process(apples,oranges){
	return "juicee preparing with "+cut(apples)+"apples peices"+cut(oranges)+"oranges"
}

function cut(fruit){
	return fruit*4
}

document.write(process(apples,oranges))*/

let apples=parseInt(prompt("enter the no of apples "))
let oranges=parseInt(prompt("enter the no of oranges "))

function process(){
	return `juicee preparing with ${apples}-apples and ${oranges}-oranges `
}	

document.write(process());	
	
	
	
	