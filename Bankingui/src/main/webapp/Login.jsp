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
bottom:38%;
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
    
    <button type="button" class="cancelbtn">Cancel</button><br><br>
    <span class="psw">Forgot <a href="#">password?</a></span><br><br>
     </div>
  
   </form>
    </div>
</body>
</html>
  
  
  
  
  
  
  
  
  
  
 <!--  <table>
  <tr><td> username:</td><td><input type="text" name="username" placeholder="username" required="required"></td></tr>
  <tr><td> password:</td><td> <input type="password" name="password" placeholder="password" required="required"></td></tr>
<! <style>
 body{
 margin:0;
 padding:0;}
 body:before{
 content:'';
 position:fixed;
 width:100vw;
 height:100vh;
 background-image:pic.jpg;
 background-position:center center;
 background-repeat:no-repeat;
 background-attachment:fixed;
 -moz-filter:blur(10px);
 -webkit-background-size:cover;
 background-size:cover;
 
 }
 .container
 {
 position:absolute;
 top:50%;
 left:50%;
 -webKit-transform:translate(-50%,-50%);
 -moz-transform:translate(-50%,-50%);
 -ms-transform:translate(-50%,-50%);
 -o-transfrom:translate(-50%,-50%);
 transform:translate(-50%,-50%);
 width:400px;
 height:500px;
 padding:80px 40px;
 background:rgba(0,0,0,3);
 }_ 
  <tr><td><input type="submit" name="submit" value="login">

  </table>  
  
  ///
   <div class="container" align="center" style="font-family:sans-serif; font-size:30px;font-weight:Bold;">
  <h1>Login </h1>
  </div><br>
  <form action="LoginPage" method="post">
  
  <br>
  <div class="usercredentials" align="center" style="font-size:1.2em;">
  <label for="username"><b>Username</b></label>
  <input type="text" placeholder="Enter Username" name="username" required>
  <br><br>
  <label for="password"><b>Password</b></label>
  <input type="password" placeholder="Enter Password" name="password" required><br><br>
     
  <button type="submit">Login</button><br><br>
  
    <label>
    <input type="checkbox" checked="checked" name="remember"> Remember me
    </label><br><br>
    </div>
    <div   align="center">
    <button type="button" class="cancelbtn">Cancel</button><br><br>
    <span class="psw">Forgot <a href="#">password?</a></span><br><br>
  </div>
  
  -->
 