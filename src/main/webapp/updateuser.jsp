<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User profile update</title>
<style>
*{
	margin:0;
	padding:0;
}
body{
    background-image: url("image/restaurantimge.jpg");
    color: black;
    background-repeat: no-repeat;
    background-size: cover;
}
.input
{
    width: 100%;
    padding:5px 0;
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
    font-size: 14px;
    border-radius: 5px;
    padding: 30px 20px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(221, 228, 236, 0.363);
    
} 
        ul{
            background-color: darkslategray;
            margin-top: 0;
            margin-bottom: 0;
        }
        li{
            list-style:none;
 			padding: 25.7px 18px;
         }
        li a{
            text-decoration: none;
            color:white;
        }
   	 	td, th{
        	padding: 10px;
        }
        aside{
        	float:left;
        	margin-right: 70px;
        }
        .set1{
        	height:250px;
        	width:510px;
        	margin-left: 400px;
        	border: 1px solid white;
        	padding-top : 20px;
        }
        .button{
        	padding:8px 213px;
        	border : 1px solid #2f4f4f;
        	background-color:#2f4f4f;
        	border-radius:4px;
        	
        }
        button a {
        	link-style: none;
        	text-decoration: none;
        	color: white;
        }
</style>
</head>
<body>
	<div class="set1">
	<h3>User profile update</h3>
	<form action ="updateuser1" method = "post" id="resgister" class="userRegister">
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
        <button class="button"><a href="userprofile.jsp">Update</a></button>
    </form>
</div>
</body>
</html>