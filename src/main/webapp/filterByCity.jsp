<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.dao.impl.*"%>
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
*style {
	margin: 0;
	padding: 0;
}

body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-image: url("assets/image/showfood33.jpeg");
	font-size: 13.5px;
	background-size: 4000px 1500px;
	background-attachment: fixed;
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
	padding-right: 91px;
	padding-left: 10px;
	color: white;
}

li a:hover {
	opacity: 0.8;
	color: LightSeaGreen;
}

img {
	padding-top: 70px;
	height: 230px;
	width: 280px;
	overflow: hidden;
	padding-left: 20px;
}

.names {
	position: relative;
	top: 178px;
	left: -283px;
	width: 200%;
	font-weight: bold;
	color: black;
}

.text {
	padding: 5.5px;
	border-radius: 4px;
}
</style>
</head>
<body>
<form>
 <div class="nav">
    <ul>
        <li><a href="showfoodsservlet">Food Items</a></li>
        <li><a href="ShowRestaurantServ">Restaurants</a></li>
        <li><a href="ShowCartServ">Cart</a></li>
        <li><a href="walletRecharge.jsp">Wallet</a></li>
        <li><a href="MyOrdersServ">My Orders</a>
        <li><a href="UserProfileServ">My profile</a></li>
        <li><a href="ratings.jsp">Ratings</a></li>
        <li><a href="index.jsp">Logout</a></li>
    </ul>
</div>

<div class="table">
<table>
<caption></caption>
<tbody>
	  <tr>
	  <th id="tableHead"></th>
		<c:set var="count" value="1" />
		<c:forEach items="${restaurantList}" var="restaurantlist">
			<td>
			   <table>
			   <caption></caption>
			   <tbody>
					<tr>
					<th id="tableHead"></th>
					<td><a href="restaurantfoodlistSer?rid=${restaurantlist.restaurantId}"><img	src="image/${restaurantlist.restaurantImages}" alt="restaurantimage"></a></td>
					<td><div class="names">${restaurantlist.restaurantName}<br>
						 				   Address : ${restaurantlist.area} ${restaurantlist.city}<br>
											<jsp:useBean id="rating"class="com.onlinefoodorder.dao.impl.RatingsDaoimpl"/>
											Ratings :${rating.fetchRating(restaurantlist.restaurantId)}	<br>
						</div>
					</td>
					</tr>
				</tbody>
				</table>
			</td>
			<c:choose>
				<c:when test="${count==3}">
				<c:set var="count" value="1" />
		</tr>
		<tr>
				</c:when>
			    <c:otherwise>
		        <c:set var="count" value="${count+1}" />
			    </c:otherwise>
			</c:choose>
		</c:forEach>
		</tr>
</tbody>
</table>
</div>
</form>              
</body>