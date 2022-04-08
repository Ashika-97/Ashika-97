let res="";
let operation="";
let count=0;
let num="";
function show(number)
{
	
	if(document.getElementById("result").value==='0')
	{
		document.getElementById("result").value='';
	}
	console.log(number);
	if (document.getElementById("result").value !== '' && !(number >= '0' && number <= '9')) {
	
	
	
	if(number== '+')
	{	
	document.getElementById("star").style.backgroundColor="#114D82";
	document.getElementById("slash").style.backgroundColor="#114D82";
	document.getElementById("minus").style.backgroundColor="#114D82";
	res+=document.getElementById("result").value;
	document.getElementById("plus").style.backgroundColor="green";
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("plus").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" || operation.charAt(operation.length-2)=="/" || operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" ")
	{
	res=operation.substring(0, operation.length-3);
	console.log("the res is in substring "+res);
	res+=" + ";
	document.getElementById("resultdisplay").value=res;
	}
	else
	{
	res+=" + ";
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	}
	
	else if(number=='-')
	{
	document.getElementById("resultdisplay").value=res;
	document.getElementById("star").style.backgroundColor="#114D82";
	document.getElementById("slash").style.backgroundColor="#114D82";
	document.getElementById("plus").style.backgroundColor="#114D82";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("minus").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" ||operation.charAt(operation.length-2)=="/" ||operation.charAt(operation.length-2)=="+" ||operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" "){
	document.getElementById("minus").style.backgroundColor="red";
    res+=document.getElementById("result").value;
	document.getElementById("resultdisplay").value=" -";
	document.getElementById("resultdisplay").value=res+" -";
	}
	else{
	document.getElementById("minus").style.backgroundColor="red";
    res+=" - ";
    document.getElementById("resultdisplay").value=res;
    document.getElementById("result").value="";
	}
	}
	
	//multiplication
	else if(number=='*')
	{
	document.getElementById("resultdisplay").value=res;
	document.getElementById("plus").style.backgroundColor="#114D82";
	document.getElementById("slash").style.backgroundColor="#114D82";
	document.getElementById("minus").style.backgroundColor="#114D82";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("star").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" || operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" " ||operation.charAt(operation.length-2)=="/" ||operation.charAt(operation.length-2)=="+"){
    res=operation.substring(0, operation.length-3);
	document.getElementById("star").style.backgroundColor="red";
	res+=" * ";
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	else
	{
	document.getElementById("star").style.backgroundColor="red";
	res+=" * ";
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	}
	
	else if(number=='/')
	{
	document.getElementById("star").style.backgroundColor="#114D82";
	document.getElementById("plus").style.backgroundColor="#114D82";
	document.getElementById("minus").style.backgroundColor="#114D82";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("slash").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" ||operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" " ||operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="/"){
	res=operation.substring(0, operation.length-3);
	document.getElementById("slash").style.backgroundColor="red";
	res+=" / ";
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	else
	{
	document.getElementById("slash").style.backgroundColor="red";
	res+=" / "	;
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	}
}
    
	else
	{
	if((number >= '0' && number <= '9') || number === '-' || number === '.'  ){
          if(number==='-')
	   {
        	number=' '+number;
		}
	if (number == "." ) {
			count++;
		}
		
		if(number!='.')
		{
			count=0;
		}
		if (count > 1) {
			number = number.substring(0, number.length - 1);
			num = num.substring(0, num.length - 1);
		}
	document.getElementById("result").value+=number;
	
	var dis= document.getElementById("result").value;
	dis=dis.replaceAll(",","");
	num=commaSeparator(dis);
    document.getElementById("result").value=num;
	document.getElementById("resultdisplay").value+=number;
	}
	}
}
function backward() {

	operation = document.getElementById("resultdisplay").value;
	document.getElementById("result").value = document.getElementById("result").value.slice(0, -1);
        document.getElementById("resultdisplay").value = document.getElementById("resultdisplay").value.slice(0, -1);

}
function clearScreen()
	{
	 
	document.getElementById("result").value= ""; 
	document.getElementById("resultdisplay").value="";  
	res="";
	
	} 



function equal()
{
	document.getElementById("plus").style.backgroundColor="#114D82";
	document.getElementById("star").style.backgroundColor="#114D82";
	document.getElementById("slash").style.backgroundColor="#114D82";
	document.getElementById("minus").style.backgroundColor="#114D82";
	
  	var output=0;
	res+=document.getElementById("result").value;
	document.getElementById("resultdisplay").value=res;
	output=equate(res);
	res="";
	document.getElementById("result").value=commaSeparator(output);
}



function equate(values){	
	values=values.replaceAll(",","");
	let array = values.split(" ");
	array =  array.filter(e =>  e);
    for(var i=0;i<array.length;i+=2)
	{
        switch (array[i+1]) {
            case '+':
                array[i+2] = (1*array[i] +  1*array[i+2]);
                break;
            case '-':
                array[i+2] = (1*array[i] - 1*array[i+2]);
               break;
            case '/':
                array[i+2] = ((1*array[i]) /  (1*array[i+2]));
               break;
            case '*':
                array[i+2] = (1*array[i] * 1*array[i+2]);
                break;
          
            default:
   			{
			if(array[i+1]<0)
			{
 			array[i+1] = (1*array[i] + 1*array[i+1]);	
			}
            break;	
			}
      }
   	 if(i==array.length-1)
	 {
		return array[i];
	 }
	}
}


function commaSeparator(answer){
	
 var str = answer.toString().split(".");
	var length=str[0].length;
 var ch=str[0].charAt(length-1);
	str[0]=str[0].substring(0, str[0].length-1);
    str[0] = str[0].replace(/\B(?=(\d{2})+(?!\d))/g, ",");
	str[0]=str[0]+ch;
    return str.join(".");
	
}
