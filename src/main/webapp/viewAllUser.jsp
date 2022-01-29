<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.User"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.UserDaoimpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin view all users</title>
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
        	color: black;
        }
        .t1{
        	border :1px solid transparent;
        	padding-top: 20px;
        	padding-left: 270px;
        	padding-right: 150px;
        	padding-bottom: 20px;		
        }
        .t3{
        	padding-top: 20px;
        	padding-left: 270px;
        	padding-right: 150px;
        }
        .t2{
        	background-color: rgba(180, 228, 230, 0.5);
       	    border-radius: 15px;
        	padding-left: 100px;
        }
        .set1{
         padding: 10px 10px;
         background-color: rgba(180, 228, 230, 0.5);
       	 border-radius: 15px;
       	 color: white;
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
<h3><strong>Search User</strong></h3>
<form action="searchUser" method="post">
		<label for="email">User Email address</label>
		<input type="email" name="email" class="input">
		<button class="button">view user</button>
</form>
</div>
</div>

<div class ="t3">
<div class="t2">
<table>
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