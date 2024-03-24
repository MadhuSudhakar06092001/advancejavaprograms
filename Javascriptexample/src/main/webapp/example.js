/*let username="madhu"
alert(username)
console.log("hey madhu what are you doing")
document.write(`this is ${username} doing javascript`)*/
/*let Madhumass=parseInt(prompt("enter the madhu mass"))
let ratanmass=parseInt(prompt("enter the ratan mass"))
let madhuheight=parseFloat(prompt("enter the height of madhu in meters"))
let ratanheight=parseFloat(prompt("enter the height of ratan in meters"))
let madhubmi=( Madhumass/(madhuheight*madhuheight))
let ratanbmi=(ratanmass/(ratanheight*ratanheight))
let ismadhubmigreater=madhubmi>ratanbmi
if(ismadhubmigreater){
	console.log("madhubmigreater")
	
}
else {
	console.log("ratanbmigreater")
	}*/
	
	let dolphinscore=0
	let koalasscore=0
	let dophine=true
	let koalas=false
	for(let i=0;i<6;i++){
		if(dophine){
			dolphinscore+=parseInt(prompt("enter the score dolphin"));
			dophine=false;
			
		}
		else{
			koalasscore	+=parseInt(prompt("enter the score koalas"));
			dophine=true;
		
		}
	}
	let avgdol=dolphinscore/3.0
	let avgkoal=dolphinscore/3.0
	
	if(avgdol==avgkoal)
	document.write("dolphins  and koalas won the game with score "+avgdol)
	else if(avgdol>avgkoal)
	document.write("dolphins win the game"+ avgdol)
	else 
	document.write("koalas win the game"+ avgkoal)
	
	
	
	
