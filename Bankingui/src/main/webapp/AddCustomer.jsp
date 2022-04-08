<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add customer</title>
</head>
<style>
.text{
width:250px;
height:auto;
padding:20px 30px;
background-color:#9AB8C2;
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
<%@ include file="Menu.jsp"%>

<p>Add Customer:</p>

<div class="error">
<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

%>
</div>

<div class="text" style="font-size:25px">
<form action="AccountServlet?operation=addCustomer" method="post">

<p>Add Customer</p>
Name:<input type="text" name="Enter Name" placeholder="Enter the name" maxlength="15"  required><br>
<br>
Address:<input type="text" name="Enter Address" placeholder="Enter the address" required><br>
<br>
MobileNumber:<input type="text" name="Enter MobileNumber" placeholder="Enter the mobilenumber"  maxlength="10" pattern="\d{10}" required><br>
<br>
Email:<input type="text" name="Enter email" placeholder="Enter the Email" required><br>
<br>
<input type="submit"  value="submit">
</form>

<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error in add customer");
}%>
</div>
<div class="message">
<%String name1=(String) request.getAttribute("message");
  if(name1!=null)
  {
	  out.println("Customer Added Successfully");
  }


%>
</div>
<br><br>
</div>

</body>
</html>















<!-- <div align="left">
<jsp:include page="Menu.jsp"/>
</div> -->