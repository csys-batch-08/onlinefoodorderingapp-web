<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>User view food items</title>
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
      margin-right: 280px;
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
		padding:5.5px;
		border-radius: 4px;
	}
	form button{
		background-color: #008b8b;
		padding: 3px 8px;
		border-color: transparent;
		border-radius: 3px;
		color: white;
		font-weight: bold;		
	}
</style>
</head>
<body>
<form action="filterfoods" method="post">
<div class="nav">
    <ul>
        <li><input type="text" name="search" class="text" placeholder="   Food name  "></li>
        <li> <button>Search</button></a></li>
        <li><a href="showfoodsservlet">Food Items</a></li>
        <li><a href="ShowRestaurantServ">Restaurants</a></li>
        <li><a href="ShowCartServ">Cart</a></li>
        <li><a href="walletRecharge.jsp">Wallet</a></li>
        <li><a href="MyOrdersServ">My Orders</a>
        <li><a href="UserProfileServ">My profile</a></li>
        <li><a href="ratings.jsp">Ratings</a></li>
        <li><a href="login.jsp">Logout</a></li>
    </ul>
</div>

<div class="table">
<table>
<tbody>
	<tr>
	   <c:set var="count" value="1"/>
       <c:forEach items="${fooditemslistobj}" var="foodlist">
       <td>
         
         <table>
         <tbody>
          <tr>
             <td><a href = "addcartserv?fname=${foodlist.foodName}&resid=${foodlist.restaurantId}"><img src="image/${foodlist.foodImage}" alt="foodimage"></a></td>    
             <td>
             <div class="names">${foodlist.foodName}<br>
             	Price :${foodlist.price}<br>
                ${foodlist.restaurantName}
             </div>
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
</form>
</body>
