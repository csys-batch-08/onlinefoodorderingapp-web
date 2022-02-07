<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.dao.impl.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Show Cart</title>
<style>
*style {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-image: url("assets/image/showfood33.jpeg");
	font-size: 13.5px;
	background-size: cover;
	background-attachment: fixed;
	overflow-x: hidden;
}

ul {
	list-style: none;
	background-color: black;
	position: fixed;
	margin-bottom: 20px;
	margin: 0;
	width: pc;
}

li {
	display: inline-block;
	padding-top: 13px;
	padding-bottom: 13px;
	text-align: center;
	font-size: 15px;
}

li a {
	text-decoration: none;
	font-weight: bold;
	display: block;
	padding-right: 89px;
	padding-left: 10px;
	color: white;
}

li a:hover {
	opacity: 0.8;
	color: LightSeaGreen;
}

img {
	height: 210px;
	width: 245px;
	padding-top: 80px;
	margin: 0;
}

.names {
	position: relative;
	top: 180px;
	right: 250px;
	width: 200%;
	font-weight: bold;
	font-size: 14px;
}

.table {
	padding-left: 10px;
}

button {
	border: 1px solid #bebebe;
	background-color: #bebebe;
	padding: 5px 5px;
	border-radius: 4px;
}

button a {
	text-decoration: none;
	link-style: none;
	color: black;
	font-weight: bold;
}
</style>
</head>
<body>

<div class="nav">
    <ul>
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

<table>
<caption></caption>
<tbody>

	   <tr>
	   <th id="tableHead"></th>
        <c:set var="count" value="1"/>
       	<c:forEach items="${foodlist}" var="cartlist">
                    <td>
                        <table>
                        <caption></caption>
                            <tbody>
                                <tr>
                                <th id="tableHead"></th>
                                    <td><a href="OrderFoodsServ?fname=${cartlist.foodName}&resid=${cartlist.restaurantId}"><img src="assets/image/${cartlist.foodImage}" alt="foodimage"></a></td>    
                                    <td>
                                  	    <div class="names">${cartlist.foodName}</span><br>
                                        Food Price :${cartlist.price}</span>
                                        <button><a href = "removeCartserv?itemId=${cartlist.itemId}">Remove Item</a></button></div>    
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

</body>
</html>