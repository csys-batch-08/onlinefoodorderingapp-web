<%@page import="com.onlinefoodorder.model.FoodItems"%>
<%@page import="com.onlinefoodorder.daoimpl.FoodItemsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin view Food details</title>
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
        	margin-right: 300px;
        }
        td, th{
        	padding: 5px;
        }
        .t1{
        	border :1px solid transparent;
        	padding-top: 20px;
        	padding-left:450px;
        	padding-right: 300px;
        	
        }
        .set1{
         background-color: rgba(180, 228, 230, 0.5);
       	 border-radius: 15px;
         padding-top: 20px;
         padding-bottom: 20px;
        }
</style>
</head>
<body>
<aside>
<ul>
        <li><a href="viewuser.jsp">View users & Search User</a></li>
        <li><a href="inactiveuser.jsp">Active & Inactive users</a></li>
        <li><a href="restaurantdetails.jsp">Register Restaurant</a></li>
        <li><a href="addfooditems.jsp">Add Food Items</a></li>
        <li><a href="viewrestaurant.jsp">View all Restaurant details</a></li> 
        <li><a href="updaterestaurant.jsp">Edit Restaurant</a></li>
        <li><a href="deleterestaurant.jsp">Change Restaurant Status</a></li>
        <li><a href="viewfoods.jsp">View food details</a></li>
        <li><a href="vieworders.jsp">View Orders</a>
</ul>
</aside>
<%!
	FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
	List<FoodItems> foodItemList = new ArrayList<FoodItems>();
%>
<%
	foodItemList = fooditemdao.showFoodItems();
%>
<div class="t1">
<div class="set1">
<table>
		<h2><b>View food details</b></h2>
		<thead>
		<tr>
  		<th >S.no</th>
		<th>Item Id</th>
		<th>Food name</th>
		<th>Cuisine name</th>
		<th>Description</th>
		<th>Price</th>
	</tr>
	</thead>
	<br><br>
<tbody>
<%
	int i = 0;
	for (FoodItems showFoodItems: foodItemList){
	i++;
%>
<tr>
	<td><%=i%></td>
	<td><%=showFoodItems.getItem_id()%></td>
	<td><%=showFoodItems.getFood_name()%></td>
	<td> <%=showFoodItems.getCuisine_name()%></td>
	<td> <%=showFoodItems.getDescription()%></td>
	<td> <%=showFoodItems.getPrice()%></td>
</tr>

<%
}
%>
</tbody>
</table>
</div>
</div>
</body>
</html>