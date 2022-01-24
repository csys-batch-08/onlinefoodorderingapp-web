<html>
<head>
	<title>User & Admin Login</title>
	<link rel="stylesheet" href="login.css">
	<style>
		.btn{
			display: inline-flex;
		}
	</style>
</head>
<body>  
<form action ="userlogin" id="login" class="userlogin" method="post">
    <label>Email Address</label>
        <input type="email" name="email" class="input" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
        <label>Password</label>
        <input type="password" class="input" name="password" pattern="[A-Za-z0-9]{8,10}" required><br><br>
    <div class="btn"><a href="forgotpassword.jsp">Forgot Password?</a>
    <button class="btn">Login</button><br></div>
    <p>Don't have an account<a href="register.jsp">Sign up</a></p>
</form>
</body>
</html>
