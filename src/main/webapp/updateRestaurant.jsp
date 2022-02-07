<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Update Restaurant details</title>
<style>
* {
	margin: 0;
	padding: 0;
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

.input {
	width: 100%;
	padding: 5px 0;
	margin: 5px 0;
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

li a {
	text-decoration: none;
	color: black;
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
	border: 1px solid transparent;
	padding-top: 20px;
}

.button {
	padding: 8px 213px;
	border: 1px solid #2f4f4f;
	background-color: #2f4f4f;
	border-radius: 4px;
	color: white;
}

h3 {
	color: white;
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
	<div class="set1">
	<form action="updaterestaurantdetail" method = "post">
            <h2>Restaurant Details</h2><br>
            <div class="details1">
                <label for="restaurantname">Restaurant name</label>
                <input type="text" name="restaurantname" id="restaurantname" class="input" pattern="[A-Za-z]{5,}" required><br><br>
                
                <label for="landline">Landline Nunber at restaurant</label>
                <input type="phone" name="landlineno" id="landline" class="input" pattern="[0][1-5]{3}+[5-9]{6}" required><br><br>
                
                <label for="ownername">Owner Name</label>
                <input type="text" name="ownername" id="ownername" class="input" pattern="[A-Za-z]{3,}" required><br><br>
                
                <label for="hours">Mark open hours</label><br><br>
                <input type="radio" id="hours" name="time" value="7am to 10pm" required>
                <label for="">7am to 10pm</label>
                <input type="radio" id="hours" name="time" Value="8am to 10pm" required>
                <label for="">8am to 10pm</label>
                <input type="radio" id="hours" name="time" Value="9am to 10pm" required>
                <label for="">9am to 10pm</label><br><br>
                
                <label for="email">Email address</label>
                <input type="email" id="email" name="email" class="input" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
                
                <label for="password">Password</label>
                <input type="password" id="password" name="password" class="input" pattern="[A-Za-z0-9]{8,10}" required><br><br>  
            </div>
    <button class="button">Update</button>
    </form>
    </div>
	
</body>
</html>