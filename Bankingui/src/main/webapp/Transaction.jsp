<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer page</title>
</head>
<style>
body {
background-image: linear-gradient(to left,black ,#ebccff);
-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
text-align:center;
}


.text{
width:250px;
height:300px;
padding:20px 30px;
background-color:#F0F8FF;
border-radius:20px;
box-shadow:0 0 10px 0 #000;
margin:auto;
position:absolute;
top:20%;
bottom:40%;
left:10%;
right:20%;
text-align:left;
}

.message{
color:green;
font-size:20px;
font-weight:bold;

}
.error{
color:red;
font-size:20px;
font-weight:bold;
}


</style>
<%@ include file="CustomerMenu.jsp"%>
<body >

<div class="error">
<% 
if(session.getAttribute("user")==null)
 {
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
  }

%>
</div>

<div style="font-size:30px;font-weight:bold;text-align:left;top:50%;">

<p >User Transaction:</p><br>
</div>
<div class="run" style="text-align:left;font-size:25px;">
welcome
<%=session.getAttribute("user") %>,
</div>
<br>
<br>
<form action="AccountServlet?operation=transaction" method="post">
<br><br>


<div class="text" style="align:left">
<table >

<tr><td><p style="text-align:left;font-size:20px;">From Account:</p></td><td>
 <select style="width:70%;" name="accId">
<%
String name=(String) session.getAttribute("user");
BankLogic logic=new BankLogic();int id=0;
Map<Integer,CustomerInformation> custom=logic.selectCustomer(name);
for(Map.Entry<Integer,CustomerInformation> customer:custom.entrySet())
{
	id=customer.getKey();
}


int accId=0;
Map<Integer,Map<Integer,AccountInformation>> map1=logic.CustomerAccounts(id);
Map<Integer,AccountInformation> accMap=null;
for(Map.Entry<Integer,Map<Integer,AccountInformation>> mapp:map1.entrySet())
{
	id=mapp.getKey();
    accMap=mapp.getValue();
	for(Map.Entry<Integer,AccountInformation>  account:accMap.entrySet())
	{
		accId=account.getKey();
	}
}
%>
 <option value="<%=accId%>"><%=accId%> </option>
</select>
 </td></tr>
<tr><td><p style="text-align:left;font-size:20px;">To Account:</p></td><td>


  <select style="width:70%;" name="AccId1" >
<%
BankLogic logic1=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap1=logic1.selectAccount();
//request.setAttribute("accountMap",accountMap);
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc:accountMap1.entrySet())
{    
	int acc1=acc.getKey();
	if(id!=acc1){
	Map<Integer,AccountInformation> map=acc.getValue();
	for(Map.Entry<Integer,AccountInformation> accountMap:map.entrySet())
	{ int accountId=accountMap.getKey();
	%>
	
 <option value="<%= accountId%>"><%= accountId%> </option>
<%}
}
}%>
</select>



</td></tr>
<tr><td><p style="text-align:left;font-size:20px;">Amount:</p></td><td>
<input type="number" name="balance" Style="width:70%;" required="required"></td></tr>

<tr><td><input type="submit" name="Amount" value="AmountTransaction" style="width:100%;"></td></tr>

</table>
<br>
<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error in customer transaction");
}%>
</div>
<div class="message">
<%String  message=(String)request.getAttribute("message");
 if(message!=null)
 {
	 out.println("Amount Transfered Successfully");
 }

%>
</div>



</div>
</form>
</body>
</html>
