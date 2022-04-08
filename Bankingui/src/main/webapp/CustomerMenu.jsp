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
.button{
  position:absolute;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 33px;
  width:200px;
  border: 2px solid grey;
  border-radius:70px;
  font-size:20px;
 

}
</style>
<form action="action" method="post">
<div class="menu" style="font-size:35px;">
<p style="fontsize:40px;text-align:left;">Menu Bar</p>
<br><br>
<div class="content" style="font-size:23px;">
<button type="submit" class="button" formaction="Customer.jsp" >Customer</button><br>
</div>
<br>
<div class="content" style="font-size:23px;">
<button type="submit" class="button" formaction="Transaction.jsp" >Transfer Money</button><br>
</div>
<br>

<div class="content" style="font-size:23px;">
<button type="submit" class="button" formaction="LoginPage?type=logout" >Logout</button><br>
<br>

</div>
</div>
</form>



