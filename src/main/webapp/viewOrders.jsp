<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
	<title>Admin view all user orders</title>
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
        	margin-right: 70px;
        }
        td, th{
        	padding: 6px;
        }
        .t1{
        	border :1px solid white;
        	padding-top: 20px;
        	
        }
        .t2{
        	background-color: rgba(221, 228, 236, 0.363);
       	    border-radius: 15px;
        	padding-left: 100px;
        }
        .set1{
         padding: 20px 20px;
         background-color: rgba(180, 228, 230, 0.5);
       	 border-radius: 15px;
        }
        .button{
        	padding:4px 10px;
        	border : 1px solid #2f4f4f;
        	background-color:#2f4f4f;
        	border-radius:4px;
        	color: white;
        }
        .input
        {
        	padding : 4px 20px;
        	border : 1px solid #2f4f4f;
        	border-radius:4px;
        	
        }
 		.t1{
        	border :1px solid transparent;
        	padding-top: 60px;
        	padding-left: 400px;
        	padding-right: 300px;
        	
        }
        .set1{
         background-color: rgba(221, 228, 236, 0.363);
       	 border-radius: 15px;
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
<div class="set1">
<h2><strong>View Orders</strong></h2>
<table>
<caption></caption>
	<thead>
	<tr>
  		<th>S.no</th>
		<th>User Id</th>
		<th>Item Id</th>
		<th>Quantity</th>
		<th>Total Price</th>
		<th>Order Date</th>
		<th>Order Status</th>
	</tr>
	</thead>
	<br><br>
<tbody>

<c:set var="i" value="0"/>
<c:forEach items="${orderList}" var="viewOrders">
<c:set var="i" value="${i+1}"/>

<tr>

<td>${i}</td>

<td>${viewOrders.userId}</td>
<td>${viewOrders.itemId}</td>
<td>${viewOrders.quantity}</td>
<td>${viewOrders.totalPrice}</td>
<td>${viewOrders.orderDate}</td>
<td>${viewOrders.orderStatus}</td>

</tr>

</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>