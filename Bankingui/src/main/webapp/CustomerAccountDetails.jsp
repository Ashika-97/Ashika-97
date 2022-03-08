<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="bankdb.*"%>
    <%@page import="java.util.*"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Accounts</title>
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


<form action="action" method="get">
<a class="button" href="Transaction.jsp">Transfer Money</a>
<a class="button" href="AddCustomer.jsp">Add</a>

<br>
<br>
  <%
  request.getAttribute("Map");
%>
  
  
  
<table border="1" class="content-table">
<thead>
<tr>
<th scope="col">AccountId</th>
<th scope="col">branch</th>
<th scope="col">balance</th>

</tr>
</thead>
<tbody>
      <c:forEach items="${mess}" var="customaccount">
     
    <tr>
    <td>
    <button type="submit"formaction="UpdateCustomer.jsp" name="id" value="<c:out value="${customaccount.key}"></c:out>">
          <c:out value="${customaccount.key}"></c:out></button></td>
      <td><c:out value="${customaccount.value.getBranch()}"/></td>
      <td><c:out value="${customaccount.value.getBalance()}"/></td>
    
    </tr>
  
  </c:forEach>
  </tbody>
  </table>




<br>
<div class="test" style="font-size:20px;font-weight:bold;position:absolute;top:30%;left:5%; z-index:999;">
<a href="Logout.jsp">Logout</a>
<br><br>

</div>
</form>





</body>
</html>