<%@page import="com.onlinefoodorder.model.RestaurantDetails"%>
<%@page import="com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl"%>
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
   	 	td, th{
        	padding: 6px 5px;
        }
        aside{
        	float:left;
        	margin-right: 30px;
        }
        .t1{
        	padding-top : 70px;
        	padding-left: 280px;
        	padding-right : 70px;
        }
        .t2
        {
        background-color: rgba(221, 228, 236, 0.363);
        border-radius: 15px;
        padding-top: 20px;
        padding-left: 20px;
        }
        h2{
        	color: white;
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
<div class="t2">
	<table>
		<h2>View Restaurant details</h2>
	<thead>
		<tr>
  		<th>S.no</th>
		<th>Restaurant name</th>
		<th>Area</th>
		<th>City</th>
		<th>Pincode</th>
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
	<td>${viewRestaurant.pincode}</td>
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