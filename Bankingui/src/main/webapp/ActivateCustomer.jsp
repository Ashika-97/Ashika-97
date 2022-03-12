<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@page import="bankdb.*"%>
 <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chnage to Active Customer</title>
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
</style>
<body>
<%@ include file="Menu.jsp"%>


<h1>Activate Customer Account</h1><br>

<form action="action" method="get">

<br>
<br>
 <%
 BankLogic logic=new BankLogic();
 Map<Integer,CustomerInformation> map=logic.selectCustomer();
 CustomerInformation customer=null;int id=0;

 %>

<table class="content-table">
<thead>
<tr>
<th scope="col"> customerId</th>
<th scope="col">customerName</th>
<th scope="col">mobileNumber</th>
<th scope="col">Address</th>
<th scope="col"> EmailId</th>
<th scope="col">Activate</th>
</tr>
</thead>
<tbody>
     <% for(Map.Entry<Integer,CustomerInformation> custom:map.entrySet())
{
	 id=custom.getKey();
	
	 customer=map.get(id);

%>
     
     
    <%if(!customer.getStatus()){ %>
    <tr>
    <td>
    <button type="submit"formaction="UpdateCustomer.jsp" name="id" value="id">out.print(id)</button></td>
      <td><% out.print(customer.getCustomerName());%></td>
       <td><% out.print(customer.getMobileNumber());%></td>
        <td><% out.print(customer.getAddress());%></td>
         <td><% out.print(customer.getEmail());%></td>
      <td><a href="ActivateAccountServlet?operation=activateCustomer&cusId=<% out.print(id);%> ">activate Customer</a></td>
    </tr>
    <% }%>
<%-- </c:if> --%>
 <% }%>

</tbody>
</table>
</form>
<%String message1=(String) request.getAttribute("error");
 if(message1!=null)
 {
	 out.println("error in activating Customer");
 }

%>

<%String message=(String) request.getAttribute("message");
 if(message!=null)
 {
	 out.println("Customer Activated Successfully");
 }

%>
</body>
</html>