<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
<style>
* {
	margin: 0;
	padding: 0;
}
body {
	background-image: url("image/restaurantbackground.jpg");
	background-size: 1400px 780px;
	color: white;
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

aside {
	float: left;
	margin-right: 380px;
}

h1 {
	border: 1px solid transparent;
	padding-top: 220px;
	padding-bottom: 20px;
	color: white;
}

.active:hover {
	color: Navy;
}
</style>
</head>
<body>
<aside>
<ul>
       <li><a href="ViewAlluserServ" class="active">View users & Search User</a></li>
       <li><a href="inactiveUser.jsp" class="active">Active & Inactive users</a></li>
       <li><a href="restaurantDetails.jsp" class="active">Register Restaurant</a></li>
       <li><a href="addFoodItems.jsp"class="active">Add Food Items</a></li>
       <li><a href="ViewrestaurantServ" class="active">View all Restaurant details</a></li> 
       <li><a href="updateRestaurant.jsp" class="active">Edit Restaurant</a></li>
       <li><a href="deleteRestaurant.jsp" class="active">Active & Inactive Restaurant</a></li>
       <li><a href="ViewFoodsServ" class="active">View food details</a></li>
       <li><a href="ViewOrderServ" class="active">View Orders</a>
</ul>
</aside>
    <h1>Welcome Admin..</h1>  
</body>
</html>