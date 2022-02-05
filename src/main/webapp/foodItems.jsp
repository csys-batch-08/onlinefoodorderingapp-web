<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Insert Food Items</title>
<style>
* {
	margin: 0;
	padding: 0;
}

form {
	color: black;
	font-size: 15px;
	font-weight: bold;
	border-radius: 5px;
	padding: 4px 4px;
	font-weight: bold;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: rgba(221, 228, 236, 0.363);
}

.input {
	width: 95%;
	padding: 4px 0;
	margin: 4px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1.5px solid black;
	outline: none;
	background: transparent;
}

.set1 {
	height: 250px;
	width: 510px;
	margin-left: 400px;
	padding-top: 50px;
}

body {
	background-image: url("assets/image/restaurantbackground.jpg");
	background-size: 1400px 780px;
}

ul {
	background-color: rgba(180, 228, 230, 0.5);
	font-weight: 700;
}

li {
	list-style: none;
	padding: 25.7px 18px;
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

h2 {
	color: white;
	text-align: center;
}

.button {
	padding: 7px 225px;
	border: 1px solid #2f4f4f;
	background-color: #2f4f4f;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}
</style>
</head>
<body>
<aside>
<ul>
       <li><a href="ViewAlluserServ">View users & Search User</a></li>
       <li><a href="inactiveUser.jsp">Inactive users</a></li>
       <li><a href="restaurantDetails.jsp">Register Restaurant</a></li>
       <li><a href="addFoodItems.jsp">Add Food Items</a></li>
       <li><a href="ViewrestaurantServ">View all Restaurant details</a></li> 
       <li><a href="updateRestaurant.jsp">Edit Restaurant</a></li>
       <li><a href="deleteRestaurant.jsp">Inactive Restaurant</a></li>
       <li><a href="ViewFoodsServ">View food details</a></li>
       <li><a href="ViewOrderServ">View Orders</a>
</ul>
</aside>
<div class="set1">
 
    <form action = "foodorderserv" method = "post"> 
    <h2>Outlet type & Timing</h2><br>  
            <label for ="foodname">Food name</label>
            <input type="text" class="input" name ="foodname" pattern="[A-Za-z]{4,}" required><br><br>
            <label for="cuisine">Select cuisine types</label><br><br>
            <input type="radio" class="food" name ="cuisine" value="Indian" required>
            <label for="cuisine">Indian</label>
            <input type="radio" class="food" name ="cuisine" value="Chinese" required>
            <label for="cuisine">Chinese</label>
            <input type="radio" class="food" name ="cuisine" value="Italian" >
            <label for="cuisine">Italian</label><br><br>
            <input type="radio" class="food"name ="cuisine" value="French">
            <label for="cuisine">French</label>
            <input type="radio" class="food" name ="cuisine" value="Spanish">
            <label for="cuisine">spanish</label>
            <input type="radio" class="food" name ="cuisine" value="Turkish">
            <label for="cuisine">Turkish</label><br><br>
            <input type="radio" class="food" name ="cuisine" value="Thai">
            <label for="cuisine">Thai</label>
            <input type="radio" class="food" name ="cuisine" value="Moroccan">
            <label for="cuisine">Moroccan</label>
            <input type="radio" class="food" name ="cuisine" value="Turkish">
            <label for="cuisine">Turkish</label><br><br>
            <label for="description">Description</label>
            <input type="text" class="input" name="description" pattern="[A-Za-z]{4,}" required><br><br>
            <label for="price">Price</label>
            <input type="text" class="input" name="price" pattern="[1-9][0-9]+" maxlength="4" required><br><br>
            <label for="image">Image</label>
            <input type="file" name="foodimage" required><br><br>
            <button class="button">Next</button>
    </form>
    </div>
</body>
</html>