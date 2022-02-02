<!DOCTYPE html>
<html lang = "en">
<head>
	<title>User & Admin Login</title>
	<style>
	body{
    background-image: url("assets/image/indexbackground.jpeg");
    color: white;
    background-repeat: no-repeat;
    background-size: cover;
}
.userlogin
{
    position:absolute;
    width:280px;
    transition:.5s;
}
.input
{
    width: 100%;
    padding:10px 0;
    margin:5px 0;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom: 1.5px solid black;
    outline:none;
    background: transparent;
}
form{
    color:black;
    font-size: 15px;
    border-radius: 5px;
    margin : 120px 550px;
    padding: 30px 20px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, .5);
}
form a{
    text-decoration: none;
    color:blue;
    margin-left: 3px;
}
form button
{
    background-color:rgba(226, 226, 17, 0.685);
    border-radius: 4px;
    border-color: transparent;
    color:black;
    padding:8px 27px;
    margin-left: 60px;
}
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