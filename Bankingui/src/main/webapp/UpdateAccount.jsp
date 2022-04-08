<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>
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



<form action="AccountServlet?operation=updateAccount" method="post">
 
<%-- <%@ include file="Menu.jsp" %>   --%>

<br>

<div class="text" style="align:left">
<p style="font-size:20px;font-weight:bold;">Update Account </p>

<br>
<br>
<%String id=request.getParameter("id");
String status=request.getParameter("status");%>
CustomerId:<br>
<input type="number" name="customerId" value="<%out.print(id); %>" placeholder="Enter customerId" required><br>
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

</select><br><br>


Balance:<br>
<input type="text" name="balance" placeholder="enter balance" required><br>
<br>

Status:<br>
<input type="text" name="status" value="<%out.print(status); %>" placeholder="enter status" required><br>
<br>

<input type="submit" name="submit" value="update"> <br><br>



<br>
<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error in update customer");
}%>
</div>

<div class="message">
<% String update=(String)request.getAttribute("message");
  if(update!=null)
  {
	  out.println(" Account Updated Successffully");
  
  }

%>
</div>
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