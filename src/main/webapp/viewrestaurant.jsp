<%@page import="com.onlinefoodorder.model.RestaurantDetails"%>
<%@page import="com.onlinefoodorder.daoimpl.RestaurantdetailsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
		<%RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
		  List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
		  restaurantlist= restaurantdao.showRestaurant();
		%>
<div class="t1">
<div class="t2">
	<table>
		<h2>View Restaurant details</h2>
		<thead>
		<tr>
  		<th >S.no</th>
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
<%
	int i = 0;
	for (RestaurantDetails showRestaurant: restaurantlist) 
	{
		i++;
%>
<tr>
	<td><%=i%></td>
	<td><%=showRestaurant.getRestaurant_name()%></td>
	<td><%=showRestaurant.getArea()%></td>
	<td> <%=showRestaurant.getCity()%></td>
	<td> <%=showRestaurant.getPincode()%></td>
	<td> <%=showRestaurant.getRestaurant_landline_no()%></td>
	<td> <%=showRestaurant.getOwner_name()%></td>
	<td> <%=showRestaurant.getOperational_hours()%></td>
	<td> <%=showRestaurant.getEmail()%></td>
	<td> <%=showRestaurant.getRestaurant_status()%></td>
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