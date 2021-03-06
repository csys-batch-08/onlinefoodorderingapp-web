<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.User"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.dao.impl.UserDaoimpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin view all users</title>
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

td, th {
	padding: 6px;
}

.t1 {
	border: 1px solid transparent;
	padding-top: 20px;
	padding-left: 450px;
	padding-right: 150px;
	padding-bottom: 20px;
}

.t3 {
	padding-top: 20px;
	padding-left: 250px;
	padding-right: 110px;
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
<form action="searchUser" method="post">
		<label for="email">User Email address</label>
		<input type="email" name="email" id="email" placeholder="Search User" class="input">
		<button class="button">view user</button>
</form>
</div>
</div>

<div class ="t3">
<div class="t2">
<table>
<caption></caption>
	<thead>
	<tr>
  		<th >S.no</th>
		<th>User name</th>
		<th>Phone number</th>
		<th>Address</th>
		<th>Email address</th>
		<th>Password</th>
		<th>Wallet</th>
	</tr>
	</thead>
	<br><br>
<tbody>

<c:set var="i" value="0"/>
<c:forEach items="${userlist}" var="viewUser">
<c:set var="i" value="${i+1}"/>
<tr>

<td>${i}</td>
<td>${viewUser.userName}</td>
<td>${viewUser.phoneNo}</td>
<td>${viewUser.address}</td>
<td>${viewUser.emailAddress}</td>
<td>${viewUser.password}</td>
<td>${viewUser.wallet}</td>


</tr>

</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>