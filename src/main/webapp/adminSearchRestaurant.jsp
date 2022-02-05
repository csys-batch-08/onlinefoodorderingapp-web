<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.dao.impl.*"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.model.*"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang ="en">
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
	margin-right: 380px;
}

h1 {
	border: 1px solid white;
	padding-top: 220px;
	padding-bottom: 20px;
}

.detail {
	padding: 10px 10px;
	background-color: rgba(180, 228, 230, 0.5);
}

.t1 {
	padding: 100px 500px;
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
<div class="detail">

<h3><strong>Restaurant Details</strong></h3><br>

<c:set var="i" value="0"/>
	<c:forEach items="${restaurantList}" var="searchRestaurant">
<c:set var="i" value="${i+1}"/>

<p>Restaurant Id :    ${searchRestaurant.restaurantId}</p><br>
<p>Restaurant Name :  ${searchRestaurant.restaurantName}</p><br>
<p>Area :             ${searchRestaurant.area}</p><br>
<p>City :             ${searchRestaurant.city}- ${searchRestaurant.pincode}</p><br>
<p>Land-line No :     ${searchRestaurant.restaurantLandlineNo}</p><br>
<p>Owner Name :       ${searchRestaurant.ownerName}</p><br>
<p>Operational Hours: ${searchRestaurant.operationalHours}</p><br>
<p>Email Address :    ${searchRestaurant.email}</p><br>
<p>Password :         ${searchRestaurant.password}</p><br>
<p>Restaurant Status: ${searchRestaurant.restaurantStatus}</p>

</c:forEach>

</div>
</div>
</body>
</html>