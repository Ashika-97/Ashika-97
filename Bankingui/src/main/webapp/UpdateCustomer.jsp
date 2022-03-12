<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update details</title>
</head>
<style>
body {
background-image:linear-gradient(to left,aliceblue ,black); 

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center;
background-repeat: no-repeat ;
background-attachment: fixed;
text-align:center;
}




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


</style>
<body background="update.jpg">
<%@ include file="Menu.jsp"%>


<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

%>



<br>
<br>
<form action="AccountServlet?operation=updateCustomer" method="post">

<div class="text">
<p align="left" style="font-size:20px;font-weight:bold;"> Enter the details to update</p><br>

<label for="replace Name"><b>Name</b></label><br>
<input type="text"  placeholder="replace name" name="replace Name" required>
<br><br>
<label for="replace Address"><b>Address</b></label><br>
<input type="text"  placeholder="replace address" name="replace Address">
<br>
<br>
<label for="replace mobileNumber" ><b>MobileNumber</b></label>
<input type="text"  placeholder="replace mobilenumber" name="replace MobileNumber">
<br><br>
<label for="replace email"><b>E-mail Id</b></label><br>
<input type="text"  placeholder="replace email" name="replace email">
<br><br>
<button type="submit">Update</button><br> 



<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("error in updation");
}%>

<%String message= (String)request.getAttribute("message");
if(message!=null){
	out.println("Customer updated successfully");
}%>

</div>
<br>

</form>


</body>
</html>
















<!--//String err= (String)request.getAttribute("msg");
if(err!=null){
	out.println("update values are invalid");
}%> -->