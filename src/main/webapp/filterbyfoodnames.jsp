<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlinefoodorder.model.FoodItems"%>
<%@page import="com.onlinefoodorder.daoimpl.FoodItemsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Foods by foodname</title>
<style>
*style{
	margin:0;
	padding:0;
}
body{
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-image: url("image/showfood33.jpeg");
    font-size:13.5px;
    background-size: cover;
    background-attachment: fixed;
   	overflow-x:hidden;
}
  ul
  {
        list-style: none;
        background-color:black;
        position: fixed;
        margin-bottom: 20px;
        margin: 0;
    }
  li{
      display:inline-block;
      padding-top: 13px;
      padding-bottom: 13px;
      text-align: center;
      font-size: 15px;
  }
  li a{
      text-decoration: none;
      font-weight:bold;
      display:block;
      padding-right: 20px;
      padding-left: 10px;
      color: white;
  }
  li a:hover{
  	opacity: 0.8;
  	color: LightSeaGreen;
  }
  li button{
      margin-right: 392px;
  }
  img{
  	
		height:210px;
		width:240px;
		padding-top: 70px;
		margin: 0;
 
  }
  .names{
		position : relative;
		top:175px;
		right:250px;
		width:150%;
		font-weight: bold;
		font-size: 14px;
	}
	.text
	{
		padding:5px;
		border-radius: 4px;
	}
	form button{
		background-color: #008b8b;
		padding: 3px 7px;
		border-color: transparent;
		border-radius: 3px;
		color: white;
		font-weight: bold;		
	}
</style>
</head>
<body>
<div class="nav">
<form>
    <ul>
        <li><input type="text" class="text"></li>
        <li><button>search</button></li>
        <li><a href="showfoodsservlet">Food Items</a></li>
        <li><a href="ShowRestaurantServ">Restaurants</a></li>
        <li><a href="ShowCartServ">Cart</a></li>
        <li><a href="walletrecharge.jsp">Wallet</a></li>
        <li><a href="MyOrdersServ">My Orders</a>
        <li><a href="UserProfileServ">My profile</a></li>
        <li><a href="ratings.jsp">Ratings</a></li>
    </ul>
</form>
</div>

<div class="table">
<table>
<tbody>
	   <tr>
        <c:set var="count" value="1"/>
        <c:forEach items="${filterfoods}" var="foodnames">
        <td>
           <table id="foodtable">
           <tbody>
           <tr>
              <td><img src="image/${foodnames.foodImage}" alt="foodimage"></td>    
              <td>
              <div class="names">${foodnames.foodName}<br>
              Food Price :${foodnames.price}<br>
              <button><a href = "addcartserv?fname=${foodnames.foodName}&resid=${foodnames.restaurantId}">Add to cart</a></button></div>
              </td>
           </tr>
           </tbody>
           </table>  
                       
        </td>
        <c:choose>
        	<c:when test="${count==4}">
        	<c:set var="count" value="1"/>
        </tr>
        <tr>
        	</c:when>
        	<c:otherwise>
        	<c:set var="count" value="${count+1}"/>
        	</c:otherwise>
        </c:choose>
        </c:forEach>
        </tr>
</tbody>
</table>
</div>
</body>