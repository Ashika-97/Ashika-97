<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*"%>
     <%@page import="bankdb.CustomerInformation"%>
  <%@page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


  <script type = "text/javascript">
        
            function getConfirmation() {
               var result = confirm("Are you sure want to delete?");
               if( result == true ) {
                  
                  return true;
               }
               else {
                 
                  return false;
               }
            }
        
      </script>
  
  

</head>

<style>
 
 .content-table{
border-collapse:collapse;
margin: 40px 20px;
font-size:0.9em;
min-width:500px;
border-radius:5px 5px 0 0;
overflow:hidden;
box-shadow:0 0 20px rgba(0,0,0,0.15);
}

.content-table thead tr{
background-color:#1F3434;
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
text-align:center;
top:50%;
margin:1px;
left:10;
}
.text{
text-align:center;
top:50%;
margin:10 10;
left:10;
}
</style>

<body>

<% 
if(session.getAttribute("user")==null)
	{
	out.println("session expired");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}

%>

<% String message=(String) request.getAttribute("message");
 if(message!=null)
 {
	 out.println("Account Deactivated Successfully");
 }

%>
<form action="AccountServlet" method="post">

<div class="text" style="font-size:30px;font-weight:bold;position:absolute;top:15%;left:43%; z-index:999;">
<button type="submit" formaction="AddCustomer.jsp">Add Customer</button>
<button type="submit" formaction="ActivateCustomer.jsp">View Inactive Customers</button>

</div>





<%@ include file="Menu.jsp"%>



<br>
welcome
<%=session.getAttribute("user") %>


<br>

<% 
BankLogic logic=new BankLogic();
Map<Integer,CustomerInformation> map=logic.selectCustomer();
CustomerInformation customer=null;int id=0;

%>
<h1>Customer Login</h1><br>



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
<th scope="col">Email-Id</th>
<th scope="col">Deactivate</th>

</tr>
</thead>
<tbody> 
<% for(Map.Entry<Integer,CustomerInformation> custom:map.entrySet())
{
	 id=custom.getKey();
	// session.setAttribute("id",id);
	 customer=map.get(id);

%>
         <%if(customer.getStatus()){ %>
    <tr>	   
   
     <td><button type="submit"formaction="UpdateCustomer.jsp" name="id" value="id"><%out.println(customer.getCustomerId()); %></button></td>
      <td><% out.print(customer.getCustomerName());%></td>
       <td><% out.print(customer.getMobileNumber());%></td>
        <td><% out.print(customer.getAddress());%></td>
        <td><%out.println(customer.getStatus()); %></td>
         <td><% out.print(customer.getEmail());%></td>
          <td><a href="AccountServlet?operation=deactivateCustomer&cusId=<% out.print(id);%>" onclick="return getConfirmation();" >deactivate Customer</a>
           
     
    </tr>
<%} %>
<% }%>
  </tbody>
  </table>

<br>
<div class="test" style="font-size:20px;font-weight:bold;position:absolute;top:20%;right:38%; z-index:999;">
<br><br>
</div>
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("error in deactivate customer");
}%>



</form>
</body>
</html>