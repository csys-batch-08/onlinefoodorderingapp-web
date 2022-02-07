<%@page import="com.onlinefoodorder.model.RestaurantDetails"%>
<%@page import="com.onlinefoodorder.dao.impl.RestaurantdetailsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

.t1 {
	border: 1px solid transparent;
	padding-top: 20px;
	padding-left: 450px;
	padding-right: 150px;
	padding-bottom: 20px;
}
th{
	padding: 4px;
	text-align: left;	
}
td{
	padding-left: 5px;
	font-weight: 500px;
}
.t3 {
	padding-top: 20px;
	padding-left: 250px;
	padding-right: 80px;
}

.t2 {
	border-radius: 15px;
	padding-left: 70px;
	background-color: rgba(180, 228, 230, 0.5);
}

.set1 {
	padding: 10px 30px;
	font-size: 17px;
	font-weight: bold;
	color: white;
}

.button {
	padding: 4px 10px;
	border: 1px solid #2f4f4f;
	background-color: #2f4f4f;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

.input {
	padding: 4px 20px;
	border: 1px solid #2f4f4f;
	border-radius: 4px;
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
<form action="SearchRestaurantServ" method="post">
		<label for="email">Restaurant Email address</label>
		<input type="email" name="email" id="txt" class="input" placeholder="Search Restaurant">
		<button class="button">View Restaurant</button>
</form>
</div>
</div>

	
<div class="t3">
<div class="t2">
	<table>
	<caption></caption>
		<h2>View Restaurant details</h2>
	<thead>
		<tr>
  		<th>S.no</th>
		<th>Restaurant name</th>
		<th>Area</th>
		<th>City</th>
		<th>Landline number</th>
		<th>Owner name</th>
		<th>Operational hours</th>
		<th>Email address</th>
		<th>Restaurant Status</th>
		</tr>
	</thead>
	<br><br>
<tbody>

<c:set var="i" value="0"/>
<c:forEach items="${restaurantList}" var="viewRestaurant">
<c:set var="i" value="${i+1}"/>
<tr>

	<td>${i}</td>
	<td>${viewRestaurant.restaurantName}</td>
	<td>${viewRestaurant.area}</td>
	<td>${viewRestaurant.city}</td>
	<td>${viewRestaurant.restaurantLandlineNo}</td>
	<td>${viewRestaurant.ownerName}</td>
	<td>${viewRestaurant.operationalHours}</td>
	<td>${viewRestaurant.email}</td>
	<td>${viewRestaurant.restaurantStatus}</td>
</tr>
</c:forEach>
</tbody>

	</table>
	</div>
	</div>
</body>
</html>