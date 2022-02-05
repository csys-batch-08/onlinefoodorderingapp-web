<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Inactive user</title>
<style>
* {
	margin: 0;
	padding: 0;
}

.input {
	width: 100%;
	padding: 4px 0;
	margin: 4px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1.5px solid black;
	outline: none;
	background: transparent;
}

form {
	color: black;
	font-size: 14px;
	border-radius: 5px;
	padding: 30px 20px;
	font-weight: bold;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: rgba(180, 228, 230, 0.5);
}

body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-image: url("assets/image/restaurantbackground.jpg");
	background-size: 1400px 780px;
	background-attachment: fixed;
}

ul {
	background-color: rgba(180, 228, 230, 0.5);
	font-weight: 700;
}

li {
	list-style: none;
	padding: 24.2px 18px;
}

li a {
	text-decoration: none;
	color: black;
}

td, th {
	padding: 10px;
}

aside {
	float: left;
	margin-right: 30px;
}

.set1 {
	height: 200px;
	width: 300px;
	margin-left: 400px;
}

.t1 {
	border: 1px solid transparent;
	padding-top: 160px;
	padding-left: 110px;
}

.button {
	padding: 7px 107px;
	border: 1px solid #2f4f4f;
	background-color: #2f4f4f;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

.nav {
	background-color: rgba(180, 228, 230, 0.5);
	padding: 15px 200px;
	margin-top: 30px;
	cursor: pointer;
	border-color: transparent;
}

button a {
	text-decoration: none;
	font-weight: 1000;
	font-size: 15px;
	color: black;
}
</style>
</head>
<body>
<aside>
<ul>
       <li><a href="ViewAlluserServ">View & Search User</a></li>
       <li><a href="inactiveUser.jsp">User Status</a></li>
       <li><a href="restaurantDetails.jsp">Register Restaurant</a></li>
       <li><a href="addFoodItems.jsp">Add Food Items</a></li>
       <li><a href="ViewrestaurantServ">View & Search Restaurant</a></li> 
       <li><a href="updateRestaurant.jsp">Edit Restaurant</a></li>
       <li><a href="deleteRestaurant.jsp">Restaurant Status</a></li>
       <li><a href="ViewFoodsServ">View food details</a></li>
       <li><a href="ViewOrderServ">View Orders</a>
        
</ul>
</aside>
<nav>
	<button class="nav"><a href="#inactiveUser">Inactive User</a></button>
	<button class="nav"><a href="activeUser.jsp">Active User</a></button>
</nav>

<div class="t1">
<div class="set1">

<form action="inactiveusers" method="post">
	<h3>Inactive user</h3><br>
	<label>User Email address </label><br><br>
	<input type="text" class="input" name="email" id="txt" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
	<button class="button">Inactive</button>
</form>

</div>
</div>

</body>
</html>