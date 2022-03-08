
<%@page import="bankdb.AccountDb" %>
<%@page import="bankdb.*" %>
<%@page import="bankdb.AccountInformation" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deactivate </title>
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
background-color:#22896B;
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
border-bottom:2px solid #22896B;
}
.content-table tbody tr.active-row{
font-weight:bold;
color:#22896B;

}


</style>
<body>
<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
%>
<div align="left">
<jsp:include page="Menu.jsp"/>
</div>
<br>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("Account activated successfully");
		}

%>
<p> To activate account </p>


<br>
<%
BankLogic logic=new BankLogic();
Map<Integer,Map<Integer,AccountInformation>> accountMap=logic.selectAccount();
request.setAttribute("accountMap",accountMap);
%>
<table class="content-table">
<thead>
<tr>
<th>customerId</th>
<th>AccountId</th>
<th>Branch</th>
<th>Balance</th>
<th>Status</th>
<th>Activate</th>
</tr>

</thead>


<tbody>
     <c:forEach items="${accountMap}" var="current">
     <c:forEach items="${current.value}" var="current1">
   
		<c:if test="${current1.value.getStatus()==false}">
                 

    <tr>
    
        <td><c:out value="${current.key}"/></td>
        <td><c:out value="${current1.value.getAccountId()}"/></td> 
        <td><c:out value="${current1.value.getBranch()}" /></td> 
        <td><c:out value="${current1.value.getBalance()}" /></td> 
        <td><c:out value="${current1.value.getStatus()}" /></td> 
        <td><a href="ActivateAccountServlet?cusId=${current.key}&accId=${current1.value.getAccountId()}">Activate Account</a>
    </tr>
   </c:if>
     </c:forEach>
  </c:forEach>
  </tbody>
</table>
<div style="font-size:30px;font-weight:bold;position:absolute;top:90px;right:90px; z-index:999;">
<a href="Admin.jsp">Logout</a>
</div>

</body>
</html>