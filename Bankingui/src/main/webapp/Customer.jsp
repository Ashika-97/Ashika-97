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
<title>Welcome to Customer Details</title>
</head>
 <style>
 
 .content-table{
border-collapse:collapse;
margin: 10px 20px;
font-size:0.9em;
min-width:500px;
border-radius:10px 10px 0 0;
overflow:hidden;
box-shadow:0 0 20px rgba(0,0,0,0.15);
}

.content-table thead tr{
background-color:#465346;
color:#ffffff;
text-align:left;
font-weight:bold;
}
.content-table th,
.content-table td{
padding:25px 35px;
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
top:10%;
left:90%;
}
.run{
text-align:left;
font-size:15px;
top:10%;
}
</style>

<body>
<%String message=(String) request.getAttribute("message");
 if(message!=null)
 {
	 out.println("Account Deactivated Successfully");
 }
%>


<%@ include file="CustomerMenu.jsp"%>
<br>
<br>

<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

int id=0;
String name=(String)session.getAttribute("user");
BankLogic logic=new BankLogic();
Map<Integer,CustomerInformation> map=logic.selectCustomer(name);
Map<Integer,Map<Integer,AccountInformation>> accMap=null;
AccountInformation customer=null;
Map<Integer,AccountInformation> account1=null;
Map<Integer,AccountInformation> account=null;

%>
<h1>User Bank Details</h1><br>

<form action="action" method="post">
<div class="run" style="text-align:left;font-size:20px;">
welcome
<%=session.getAttribute("user") %>
</div>

<br>
<br>
  
<table border="1" class="content-table">
<thead>
<tr>
<th scope="col"> customerId</th>
<th scope="col">customerName</th>
<th scope="col">AccountId</th>
<th scope="col">Balance</th>
<th scope="col">Branch</th>
<th scope="col">Status</th>


</tr>
</thead>
<tbody> 
<%  for(Map.Entry<Integer,CustomerInformation> custom:map.entrySet())
{
	 id=custom.getKey();
	 accMap=logic.CustomerAccounts(id);
	 for(Map.Entry<Integer,Map<Integer,AccountInformation>> accountCustom:accMap.entrySet())
	 {
		 account=accountCustom.getValue();
		for(Map.Entry<Integer,AccountInformation> finalMap:account.entrySet())
		{
			customer=finalMap.getValue();
		
	 
%>
         <%if(customer.getStatus()){ %>
    <tr>	   
  
      <td><%out.println(id); %></td>
      <td><% out.print(name);%></td>
       <td><% out.print(customer.getAccountId());%></td>
        <td><% out.print(customer.getBalance());%></td>
        <td><%out.println(customer.getBranch()); %></td>
        <td><%out.println(customer.getStatus()); %></td>
           
     
    </tr>
    <%	 } %>
	<%  } %> 
<% } %>
<% } %>
  </tbody>
  </table>
<br>
</form>
</body>
</html>


















