let res = "";
let operation = "";
let count = 0;
function show(number) {
	if(document.getElementById("result").value==='0')
	{
		document.getElementById("result").value='';
	}
	console.log(number);
	if (document.getElementById("result").value !== '' && !(number>='0' && number<='9') || number=='3√' || number=='√' || number=='π' ) {
		if (number == '+') {
			document.getElementById("star").style.backgroundColor = "#5E071F";
			document.getElementById("slash").style.backgroundColor = "#5E071F";
			document.getElementById("minus").style.backgroundColor = "#5E071F";
			res += document.getElementById("result").value;
			document.getElementById("plus").style.backgroundColor = "#241475";
			operation = res;

			if (operation.charAt(operation.length - 1) == "-") {
				document.getElementById("minus").style.backgroundColor = "#5E071F";
				res = operation.substring(0, operation.length - 2)
			}
			else if (operation.charAt(operation.length - 2) == "*" || operation.charAt(operation.length - 2) == "/" || operation.charAt(operation.length - 2) == "+" ||
				operation.charAt(operation.length - 2) == "%" || operation.charAt(operation.length - 2) == "-" && operation.charAt(operation.length - 1) == " ") {
				res = operation.substring(0, operation.length - 3);
				console.log("the res is in substring " + res);
				res += " + ";
				document.getElementById("resultdisplay").value = res;
			}

			else {
				res += " + ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
		}

		else if (number == '-') {
			document.getElementById("resultdisplay").value = res;
			document.getElementById("star").style.backgroundColor = "#5E071F";
			document.getElementById("slash").style.backgroundColor = "#5E071F";
			document.getElementById("plus").style.backgroundColor = "#5E071F";
			res += document.getElementById("result").value;
			operation = res;
			if (operation.charAt(operation.length - 1) == "-") {
				document.getElementById("minus").style.backgroundColor = "#241475";
				res = operation.substring(0, operation.length - 2)
			}
			else if (operation.charAt(operation.length - 2) == "*" || operation.charAt(operation.length - 2) == "/" || operation.charAt(operation.length - 2) == "+" ||
				operation.charAt(operation.length - 2) == "%" || operation.charAt(operation.length - 2) == "-" && operation.charAt(operation.length - 1) == " ") {
				document.getElementById("minus").style.backgroundColor = "#241475";
				res += document.getElementById("result").value;
				document.getElementById("resultdisplay").value = " -";
				document.getElementById("resultdisplay").value = res + " -";
			}

			else {
				document.getElementById("minus").style.backgroundColor = "#241475";
				res += " - ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
		}


		else if (number == '*') {
			document.getElementById("resultdisplay").value = res;
			document.getElementById("plus").style.backgroundColor = "#5E071F";
			document.getElementById("slash").style.backgroundColor = "#5E071F";
			document.getElementById("minus").style.backgroundColor = "#5E071F";
			res += document.getElementById("result").value;
			operation = res;
			if (operation.charAt(operation.length - 1) == "-") {
				document.getElementById("star").style.backgroundColor = "#241475";
				res = operation.substring(0, operation.length - 2)
			}
			else if (operation.charAt(operation.length - 2) == "*" || operation.charAt(operation.length - 2) == "-" && operation.charAt(operation.length - 1) == " " ||
				operation.charAt(operation.length - 2) == "%" || operation.charAt(operation.length - 2) == "/" || operation.charAt(operation.length - 2) == "+") {
				res = operation.substring(0, operation.length - 3);
				document.getElementById("star").style.backgroundColor = "#241475";
				res += " * ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}


			else {

				document.getElementById("star").style.backgroundColor = "#241475";
				res += " * ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
		}

		else if (number == '/') {
			document.getElementById("star").style.backgroundColor = "#5E071F";
			document.getElementById("plus").style.backgroundColor = "#5E071F";
			document.getElementById("minus").style.backgroundColor = "#5E071F";
			res += document.getElementById("result").value;
			operation = res;
			if (operation.charAt(operation.length - 1) == "-") {
				document.getElementById("slash").style.backgroundColor = "#066E63";
				res = operation.substring(0, operation.length - 2)
			}
			else if (operation.charAt(operation.length - 2) == "*" || operation.charAt(operation.length - 2) == "-" && operation.charAt(operation.length - 1) == " " ||
				operation.charAt(operation.length - 2) == "+" || operation.charAt(operation.length - 2) == "%" || operation.charAt(operation.length - 2) == "/") {
				res = operation.substring(0, operation.length - 3);
				document.getElementById("slash").style.backgroundColor = "#241475";
				res += " / ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
			if (operation.charAt(1) == "/") {
				res = "";
			}
			else {
				document.getElementById("slash").style.backgroundColor = "#241475";
				res += " / ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
		}
		else if (number == '%') {
			document.getElementById("star").style.backgroundColor = "#5E071F";
			document.getElementById("plus").style.backgroundColor = "#5E071F";
			document.getElementById("minus").style.backgroundColor = "#5E071F";
			document.getElementById("slash").style.backgroundColor = "#5E071F";
			res += document.getElementById("result").value;
			operation = res;

			if (operation.charAt(operation.length - 1) == "-") {
				document.getElementById("mod").style.backgroundColor = "#241475";
				res = operation.substring(0, operation.length - 2)
			}
			else if (operation.charAt(operation.length - 2) == "*" || operation.charAt(operation.length - 2) == "-" && operation.charAt(operation.length - 1) == " "
				|| operation.charAt(operation.length - 2) == "+" || operation.charAt(operation.length - 2) == "%" || operation.charAt(operation.length - 2) == "/") {
				res = operation.substring(0, operation.length - 3);
				document.getElementById("mod").style.backgroundColor = "#241475";
				res += " % ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
			
			else {
				document.getElementById("mod").style.backgroundColor = "#241475";
				res += " % ";
				document.getElementById("resultdisplay").value = res;
				document.getElementById("result").value = "";
			}
		}

		else if (number == '(') {
			res += document.getElementById("result").value;
			res = res + " ( ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}
		else if (number == ')') {
			res += document.getElementById("result").value;
			res = res + " ) ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}
		else if (number == '√') {
			res += document.getElementById("result").value;
			res = res + " √ ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}
		else if (number == '3√') {
			res += document.getElementById("result").value;
			res = res + " 3√ ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}
		else if (number == '^') {
			res += document.getElementById("result").value;
			res = res + " ^ ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}

		else if (number == 'π') {
			res += document.getElementById("result").value;
			res = res + " π ";
			document.getElementById("result").value = "";
			document.getElementById("resultdisplay").value = res;
		}
	}
	else {
		if ((number >= '0' || number <= '9') || number === '-' || number==='(' || number=='.'|| number=='π') {
			if(number==='-')
			{
				number=' '+number;
			}
			inputCheck(number);
			document.getElementById("result").value += number;
			var num = "";
			var dis = document.getElementById("result").value;
			dis.replaceAll(",", "");
			num = commaSeparator(dis);
			document.getElementById("result").value = num;
			document.getElementById("resultdisplay").value += number;
		}
	}
}

function backward() {

	operation = document.getElementById("resultdisplay").value;
	document.getElementById("result").value = document.getElementById("result").value.slice(0, -1);
        document.getElementById("resultdisplay").value = document.getElementById("resultdisplay").value.slice(0, -1);
}
function clearScreen() {
	
	document.getElementById("result").value = "";
	document.getElementById("resultdisplay").value = "";
	res = "";
	document.getElementById("star").style.backgroundColor = "black";
	document.getElementById("plus").style.backgroundColor = "black";
	document.getElementById("minus").style.backgroundColor = "black";
	document.getElementById("slash").style.backgroundColor = "black";
	document.getElementById("equal").style.backgroundColor = "black";
}
function inputCheck(number) {
	if (number == ".") {
		count++;
	}

	if (number != '.') {
		count = 0;
	}
	if (count > 1) {
		number = number.substring(0, number.length - 1);
		num = num.substring(0, num.length - 1);
	}




}

function equal() {
	document.getElementById("plus").style.backgroundColor = "black";
	document.getElementById("star").style.backgroundColor = "black";
	document.getElementById("slash").style.backgroundColor = "black";
	document.getElementById("minus").style.backgroundColor = "black";
	document.getElementById("mod").style.backgroundColor = "black";
	document.getElementById("equal").style.backgroundColor = "#241475"
	var output = 0;
	res += document.getElementById("result").value;
	document.getElementById("resultdisplay").value = res;
	output = bodmasRule(res);
	res = "";
	document.getElementById("result").value = commaSeparator(output);
	document.getElementById("resultdisplay").value = commaSeparator(output);
}


function bodmasRule(expression) {

	let expression1 = expression.replaceAll(",", "");
	let array = expression1.split('');
	let values = [];
	let ops = [];
	let openCount = 0;
	let closeCount = 0;
	var signOp='';
	for (let i = 0; i < array.length; i++) {

		if (array[i] == ' ') {
			continue;
		}

		if (array[i] >= '0' && array[i] <= '9' || array[i] == '.' || array[i] <= 0) {
			let sbuf = "";


			while (i < array.length &&
				array[i] >= '0' &&
				array[i] <= '9' || array[i] == '.') {
				if(signOp!=='')
				{
					sbuf+=signOp;
					signOp='';
				}
				sbuf = sbuf + array[i++];
			}
			values.push(parseFloat(sbuf));
			i--;
		}

		else if (array[i] == '(') {
			openCount++;
			var operators = ['+', '-', '*', '/', '%', '√', '3√', '^','π'];
			var ele = array[i - 2] === ' ' ? array[i - 3] : array[i - 2];
			if (!operators.includes(ele) && i!=0) {
				ops.push("*");
			}
			ops.push('(');
		}


		else if (array[i] == ')')
		 {
			closeCount++;
			while (ops.length > 0 &&hasPrecedence(array[i],ops[ops.length - 1])) {

				if (ops[ops.length - 1] == '√'){
					values.push(applyOperator(ops.pop(),
						values.pop(),
						""));
				}
				else {
                             
					values.push(applyOperator(ops.pop(),
						values.pop(),
						values.pop()));
				}
				
			}
		}


		else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/' || array[i] == '%' || array[i] == '√'
			|| array[i] == '3√' || array[i] == '^' || array[i] == 'π' || array[i] == '.') {
			while (ops.length > 0 &&
				hasPrecedence(array[i],
					ops[ops.length - 1])) {

				if (ops[ops.length - 1] == '√') {
					values.push(applyOperator(ops.pop(),
						values.pop(),
						""));
				}
				
				else {

					values.push(applyOperator(ops.pop(),
						values.pop(),
						values.pop()));
				}
			}
			if(array[i+1]!==' ')
			{
				signOp=array[i];
			}
			else
			{
				ops.push(array[i]);
			}
		}

	}


	while (ops.length > 0) {
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
			if(localOp)
			{
			values.push(applyOperator(localOp,
				values.pop(),
				values.pop()));
			}
		}
	}
	if (openCount == closeCount) {
		return (values.pop());
	}
	else {
		return "Syntax Error";
	}
}

function hasPrecedence(op1, op2) {
	if (op2 == '(' || op2 == ')') {
		return false;
	}
	if ((op1 == '√' || op1 == '3√') && (op2 = '*' || op2 == '/' || op2 == '+' || op2 == '-')) {
		return false;
	}
	if ((op2 == '*' || op2 == '/') &&
		(op2 == '+' || op2 == '-') && (op2 == '%' || op2 == '√') && (op1 == '.' || op2 == '3√') && (op1 == '^' || op1 == 'π')) {
		return false;
	}
	else {
		return true;
	}
}

function applyOperator(op, b, a) {
	switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0) {
				return 0;
			}
			return (a / b);
		case '%':
			return a % b;
		case '√':
			return Math.sqrt(b);
		case '3√':
			return Math.cbrt(b);
		case '^':
			return Math.pow(a, b);
		case 'π':
			return Math.PI;
		case '(':
			return b;
	}
	return 0;
}

function commaSeparator(answer) {

	var str = answer.toString().split(".");
	var length = str[0].length;
	var ch = str[0].charAt(length - 1);
	str[0] = str[0].substring(0, str[0].length - 1);
	str[0] = str[0].replace(/\B(?=(\d{2})+(?!\d))/g, ",");
	str[0] = str[0] + ch;
	return str.join(".");

}


























/*var operators = ['+', '-', '*', '/', '%', '√', '3√', '^'];
				var ele = array[i + 2] === ' ' ? array[i + 3] : array[i + 2];
				if (!operators.includes(ele) && (array[i+2]<='0' || array[i+2]>='0')) {
					ops.push("*");
				}*/