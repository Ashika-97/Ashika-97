<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
if(request.getAttribute("message")!=null)
		{
	out.println("Account Updated successfully");
		}

%>



<% 
if(session.getAttribute("user")==null)
	{
	out.println("user is null");
	request.getRequestDispatcher("Login.jsp").forward(request,response);
	}
%>


<p>if you want to update anything the page is here</p><br>
<br>
<div align="right">
<%@ include file="Menu.jsp" %> 
</div>
<br>
<%=request.getAttribute("message")%>
<form action="AccountServlet?operation=updateAccount" method="post">
<br>
AccountId:<input type="number" name="accountId" placeholder="Enter accountId">
  <select  name="accId">
<%
BankLogic logic1=new BankLogic();
Map<Integer,Map<Integer,AccountInformation >> accountMap=logic1.selectAccount();
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
<br>
CustomerId:<input type="number" name="customerId" placeholder="Enter customerId"><br>
<br>
Branch:<input type="text" name="branch" placeholder="enter branch"><br>
<br>
Balance:<input type="text" name="balance" placeholder="enter balance"><br>
<br>
Status:<input type="text" name="status" placeholder="enter status"><br>
<br>
<input type="submit" name="submit" value="update"> <br><br>
<div style="font-size:20px;font-weight:bold;position:absolute;top:90px;right:90px; z-index:999;">
<a href="Admin.jsp">Home</a>
</div>
</form>
</body>
</html>