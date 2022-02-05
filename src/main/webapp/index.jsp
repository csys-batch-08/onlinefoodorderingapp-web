<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
h2{
	color:black;
	font-weight: bold;
}
p a{
	padding-left: 7px;
}
	</style>
</head>
<body>     
    
<form action ="userlogin" id="login" class="userlogin" method="post">
    
    <label for="email">Email Address</label>
    <input type="text" name="email" class="input" id = "email"><br><br>
    <label for="password">Password</label>
    <input type="password" class="input" name="password" id = "password"><br><br>
    <div class="btn"><a href="forgotPassword.jsp">Forgot Password?</a>
    <button class="btn" onClick="login()">Login</button><br></div>
    <p>Don't have an account ?<a href="register.jsp">Sign up</a></p>
    
<%--    <c:if test="${sessionScope.validateUser!=null}">
    	<h2>${sessionScope.validateUser}</h2>
    	</c:if>
    
    <c:remove var="validateUser" scope="session"/>     --%> 
</form>

<script>

function login()
{
	console.log("hi");
	var username = document.getElementById("email").value;
	var password = document.getElementById("password").value;
	
	if(username == '')
	{
		alert("Please enter valid email address.");
	}
	else if(password=='')
	{
    	alert("Please enter valid Password");
	}
	
	else if(password.length < 6 || password.length > 10)
	{
		alert("Password maximum length is 10.");
	}
}

</script>
</body>
</html>