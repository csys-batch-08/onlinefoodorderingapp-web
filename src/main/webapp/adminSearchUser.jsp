<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.User"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.UserDaoimpl"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin search user</title>
<style>
		*{
			margin:0;
			padding:0;
		}
       body{
      		background-image: url("image/restaurantbackground.jpg");
      		background-size: 1400px 780px;
       }
    	ul{
        	background-color: rgba(180, 228, 230, 0.5);
        	font-weight: 700;
       }
        li{
            list-style:none;
            padding: 25.7px 18px;
        }
        li a{
            text-decoration: none;
            color:black;
        }
        aside{
        	float:left;
        	margin-right: 380px;
        }
        h1{
        	border:1px solid white;
        	padding-top:220px;
        	padding-bottom: 20px;
        }
        .detail{
        	padding: 10px 10px;
        	background-color:rgba(180, 228, 230, 0.5);
        }
        .t1{
        	padding: 100px 500px; 
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

<div class="t1">
<div class="detail">
<h3><strong>User List</strong></h3><br>

<c:set var="i" value="0"/>
<c:forEach items="${userlist}" var="searchUser">
<c:set var="i" value="${i+1}"/>

<p>User name :${searchUser.userName}</p><br>
<p>Phone Number :${searchUser.phoneNo}</p><br>
<p>Address :${searchUser.address}</p><br>
<p>Email address :${searchUser.emailAddress}</p><br>
<p>Wallet : ${searchUser.wallet}</p>

</c:forEach>
</div>
</div>
</body>
</html>