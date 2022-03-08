<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add customer</title>
</head>
<body>

<div align="left">
<jsp:include page="Menu.jsp"/>
</div>
<p>Add Customer</p>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("customer added successfully");
		}

%>
<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
%>
<form action="AccountServlet?operation=addCustomer" method="post">
<br><br>
Name:<input type="text" name="Enter Name" placeholder="Enter the name" required><br>
<br>
Address:<input type="text" name="Enter Address" placeholder="Enter the address" required><br>
<br>
MobileNumber:<input type="number" name="Enter MobileNumber" placeholder="Enter the mobilenumber" required><br>
<br>
Email:<input type="text" name="Enter email" placeholder="Enter the Email" required><br>
<br>
<input type="submit" name="submit" value="Add">
<br><br>

<div style="font-size:20px;font-weight:bold;position:absolute;top:90px;right:90px; z-index:999;">
<a href="Admin.jsp">Home</a>
</div>
</form>
</body>
</html>