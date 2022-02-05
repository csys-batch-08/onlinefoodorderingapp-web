<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.User"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.dao.impl.UserDaoimpl"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin search user</title>
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
li a{
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
	padding: 10px 5px;
	background-color: rgba(180, 228, 230, 0.5);
	font-weight: bold;
	font-size: 15px;
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
<h3><strong>User Details</strong></h3><br>

<c:set var="i" value="0"/>
<c:forEach items="${userlist}" var="searchUser">
<c:set var="i" value="${i+1}"/>

<p>User name :     ${searchUser.userName}</p><br>
<p>Phone Number :  ${searchUser.phoneNo}</p><br>
<p>Address :       ${searchUser.address}</p><br>
<p>Email address : ${searchUser.emailAddress}</p><br>
<p>Wallet :        ${searchUser.wallet}</p>

</c:forEach>
</div>
</div>
</body>
</html>