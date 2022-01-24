<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registeration</title>
<style>
body{
    background-image: url("image/indexbackground.jpeg");
    color: white;
    background-repeat: no-repeat;
    background-size: cover;
}
form{
    color:black;
    font-size: 15px;
    border-radius: 5px;
    margin : 70px 500px;
    padding: 7px 7px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, .5);
    /* background:rgba(156, 158, 61, 0.438);
    background: rgba(172, 178, 180, 0.322); */
}
form a{
    text-decoration: none;
    color:blue;
    margin-left: 3px;
}
.input
{
    width: 100%;
    margin:5px 0;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom: 1.5px solid black;
    outline:none;
    background: transparent;
}
button{
	 background-color:rgba(226, 226, 17, 0.685);
    border-radius: 4px;
    border-color: transparent;
    color:black;
    padding:10px 130px;
    margin-left: 10px;
}
button:hover{
	opacity: 0.8;
	cursor: pointer;
}

</style>
</head>
<body>
	<form action ="register" method = "post" id="resgister" class="userRegister">
        <label>Name</label>
        <input type="text" id="username" name="username" class="input" pattern="[A-Za-z]{5,}" required><br><br>
        <label>Phone Number</label>
        <input type="phone" name="phonenumber" class="input" pattern="[6-9][0-9]{9}" required><br><br>
        <label>Address</label>
        <input type="text" name="address" class="input" pattern = "[A-Za-z0-9]{4,}+[,][A-Za-z]{4,}+[,][0-9]{6}+{20,}" required><br><br>
        <label>Email Address</label>
        <input type="email" name="email" class="input" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
        <label>Password</label>
        <input type="password" class="input" name="password" pattern="[A-Za-z0-9]{8,10}" required><br><br>
        <button>Register</button>
    </form>
</body>
</html>