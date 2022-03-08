<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction In Account</title>
</head>
<body>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("Account Transaction successfully");
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
<div align="right">
<jsp:include page="Menu.jsp"/>
</div>
<br>
<br>
<form action="AccountServlet?operation=transfer"  method="post">
<br>
<%=request.getAttribute("msg") %>

<p>Account Transaction page</p>
<br>
 From AccountNumber:<input type="number" name="accnumber" placeholder="account number" required> 
  <select  name="accId">
<%
BankLogic logic=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap=logic.selectAccount();
//request.setAttribute("accountMap",accountMap);
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
<br>
To AccountNumber:<input type="number" name="to accnumber" placeholder="account number" required>
  <select  name="accId">
<%
BankLogic logic1=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap1=logic1.selectAccount();
//request.setAttribute("accountMap",accountMap);
for(Map.Entry<Integer,Map<Integer,AccountInformation >>  acc1:accountMap1.entrySet())
{    
	int acc2=acc1.getKey();
	Map<Integer,AccountInformation> map=acc1.getValue();
	for(Map.Entry<Integer,AccountInformation> accMap:map.entrySet())
	{ int accountId=accMap.getKey();
	%>
	
 <option value="accountId"><%= accountId%> </option>
<%}
}
%>
</select>
<br>
<br>
Amount:<input type="number" name="amount" placeholder="amount" required><br>
<br>
<input type="submit" value="AmountTransaction">
<br>
<div style="font-size:20px;font-weight:bold;position:absolute;top:90px;right:90px; z-index:999;">
<a href="Admin.jsp">Home</a>
</div>


</form>
</body>
</html>