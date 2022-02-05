<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>User profile update</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-image: url("assets/image/indexbackground.jpeg");
	color: white;
	background-repeat: no-repeat;
	background-size: cover;
}

.input
{
	margin-left: 10px;
    width: 100%;
    margin:5px 5px;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom: 1.5px solid black;
    outline:none;
    background: transparent;
    padding-top: 7px;
}

form{
    color:black;
    font-size: 15px;
    border-radius: 5px;
    margin : 60px 50px;
    padding: 7px 7px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, .5);
}

ul {
	background-color: darkslategray;
	margin-top: 0;
	margin-bottom: 0;
}

li {
	list-style: none;
	padding: 25.7px 18px;
}

li a {
	text-decoration: none;
	color: white;
}

td, th {
	padding: 10px;
}

aside {
	float: left;
	margin-right: 70px;
}

.set1 {
	height: 250px;
	width: 510px;
	margin-left: 400px;
	padding-top: 20px;
}
button{
 			border: 1px solid transparent;
        	background-color:rgba(226, 226, 17, 0.685);
        	border-radius:4px;
        	display: inline-flex;
        	cursor: pointer; 
        	font-weight: bold;
        	padding: 10px 170px;
 }
button a{
      		text-decoration: none;
      		color:black;
}
button:hover{
  			opacity: 2;	
  			background-color:rgba(219, 194, 51, 0.664);
}
h2{
	margin-left: 140px;
}
</style>
</head>
<body>

	<div class="set1">
	<h2>User profile update</h2>
	
	<form action ="updateuser1" method = "post" id="resgister" class="userRegister">
        <label>Name</label>
        <input type="text" id="username" name="username" class="input" pattern="[A-Za-z]{5,}" required><br><br>
        <label>Phone Number</label>
        <input type="phone" name="phonenumber" class="input" pattern="[6-9][0-9]{9}" required><br><br>
        <label>Address</label>
        <input type="text" name="address" class="input" pattern = "[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}" required><br><br>       
        <label>Password</label>
        <input type="password" class="input" name="password" pattern="[A-Za-z0-9]{8,10}" required><br><br>
        <button class="button">Update</a></button>
    </form>
    
</div>
</body>
</html>