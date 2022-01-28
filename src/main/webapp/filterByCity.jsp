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
<title>User View Restaurants</title>
<style>
*style{
	margin:0;
	padding:0;
}
body{
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-image: url("image/foodsbackground4.jpeg");
    font-size:13.5px;
    background-size: 4000px 1500px;
    background-attachment: fixed;
}
  ul
  {
        list-style: none;
        background-color:black;
        position: fixed;
        margin-bottom: 20px;
        margin: 0;
        width:pc;
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
      margin-right: 380px;
  }
	img
	{
		padding-top: 70px;	
		height:230px;
		width:280px;
		overflow:hidden;
		padding-left :50px; 
	}
	.names{
		position : relative;
		top:178px;
		left: -283px;
		width: 200%;
		font-weight: bold;
	}
	
	button{
		border : 1px solid #bebebe;
		background-color:#bebebe;
		padding: 5px 5px;
		border-radius: 4px;
	}
	button a{
		text-decoration :none;
		link-style: none;
		color: black; 
	}
	.text
	{
		padding:5.5px;
		border-radius: 4px;
	}
	form button{
		background-color: #008b8b;
		padding: 4px 8px;
		border-color: transparent;
		border-radius: 3px;
		color: white;
		font-weight: bold;		
	}
</style>
</head>
<body>
<form>
 <div class="nav">
    <ul>
        <li><input type="text" name="city" class="text" placeholder="   City name  "></li>
        <li> <button>Search</button></a></li>
        <li><a href="showFoods.jsp">Food Items</a></li>
        <li><a href="showRestaurant.jsp">Restaurants</a></li>
        <li><a href="showCart.jsp">Cart</a></li>
        <li><a href="walletRecharge.jsp">Wallet</a></li>
        <li><a href="viewOrderUser.jsp">My Orders</a>
        <li><a href="userProfile.jsp">My profile</a></li>
        <li><a href="ratings.jsp">Ratings</a></li>
    </ul>
</div>

<div class="table">
<table>
<tbody>
	   <tr>
		<c:set var="count" value="1"/>
       	<c:forEach items="${restaurantList}" var="restaurantlist">
             <td>
                <table>
                <tbody>
                  <tr>
                      <td><a href="restaurantfoodlistSer?rid=${restaurantlist.restaurantId}"><img src="image/${restaurantlist.restaurantImages}" alt="restaurantimage"></a></td>    
                      <td>
                      <div class="names">${restaurantlist.restaurantName}<br>
                       Address : ${restaurantlist.area} ${restaurantlist.city}<br>  
                       <jsp:useBean id="rating" class="com.onlinefoodorder.daoimpl.RatingsDaoimpl"/>
                       Ratings :${rating.fetchRating(restaurantlist.restaurantId)} <br>                             
                      </div>
                      </td>
                  </tr>
               </tbody>
             </table>  
                            
      	 </td>
             <c:choose>
     		 	<c:when test="${count==3}">
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