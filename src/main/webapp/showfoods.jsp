<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
      margin-right: 380px;
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
		padding: 4px 8px;
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
        <li><a href="showfoods.jsp">Food Items</a></li>
        <li><a href="showrestaurant.jsp">Restaurants</a></li>
        <li><a href="showcart.jsp">Cart</a></li>
        <li><a href="walletrecharge.jsp">Wallet</a></li>
        <li><a href="viewOrderUser.jsp">My Orders</a>
        <li><a href="userprofile.jsp">My profile</a></li>
        <li><a href="ratings.jsp">Ratings</a></li>
    </ul>
</div>

<%!
	FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
	List<FoodItems> foodItemList = new ArrayList<FoodItems>();
	RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
	FoodItems fooditem = new FoodItems();
	int restaurantid = fooditem.getRestaurant_id();
	String resname = restaurantdao.findRestaurantName(restaurantid);
%>
<%
	foodItemList = fooditemdao.showFoodItems();
%>
<div class="table">
<table>
<tbody>
	   <tr>
         <%int count=0;
         for(FoodItems showFoodItems : foodItemList){
    	 %>
                    <td>
                        <table id="foodtable">
                            <tbody>
                                <tr>
                                    <td><a href = "addcartserv?fname=<%=showFoodItems.getFood_name()%>&resid=<%=showFoodItems.getRestaurant_id()%>"><img src="image/<%=showFoodItems.getFood_image()%>" alt="foodimage"></a></td>    
                                    <td>
                                    <div class="names"><%=showFoodItems.getFood_name() %><br>
                                     Price :<%=showFoodItems.getPrice()%><br>
                                    <%=restaurantdao.findRestaurantName(showFoodItems.getRestaurant_id())%>
                                    </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>  
                            
                    </td>
                       <% count ++;
                       if(count==4){ %> 
                    	   </tr>
                    	   <tr>              
                     <%count=0; }}%>  
                       
                </tr>
</tbody>
</table>
</div>
</form>
</body>