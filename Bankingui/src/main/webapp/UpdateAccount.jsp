<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
body {
background-image: linear-gradient(to left,aliceblue ,black);

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
height:auto;
padding:20px 30px;
background-color:#E6E6FA;
border-radius:20px;
box-shadow:0 0 10px 0 #000;
margin:auto;
position:absolute;
top:20%;
bottom:30%;
left:10%;
right:20%;
text-align:left;}




</style>



<body>
<%@ include file="Menu.jsp" %>

<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

%>




<form action="AccountServlet?operation=updateAccount" method="post">
 
<%-- <%@ include file="Menu.jsp" %>   --%>

<br>

<div class="text" style="align:left">
<p style="font-size:20px;font-weight:bold;">Update Account </p>

<br>
<br>
CustomerId:<br>
<input type="number" name="customerId" placeholder="Enter customerId" required><br>
<br>

Branch:<br>
<input type="text" name="branch" placeholder="enter branch" required><br>
<br>

Balance:<br>
<input type="text" name="balance" placeholder="enter balance" required><br>
<br>

Status:<br>
<input type="text" name="status" placeholder="enter status" required><br>
<br>

<input type="submit" name="submit" value="update"> <br><br>



<br>
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("error in update customer");
}%>



<% String update=(String)request.getAttribute("message");
  if(update!=null)
  {
	  out.println("Updated Successffully");
  
  }

%>
</div>


</form>
<div class="test" style="font-size:20px;font-weight:bold;position:absolute;top:60%;right:53%; z-index:999;">
<a href="Admin.jsp">Account</a>
<br><br>
</div>
</body>
</html>











<!-- AccountId:<br>


 -->