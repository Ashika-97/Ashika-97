<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="bankdb.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Account</title>
</head>
<style>

body {
background-image:linear-gradient(to right,lightpink ,black);
background-image:linear-gradient(to right,rgba(255,0,192,0.3),rgba(192,192)); 

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
text-align:justify;
}



.text{

width:250px;
height:auto;
padding:10px 25px;
background-color:#D8BFD8;
border-radius:20px;
box-shadow:0 0 10px 0 #000;
margin:auto;
position:absolute;
top:20%;
bottom:40%;
left:10%;
right:20%;}

.test{
text-align:left;
left:10%;
right:20%;
color:#090302;
text-indent:40px;

}
.h1{
text-align:left;
top:50%;
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

<%@ include file="Menu.jsp"%>
<form action="AccountServlet?operation=addAccount" method="post">

<h1>welcome to Accounts Adding session </h1>
<div class="error">
<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}
%>
</div>


<br><br>
<div class="message">
<% 
String name=(String) request.getAttribute("message");
if(name!=null)
		{
	out.println("Account added successfully");
		}

%>
</div>
<br>

<p style="text-align:center;font-size:23px;top:50%"></p>


<br>
<div class="text" style="font-size:20px">
<p> Add Account:</p>

CustomerId:<input type="number" name="customerId" placeholder="customerId" required><br>
<br>
Branch:<br>
<select style="width:70%;" name="branch">
<% 
BankLogic logic=new BankLogic();
ArrayList<String> list=logic.getBranchesList();

String branchName="";
for(String branches:list)
{
branchName=branches;	

System.out.println(branchName);%>
<option value="<%=branchName%>"><%=branchName%> </option>
<%}%>

</select>
<br>
<br>

balance:<input type ="text" name="balance" placeholder="balance" required>
<br>
<br>
<input type="submit" name="add Account" value="Add Account">
</div>
<br>
</form>
<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error in add account");
}%>
</div>



</body>
</html>