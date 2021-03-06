<%@page import="bankdb.*"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Admin</title>
 

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
body {
background-image: url(admin.jpg); 

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
text-align:center;
}


.content-table{
border-collapse:collapse;
margin: 25px 150px;
font-size:0.9em;
min-width:900px;
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
border-bottom:2px solid #6586A4;
}
.content-table tbody tr.active-row{
font-weight:bold;
color:#6586A4;}

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

<body background="admin.jpg">

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

<form action="action" method="post">
<br>
<div class="message">
 <%String name=(String) request.getAttribute("message");
 if(name!=null)
 {
	 out.println("Account Deactivated Successfully");
 }

%>
</div>
 




<div class="test" style="position:absolute;top:20%;left:40%; z-index:999;">
<button type="submit" style="font-size:18px;" formaction="AddAccount.jsp">Add Accounts</button>
<button type="submit" style="font-size:18px;" formaction="Activate.jsp">View Inactive Accounts</button>

</div>


<br>
<div align="center" style="text-align=left;font-size:20px;">
<h1>Welcome Admin,</h1>
</div>
<br>
<%
BankLogic logic=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap=logic.selectAccount();
request.setAttribute("accountMap",accountMap);

%>

<p style="text-align:left; font-size:25px;">hello admin,everyone details is here!</p>
<div align="left"> 
<table border="1" class="content-table">
<thead>
<tr>

<th>Account Id</th>
<th>Branch</th>
<th>Balance</th>
<th>Status</th>
<th>Deactivate</th>
</tr>
</thead>
<tbody>

     <c:forEach items="${accountMap}" var="account">
     <c:forEach items="${account.value}" var="account1">
	 <c:if test="${account1.value.getStatus()}">
     <tr>
        <td>
        <button type="submit" formaction="UpdateAccount.jsp?id=${account1.value.getAccountId()}&status=${account1.value.getStatus()}" name="id" value="<c:out value="${account1.value.getAccountId()}"></c:out>">
        <c:out value="${account1.value.getAccountId()}"></c:out></button></td>
        <td><c:out value="${account1.value.getBranch()}" /></td> 
        <td><c:out value="${account1.value.getBalance()}" /></td> 
        <td><c:out value="${account1.value.getStatus()}" /></td> 
        <td><a href="AccountServlet?operation=deactivate&cusId=${account.key}&accId=${account1.value.getAccountId()}" onclick="return getConfirmation();">deactivate</a>
    </tr>
   </c:if>
     </c:forEach>
  </c:forEach>
  </tbody>
</table>
</div>

<br>
<div class="error">
<%String error= (String)request.getAttribute("error");
if(error!=null){
	out.println("Error in deactivate customer");
}%>
</div>


<br>
</form>
</body>
</html>
 

<!--  <a href="AddCustomer.jsp" >Add customer</a>
<br><br>
<a href="UpdateCustomer.jsp">Update Customer</a>
<br><br>
<a href="AddAccount.jsp">Add Account </a>
<br><br>
<a href="UpdateAccount.jsp">Update Account </a>
<br><br>
<a href="TransactionInAccount.jsp">Transaction Account</a>
<br><br>
 <button type="button" class="cancelbtn">Cancel</button><br><br>
<a href="Activate.jsp">Activate Account</a>-->









<!-- p style="text-align:center; font-size:20px;">hello admin,everyone details is here!</p>
<div align="center"> 
<table border="1" class="content-table">
<thead>
<tr>
<th>customerId</th>
<th>AccountId</th>
<th>Branch</th>
<th>Balance</th>
<th>Status</th>
<th>deactivate</th>
</tr>
</thead>
</table>


<table>
     <c:forEach items="${accountMap}" var="current">
     <c:forEach items="${current.value}" var="current1">
	 <c:if test="${current1.value.getStatus()}">
     <tr>
        <td>
        <button type="submit" formaction="AddCustomer.jsp" name="id" value="<c:out value="${current.key}"></c:out>">
        <c:out value="${current.key}"></c:out></button></td>
        <td><c:out value="${current1.value.getAccountId()}"/></td> 
        <td><c:out value="${current1.value.getBranch()}" /></td> 
        <td><c:out value="${current1.value.getBalance()}" /></td> 
        <td><c:out value="${current1.value.getStatus()}" /></td> 
        <td><a href="DeactivateServlet?operation=deactivate&cusId=${current.key}&accId=${current1.value.getAccountId()}">deactivate</a>
    </tr>
   </c:if>
     </c:forEach>
  </c:forEach>
</table>
</div>
<br>
</form>
</body>
</html> -->