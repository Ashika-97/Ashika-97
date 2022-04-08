<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reset password</title>
</head>
<body>
<form action="ResetServlet" method="post">

<h1>Reset password:</h1><br>
<p>forgot your password no worries!</p><br>
UserName:<input type="text" name="username" placeholder="username" required><br>
<br>
Mobile number<input type="number" name="mobilenuumber" maxlength="10" pattern="\d{10}" required><br>
<br>
Reset Password:<input type="text" name="reset" placeholder="resetpassword" required><br>
<br>
CustomerId<input type="number" name="customerId" maxlength="10" pattern="\d{10}" required><br>
<br>
AccountId<input type="number" name="AccountId" maxlength="10" pattern="\d{10}" required><br>
<br>
<button type="submit" class="reset">reset</button>

</form>
</body>
</html>