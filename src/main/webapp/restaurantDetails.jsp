<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Registeration</title>
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
li a {
	text-decoration: none;
	color: black;
}

aside {
	float: left;
	margin-right: 70px;
}

.input {
	width: 60%;
	padding: 10px 0;
	margin: 3px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1.5px solid black;
	outline: none;
	background: transparent;
	font-weight: bold;
	font-size: 13px;
	color: white;
}

form {
	color: black;
	font-size: 15px;
	border-radius: 5px;
	padding: 30px 20px;
	font-weight: bold;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: rgba(180, 228, 230, 0.5);
}

td, th {
	padding: 10px;
}

.set1 {
	height: 250px;
	width: 510px;
	margin-left: 400px;
}

.button {
	padding: 7px 220px;
	border: 1px solid #2f4f4f;
	background-color: #2f4f4f;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}
button:hover {
	opacity: 0.8;
}
.label1{
    margin-right: 20px;
}
.label3{
    margin-right: 102px;
}
.label4{
    margin-right: 106px;
}
.label5{
    margin-right: 81px;
}
.label6{
    margin-right: 20px;
}
.label7{
    margin-right:48px;
}
.label8{
    margin-right:75px;
}
h1{
	color: white;
	margin-bottom: 30px;
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
<h1>Restaurant Regitration</h1>
	<div class="set1">
    <form action="restaurantdetail" method = "post">
            
            <div class="details1">
                <label class="label1" for="restaurantname">Restaurant name</label>
                <input type="text" name="restaurantname" id="txt" class="input" pattern="[A-Za-z]{4,}" required><br>

                <label class="label3" for="area">Area</label>
                <input type="text" name="area" id="txt" class="input" pattern="[0-9A-Za-z]{5,}" required><br>

                <label class="label4" for="city">City</label>
                <input type="text" name="city" id="txt" class="input" pattern="[A-Za-z]{4,}" required><br>

                <label class="label5" for="pincode">Pincode</label>
                <input type="text" name="pincode" id="txt" class="input" pattern="[0-9]{6}" required><br>

                <label class="label6" for="landline">Landline Number</label>
                <input type="phone" name="landlineno" id="txt" class="input" pattern="[1-5]{4}+[5-9]{6}"required><br>

                <label class="label7" for="name">Owner Name</label>
                <input type="text" name="ownername" id="txt" class="input" pattern="[A-Za-z]{3,}" required><br>

                <h4 class="label7" >Mark open hours</h4><br>
                <input type="radio" id="txt" name="time" value="7am to 10pm" required>
                <label for="">7am to 10pm</label>
                <input type="radio" id="txt" name="time" Value="8am to 10pm" required>
                <label for="">10pm to 7am</label>
                <input type="radio" id="txt" name="time" Value="9am to 10pm" required>
                <label for="">7am to 10pm & 10pm to 7am</label><br>
                
                <label class="label7" for="email">Email address</label>
                <input type="email" id="txt" name="email" class="input" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br>
                
                <label class="label8" for="password">Password</label>
                <input type="password" id="txt" name="password" class="input" pattern="[A-Za-z0-9]{8,10}" required><br>
                
                <label class="label9" for="image">Image</label>
                <input type="file" id="txt"name="image" required><br><br>
            </div>
            <button class="button">Next</button>
    </form>
    </div>
</body>
</html>