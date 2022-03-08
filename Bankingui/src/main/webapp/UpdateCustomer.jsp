<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update details</title>
</head>
<body>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("customer updated successfully");
		}

%>


<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
%>

<br>
<br>
<form action="AccountServlet?operation=updateCustomer" method="post">
<%=request.getAttribute("msg") %>

<p align="center"> Enter the details to update</p><br>
<div class="container" align="center" style="font-size:20px;">
<label for="replace Name"><b>Name</b></label><br>
<input type="text"  placeholder="replace name" name="replace Name" required><br>
<br>
<label for="replace Address"><b>Address</b></label><br>
<input type="text"  placeholder="replace address" name="replace Address"><br>
<br>

<label for="replace mobileNumber"><b>MobileNumber</b></label><br>
<input type="text"  placeholder="replace mobilenumber" name="replace MobileNumber">
<br>
<label for="replace email"><b>E-mail Id</b></label><br>
<input type="text"  placeholder="replace email" name="replace email"><br>
<button type="submit">Update</button><br> 
</div>
<br>

</form>


</body>
</html>


