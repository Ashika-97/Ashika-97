<%@page import="bankdb.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@page import="bankdb.CustomerInformation"%>
  <%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Customer page Details</title>
</head>
 <style>
 
 .content-table{
border-collapse:collapse;
margin: 25px 0px;
font-size:0.9em;
min-width:900px;
border-radius:5px 5px 0 0;
overflow:hidden;
box-shadow:0 0 20px rgba(0,0,0,0.15);
}

.content-table thead tr{
background-color:#747E84;
color:#ffffff;
text-align:left;
font-weight:bold;
}
.content-table th,
.content-table td{

padding:20px 25px;
font-size:20px;
}
.content-table tbody tr{
border-bottom:1px solid #dddddd;

}
.content-table tbody tr:nth-of-type(even){
background-color:#f3f3f3;
}
.content-table tbody tr:last-of-type{
border-bottom:2px solid #0c55B2;
}
.content-table tbody tr.active-row{
font-weight:bold;
color:#0c55B2;

}
.test{
text-align:left;
top:50%;
left:10;
}
</style>

<body>

<br>
<br>
welcome
<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}
%>

<h1>Customer Login</h1><br>

<form action="action" method="get">
<a class="button" href="Transaction.jsp">Transfer Money</a>
<a class="button" href="AddCustomer.jsp">Add</a>
<a class="button" href="CustomerAccountDetails.jsp">Customer Account</a>
<br>
<br>
  
<table class="content-table">
<thead>
<tr>
<th scope="col"> customerId</th>
<th scope="col">customerName</th>
<th scope="col">mobileNumber</th>
<th scope="col">Address</th>
<th scope="col">Status</th>
<th scope="col"> Email-Id</th>
<th scope="col">Deactivate</th>
</tr>
</thead>
<tbody>
      <c:forEach items="${Map}" var="current">
       <c:if test="${current.value.getStatus()}">
    <tr>
    <td>
    <button type="submit"formaction="UpdateCustomer.jsp" name="id" value="<c:out value="${current.key}"></c:out>">
          <c:out value="${current.key}"></c:out></button></td>
    
      <td><c:out value="${current.value.getCustomerName()}" /></td>
      <td><c:out value="${current.value.getMobileNumber()}"/></td>
      <td><c:out value="${current.value.getAddress()}"/></td>
      <td><c:out value="${current.value.getStatus() }"/></td>
      <td><c:out value="${current.value.getEmail() }"/></td>
      <td><a href="AccountServlet?operation=deactivateCustomer&cusId=${current.key}">deactivate Customer</a>
    </tr>
    </c:if>
  </c:forEach>
  </tbody>
  </table>




<br>
<div class="test" style="font-size:20px;font-weight:bold;position:absolute;top:50%;left:2%; z-index:999;">
<a href="Logout.jsp">Logout</a>
<br><br>

</div>
</form>
</body>
</html>
