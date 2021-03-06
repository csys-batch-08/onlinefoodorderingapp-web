<%@page import="com.onlinefoodorder.model.FoodItems"%>
<%@page import="com.onlinefoodorder.dao.impl.FoodItemsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin view Food details</title>
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
	margin-right: 300px;
}

td, th {
	padding: 5px;
}

.t1 {
	border: 1px solid transparent;
	padding-top: 20px;
	padding-left: 450px;
	padding-right: 300px;
}

.set1 {
	background-color: rgba(180, 228, 230, 0.5);
	border-radius: 15px;
	padding-top: 20px;
	padding-bottom: 20px;
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

<div class="t1">
<div class="set1">
<table>
<caption></caption>
		<h2><strong>View food details</strong></h2>
		<thead>
		<tr>
  		<th >S.no</th>
		<th>Item Id</th>
		<th>Food name</th>
		<th>Cuisine name</th>
		<th>Description</th>
		<th>Price</th>
	</tr>
	</thead>
<tbody>

<c:set var="i" value="0"/>
<c:forEach items="${foodItemlist}" var="viewfoods">
<c:set var="i" value="${i+1}"/>

<tr>
	<td>${i}</td>
	<td>${viewfoods.itemId}</td>
	<td>${viewfoods.foodName}</td>
	<td>${viewfoods.cuisineName}</td>
	<td>${viewfoods.description}</td>
	<td>${viewfoods.price}</td>
</tr>

</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>