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
		
		.container.p{
		font-size:15px;
		}
		.user{
		  text-align:left;
		  }
		  
		  .input{
		  border:10px;
		  text-align:center;
		  font-size:50px;
		  width:100%;
		  font-weight:bold;
		  font-family:"Roboto",sans-serif;
		  padding:10px;
		  
		  }
		  .cover{
		  text-align:center;
		  height:200px;
		  top:50%;
		  left:58%;
		  
		  
		  }
		  .cancelbtn{
		  position:absolute;
		  display: flex;
		  justify-content: center;
		  align-items: center;
		  height: 20px;
		  width:70px;
		  border: 2px solid black;
		}
		
		.error{
		color:red;
		font-size:20px;
		font-weight:bold;
		}
  
</style>
</head>
<body background="align.png">

<div class="input">
<p> SB BANK </p>
</div>



  <div class="container">
  <h1>Login </h1>
  

	  <form action="LoginPage" method="post">
	  <p style="text-align:left;font-size:18px" >Enter Your Username and Password to Proceed</p>
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
    
      <span class="psw">Forgot <a href="ResetPassword.jsp">password?</a></span><br><br>
    
      <button type="reset" class="cancelbtn">Cancel</button><br><br>

  <div class="error">  
     
  <%String err= (String)request.getAttribute("err"); 
		  if(err!=null)
		  {
			  out.println("username or password invalid");
		  }%>
		  </div> 
		  </div>
   </form>
    </div>
</body>
</html>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  <!-- <span class="psw">Forgot <a href="#">password?</a></span><br><br> -->
  
  
 