
let res="";
let operation="";
let count=0;
function show(number)
{
	
	console.log(number);
	if (document.getElementById("result").value !== '') {
	if(number== '+')
	{	
	document.getElementById("star").style.backgroundColor="#964F7F";
	document.getElementById("slash").style.backgroundColor="#964F7F";
	document.getElementById("minus").style.backgroundColor="#964F7F";
	res+=document.getElementById("result").value;
	document.getElementById("plus").style.backgroundColor="#D6286B";
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("plus").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" || operation.charAt(operation.length-2)=="/" || operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="%"  || operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" ")
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
	document.getElementById("star").style.backgroundColor="#964F7F";
	document.getElementById("slash").style.backgroundColor="#964F7F";
	document.getElementById("plus").style.backgroundColor="#964F7F";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("minus").style.backgroundColor="red";
		res+=" -";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" ||operation.charAt(operation.length-2)=="/" ||operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="%"  ||operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" "){
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
	document.getElementById("plus").style.backgroundColor="#964F7F";
	document.getElementById("slash").style.backgroundColor="#964F7F";
	document.getElementById("minus").style.backgroundColor="#964F7F";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("star").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" || operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" " ||  operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="%"  ||operation.charAt(operation.length-2)=="/" ||operation.charAt(operation.length-2)=="+"){
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
	//division
	else if(number=='/')
	{
	document.getElementById("star").style.backgroundColor="#964F7F";
	document.getElementById("plus").style.backgroundColor="#964F7F";
	document.getElementById("minus").style.backgroundColor="#964F7F";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("slash").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" ||operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" " || operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="%" || operation.charAt(operation.length-2)=="/"){
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
	else if(number=='%')
	{
	document.getElementById("star").style.backgroundColor="#964F7F";
	document.getElementById("plus").style.backgroundColor="#964F7F";
	document.getElementById("minus").style.backgroundColor="#964F7F";
	document.getElementById("slash").style.backgroundColor="#964F7F";
	res+=document.getElementById("result").value;
	operation=res;
	if(operation.charAt(operation.length-1)=="-")
	{
		document.getElementById("mod").style.backgroundColor="red";
		res=operation.substring(0,operation.length-2)
	}
	else if(operation.charAt(operation.length-2)=="*" ||operation.charAt(operation.length-2)=="-" && operation.charAt(operation.length-1)==" " ||operation.charAt(operation.length-2)=="+" || operation.charAt(operation.length-2)=="/"){
	res=operation.substring(0, operation.length-3);
	document.getElementById("mod").style.backgroundColor="red";
	res+=" % ";
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	else
	{
	document.getElementById("mod").style.backgroundColor="red";
	res+=" % "	;
	document.getElementById("resultdisplay").value=res;
	document.getElementById("result").value="";
	}
	}
		
	else if(number=='(')
	{
	res+=document.getElementById("result").value;
	res=res+" ( ";
    document.getElementById("result").value="";
	document.getElementById("resultdisplay").value=res;
	}
	else if(number==')')
	{  
	res+=document.getElementById("result").value;
	res=res+" ) ";
    document.getElementById("result").value="";
	document.getElementById("resultdisplay").value=res;
	}
  }
	else
	{
	if ((number >= '0' && number <= '9') || number === '-') {
	inputCheck(number);
		
	document.getElementById("result").value+=number;
	var num="";
	var dis= document.getElementById("result").value;
	dis=dis.replaceAll(",","");
	num=commaSeparator(dis);
    document.getElementById("result").value=num;
	document.getElementById("resultdisplay").value+=number;}
	}
}

function backward(){

	operation = document.getElementById("resultdisplay").value;  
	document.getElementById("result").value=document.getElementById("result").value.slice(0,-1);   

	 }
function clearScreen()
	{
	 
	 
	document.getElementById("result").value= "0"; 
	document.getElementById("resultdisplay").value="0";  
	document.getElementById("resultdisplay").value=document.getElementById("resultdisplay").value.slice(0,-1); 
	res="";  
	} 
	
function inputCheck(number)
{
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
		
}

function equal()
{
	document.getElementById("plus").style.backgroundColor="#D6286B";
	document.getElementById("star").style.backgroundColor="#D6286B";
	document.getElementById("slash").style.backgroundColor="#D6286B";
	document.getElementById("minus").style.backgroundColor="#D6286B";
	document.getElementById("mod").style.backgroundColor="#D6286B"
  	var output=0;
	res+=document.getElementById("result").value;
	document.getElementById("resultdisplay").value=res;
	output=bodmasRule(res);
	res="";
	document.getElementById("result").value=commaSeparator(output);
}

 
    function bodmasRule(expression)
    {
	    let expression1=expression.replaceAll(",","");
        
        let array= expression1.split('');
    
        let values = [];
        let openCount=0;
        let closeCount=0;
        let ops = [];
        
  
        for (let i = 0; i < array.length; i++)
        {
           
            if (array[i] == ' ')
            {
                continue;
            }
  
            if (array[i] >= '0' && array[i] <= '9' ||array[i]<=0 || array[i] =='.')
            {
                let sbuf = "";
                  
            
                while (i < array.length &&
                        array[i] >= '0' &&
                            array[i] <= '9' ||array[i]<=0 || array[i] =='.')
                {
                    sbuf = sbuf + array[i++];
                }
                values.push(parseFloat(sbuf));
                  i--;
            }
  
            else if (array[i] == '(')
            {
	         
            openCount++;
			var operators = ['+', '-', '*', '/', '%', '√', '3√', '^'];
			var ele = array[i - 2] === ' ' ? array[i - 3] : array[i - 2];
			if (!operators.includes(ele)) {
				ops.push("*");
			}
			ops.push('(');
            }
  
       
            else if (array[i] == ')')
            {
	            closeCount++;
                while (ops[ops.length - 1] != '(')
                {
                  values.push(applyOperator(ops.pop(),
                                   values.pop(),
                                  values.pop()));
                }
                ops.pop();
            }
  
         
            else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/' || array[i] == '%' || array[i] == '.')
            {
                  
              while (ops.length > 0 &&
                         hasPrecedence(array[i],
                                     ops[ops.length - 1]))
                {
                  values.push(applyOperator(ops.pop(),
                                   values.pop(),
                                 values.pop()));
                }
  
               
                ops.push(array[i]);
            }
        }
  
   
        while (ops.length > 0)
        {
		if (ops[ops.length - 1] == '√') {
				values.push(applyOperator(ops.pop(),
					values.pop(),
					""));
			}
			else {
				var localOp = ops.pop();
				if (localOp === '(') {
					localOp = ops.pop();
				}
				values.push(applyOperator(localOp,
					values.pop(),
					values.pop()));
           
        }
      if(openCount==closeCount)
       {
        return (values.pop());
       }
      else{
	     return "Syntax Error";
        }
  }}
  
    function hasPrecedence(op1, op2)
    {
        if (op1 == '(' || op2 == ')')
        {
            return false;
        }
        if ((op1 == '*' || op1 == '/') &&
               (op2 == '+' || op2 == '-') && (op1=='%' || op2=='.'))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
  
    function applyOperator(op, b, a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
            {
                return 0;
            }
            return parseInt(a / b, 10);
        case '%':
            return a % b;
    
        }
        return 0;
    }


function commaSeparator(answer){
	console.log("the commaseparator is "+ answer);
 var str = answer.toString().split(".");
	var length=str[0].length;
 var ch=str[0].charAt(length-1);
	str[0]=str[0].substring(0, str[0].length-1);
    str[0] = str[0].replace(/\B(?=(\d{2})+(?!\d))/g, ",");
	str[0]=str[0]+ch;
    return str.join(".");
	
}	

	