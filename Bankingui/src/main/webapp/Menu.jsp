<style>
.container{
float:right;
background:#1F3434;
top:30%;
width:310px;
height:1000px;
left:50%;
text-indent:20px;
color:#fff;
font-weight:bold;
}


.act{
text-align:left;
left:0;
right:0;
color:#090302;
text-indent:40px;
}

</style>
<form action="action" method="post">
<div class="container" style="font-size:35px;">
<br>
<p style="fontsize:40px;text-align:left;">Menu Bar</p>

<div class="act" style="font-size:23px;">
<button type="submit" formaction="Admin.jsp" >Account</button>

</div>
<br>
<div class="act" style="font-size:23px;">
<button type="submit" formaction="AllCustomers.jsp">Customer</button>

<br>
</div>
<br>
<div class="act" style="font-size:23px;">
<button type="submit" formaction="TransactionInAccount.jsp">Transaction</button>
<br>
</div>
<br>

<div class="act" style="font-size:23px;">

<button type="submit" formaction="LoginPage?type=logout">Logout</button>


</div>
</div>
</form>







