<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin view Food Details</title>
<style>
*style{
	margin:0;
	padding:0;
}
body{
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-image: url("image/");
    font-size:13.5px;
}
  ul
  {
        list-style: none;
        background-color: #1c1c1c;
        margin:0;
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
      color:white;
      display:block;
      padding-right: 7px;
      padding-left: 7px;
  }
  li button{
      margin-right: 500px;
  }
  .text{
        margin-right: 20px;
  }
	img
	{
		height:210px;
		width:250px;
		overflow:hidden;
		padding-top:60px;
		padding-bottom:33px;
	}
	.names{
		position : relative;
		top:180px;
		left: -250px;
		width: 200%;
		padding-bottom:30px;
	}
	.table{
		padding-left: 10px;
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
</style>
</head>
<body>
<div class="nav">
    <ul>
        <li><input type="text" name="search" class="text"></li>
        <li> <button>search</button></a></li>
        <li><a href="showfoods.jsp">Foods</a></li>
        <li><a href="showrestaurant.jsp">Restaurants</a></li>
        <li><a href="showcart.jsp">Cart</a></li>
        <li><a href="walletrecharge.jsp">Wallet</a></li>
        <li><a href="viewOrderUser.jsp">My Orders</a>
        <li><a href="userprofile.jsp">User profile</a></li>
        <li><a href="ratings.jsp">rating</a></li>
    </ul>
</div>

<%!
	FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
	RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
	List<FoodItems> foodItemList = new ArrayList<FoodItems>();
%>
<%
	int resid = (int)session.getAttribute("resid");
	foodItemList = fooditemdao.showFoodsbyRestaurant(resid);
%>
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
                  <td><img src="image/<%=showFoodItems.getFood_image()%>" alt="foodimage"></td>    
                  <td>
                  <div class="names"><%=showFoodItems.getFood_name() %><br>
                  Food Price :<%=showFoodItems.getPrice()%><br>
                  <%=restaurantdao.findRestaurantName(showFoodItems.getRestaurant_id())%>
                  <button><a href = "addcartserv?fname=<%=showFoodItems.getFood_name()%>&resid=<%=showFoodItems.getRestaurant_id()%>">Add to cart</a></button>
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
</body>