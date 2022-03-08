<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Add page</title>
</head>
<style>
body{background-color:lightblue;}
</style>
<body>




welcome
<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
%>
<br><br>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("Account added successfully");
		}

%>



<div align="left">
<%@ include file="Menu.jsp" %> 

</div>
<br>
<p>Add Account here</p>
<form action="AccountServlet?operation=addAccount" method="post">

<br>
AccountId:<input type="number" name="Acc Id" placeholder="accountId"><br>
<br>
CustomerId:<input type="number" name="customerId" placeholder="customerId"><br>
<br>
Branch:<input type="text" name="branch" placeholder="branch"><br>
<br>
balance:<input type ="text" name="balance" placeholder="balance"><br>

<br>
<input type="submit" name="add Account" value="Add Account">

<div style="font-size:20px;font-weight:bold;position:absolute;top:90px;right:90px; z-index:999;">
<a href="Admin.jsp">Home</a>
</div>
</form>
</body>
</html>