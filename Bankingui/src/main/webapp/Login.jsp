<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login Form </title>
<style>
body {
background-image: url(align.png); 

-moz-background-size: cover;
-webkit-background-size: cover;
background-size: cover;
background-position: top center !important;
background-repeat: no-repeat !important;
background-attachment: fixed;
text-align:center;
}
.container{
width:250px;
height:auto;
padding:20px 30px;
background-color:#F1EAEA;
border-radius:20px;
box-shadow:0 0 10px 0 #000;
margin:auto;
position:absolute;
top:20%;
bottom:30%;
left:0;
right:0;

}
.container.h1{

  width: 330px; 
  border-radius: 10px;
  padding: 40px 30px;
  margin-top: 100px;
  box-shadow: -3px -3px 9px #aaa9a9a2,
              3px 3px 7px rgba(147, 149, 151, 0.671);
 
}
.user{
  text-align:left;}
</style>
</head>
<body background="align.png">

  <div class="container">
  <h1>Login </h1>
 <br>
  <form action="LoginPage" method="post">
  
  <br>
  <div class="user">
  <label for="username"><b>Username</b></label>
  <input type="text" placeholder="Enter Username" name="username" required>
  <br><br>
  <label for="password"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="password" required><br><br>
     
  <button type="submit">Login</button><br><br>
  
    <label>
    <input type="checkbox" checked="checked" name="remember"> Remember me
    </label><br><br>
    
    <button type="reset" class="cancelbtn">Cancel</button><br><br>
     <span class="psw">Forgot <a href="#">password?</a></span><br><br>
     </div>
  <%String err= (String)request.getAttribute("err"); 
		  if(err!=null)
		  {
			  out.println("username or password invalid");
		  }%>
   </form>
    </div>
</body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!-- <span class="psw">Forgot <a href="#">password?</a></span><br><br> -->
  
  
 