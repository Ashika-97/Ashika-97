<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction In Account</title>
</head>
<style>

body {
background-image: linear-gradient(to left,#ebccff ,black);

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
text-align:center;
}

.contain{
width:250px;
height:auto;
padding:20px 30px;
background-color:#e0e0eb;
border-radius:20px;
box-shadow:0 0 10px 0 #000;
margin:auto;
position:absolute;
top:20%;
bottom:30%;
left:10%;
right:20%;}
.test{
text-align:left;
left:10%;
right:20%;
color:#090302;
text-indent:40px;

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
<body>
<%@ include file="Menu.jsp" %>

<div class="error">
<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

%>
</div>

<br>

<br>

<form action="AccountServlet?operation=transfer"  method="post">
<div class="run" style="text-align:left;font-size:25px;">
welcome
<%=session.getAttribute("user") %>,
</div>

<div class="contain">
<p Style="text-align:center;font-size:30px;color:#000066;font-weight:bold;">Account Transaction:</p>

<p Style="text-align:left;font-size:20px;"> From AccountNumber:</p>

  <select  style="width:70%;" name="accId">
<%
BankLogic logic=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap=logic.selectAccount();
//request.setAttribute("accountMap",accountMap);
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc:accountMap.entrySet())
{    
	int acc1=acc.getKey();
	Map<Integer,AccountInformation> map=acc.getValue();
	for(Map.Entry<Integer,AccountInformation> accMap:map.entrySet())
	{ int accountId=accMap.getKey();
	%>

  <option value="<%= accountId%>"><%= accountId%> </option>
<%}
}
%>
</select>
<br>
<p Style="text-align:left;font-size:20px;">To AccountNumber:</p>

  <select  style="width:70%;" name="AccId1">
<%
BankLogic logic1=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap1=logic1.selectAccount();
//request.setAttribute("accountMap",accountMap);
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc1:accountMap1.entrySet())
{    
	int acc2=acc1.getKey();
	Map<Integer,AccountInformation> map=acc1.getValue();
	for(Map.Entry<Integer,AccountInformation> accMap:map.entrySet())
	{ int accountId=accMap.getKey();
	%>
	

  <option value="<%= accountId%>"><%= accountId%> </option>
<%}
}
%>
</select>
<br>


<p Style="text-align:left;font-size:20px;">Amount:</p>
<input type="number" name="amount" style="width:70%;" placeholder="amount" required><br>
<br>
<input type="submit" value="AmountTransaction">
<br>
<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error occurs in  transaction account");
}%>
</div>

<div class="message">
<% 
String name=(String)request.getAttribute("message");
if(name!=null)
		{
	out.println("Account Transaction successfully");
		}

%>
</div>
</div>

</form>
</body>
</html>