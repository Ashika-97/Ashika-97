<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transfer page</title>
</head>
<body>



<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
%>



<div align="left">
<%@ include file="Menu.jsp" %> 
</div>
<p>Customer Transaction Details</p><br>
<%= request.getAttribute("message") %>
<br>
<form action="AccountServlet?operation=transaction" method="post">
<table>
<tr><td>From Account:</td><td><input type="text" name="from accountNumber" required="required">
 <select  name="accId">
<%
BankLogic logic=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap=logic.selectAccount();
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc:accountMap.entrySet())
{    
	int acc1=acc.getKey();
	Map<Integer,AccountInformation> map=acc.getValue();
	for(Map.Entry<Integer,AccountInformation> accMap:map.entrySet())
	{ int accountId=accMap.getKey();
	%>
	
 <option value="accountId"><%= accountId%> </option>
<%}
}
%>
</select>
 </td></tr>
<tr><td>To Account:</td><td><input type="text" name="to accountNumber" required="required">
  <select  name="accId">
<%
BankLogic logic1=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap1=logic1.selectAccount();
//request.setAttribute("accountMap",accountMap);
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc:accountMap1.entrySet())
{    
	int acc1=acc.getKey();
	Map<Integer,AccountInformation> map=acc.getValue();
	for(Map.Entry<Integer,AccountInformation> accMap:map.entrySet())
	{ int accountId=accMap.getKey();
	%>
	
 <option value="accountId"><%= accountId%> </option>
<%}
}
%>
</select>



</td></tr>
<tr><td>Amount:</td><td><input type="number" name="balance" required="required"></td></tr>
<tr><td><input type="submit" name="Amount Deposit" value="Amount deposit" ></td></tr>

</table>

</form>
</body>
</html>