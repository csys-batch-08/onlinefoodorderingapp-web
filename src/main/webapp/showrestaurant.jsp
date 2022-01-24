<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
    background-image: url("image/showfood33.jpeg");
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
		color: CornFlowerBlue;
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
<form action="filterbycity" method="post">
 <div class="nav">
    <ul>
        <li><input type="text" name="city" class="text" placeholder="   City name  "></li>
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
	double restaurantRating;
	RestaurantdetailsDaoimpl restaurantdao = new RestaurantdetailsDaoimpl();
	List<RestaurantDetails> restaurantlist = new ArrayList<RestaurantDetails>();
	RatingsDaoimpl ratingdao = new RatingsDaoimpl();
%>
<%
	restaurantlist = restaurantdao.showRestaurant();
%>
<div class="table">
<table>
<tbody>
	   <tr>
		<% int count=0;
	  	   for(RestaurantDetails showRestaurant : restaurantlist){
	 	%>
             <td>
                <table id="foodtable">
                <tbody>
                  <tr>
                  <%
                  int rid = restaurantdao.findRestaurantId2(showRestaurant.getRestaurant_name());
                  %>
                      <td><a href="restaurantfoodlistSer?rid=<%=rid%>"><img src="image/<%=showRestaurant.getRestaurant_images()%>" alt="restaurantimage"></a></td>    
                      <td>
                      <div class="names"><%=showRestaurant.getRestaurant_name() %><br>
                       Address : <%=showRestaurant.getArea() %> <%=showRestaurant.getCity()%><br>
                       <% Ratings rating = new Ratings();
                       	  rating.setRestaurant_id(rid);
                       	  restaurantRating =  ratingdao.fetchRating(rating);
                       %>   
                       Ratings : <%= restaurantRating%><br></div>                               
                      </td>
                  </tr>
               </tbody>
             </table>  
                            
      	 </td>
             <% count ++;
             if(count==3){ %> 
               </tr>
               <tr>              
             <%count=0; }}%>             
         </tr>
</tbody>
</table>
</div> 
</form>              
</body>