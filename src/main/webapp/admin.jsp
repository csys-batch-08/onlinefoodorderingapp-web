<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
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
	margin-right: 380px;
}

h1 {
	border: 1px solid transparent;
	padding-top: 220px;
	padding-bottom: 20px;
	color: white;
}

.active:hover {
	color: Navy;
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
    <h1>Welcome Admin..</h1>  
    
    <c:if test="${sessionScope.Inactive!=null}">
    	<h2>Restaurant ${restaurantname} ${sessionScope.Inactive}</h2>
    </c:if>
    
    <c:remove var="Inactive" scope="session"/>
    
    <c:if test="${sessionScope.Active!=null}">
    	<h2>Restaurant ${restaurantname} ${sessionScope.Active}</h2>
    </c:if>
    
    <c:remove var="Active" scope="session"/>
    
    <c:if test="${sessionScope.ActiveUser!=null}">
    	<h2>${username} ${sessionScope.ActiveUser}</h2>
    </c:if>
    
    <c:remove var="ActiveUser" scope="session"/>
    
    <c:if test="${sessionScope.InactiveUser!=null}">
    	<h2>${username} ${sessionScope.InactiveUser}</h2>
    </c:if>
    
    <c:remove var="InactiveUser" scope="session"/>
    
</body>
</html>