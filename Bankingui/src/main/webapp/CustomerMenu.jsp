<style>
.menu{
float:right;
background:#465346;
top:0px;
width:310px;
height:950px;
left:50%;
text-indent:20px;
font-weight:bold;
color:#fff;
}

.content{
text-align:left;
left:0;
right:0;
text-indent:40px;
}






</style>
<form action="action" method="post">
<div class="menu" style="font-size:35px;">
<p style="fontsize:40px;text-align:left;">Menu Bar</p>
<br><br>
<div class="content" style="font-size:23px;">
<button type="submit" formaction="Customer.jsp" >Customer</button>
</div>
<br>
<div class="content" style="font-size:23px;">
<button type="submit" formaction="Transaction.jsp" >Transfer Money</button>
</div>
<br>

<div class="content" style="font-size:23px;">
<button type="submit" formaction="LoginPage?type=logout" >Logout</button>
<br>

</div>
</div>
</form>



