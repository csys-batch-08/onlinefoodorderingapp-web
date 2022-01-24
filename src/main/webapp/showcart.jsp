<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Cart</title>
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
  img{
  	
		height:210px;
		width:245px;
		padding-top: 70px;
		margin: 0;
 
  }
  .names{
		position : relative;
		top:175px;
		right:250px;
		width:150%;
		color: white;
		font-weight: bold;
		font-size: 14px;
	}
	.text
	{
		padding:5.5px;
		border-radius: 4px;
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
        <li><a href="showfoods.jsp">Food Items</a></li>
        <li><a href="showrestaurant.jsp">Restaurants</a></li>
        <li><a href="showcart.jsp">Cart</a></li>
        <li><a href="walletrecharge.jsp">Wallet</a></li>
        <li><a href="viewOrderUser.jsp">My Orders</a>
        <li><a href="userprofile.jsp">My profile</a></li>
        <li><a href="updateuser.jsp">Edit Profile</a>
        <%--<li><a href="ratings.jsp">rating</a></li> --%>
    </ul>
</div>
<%
int itemid = (int)session.getAttribute("itemidcart");
CartDaoimpl cartDaoimpl = new CartDaoimpl();
Cart cart = new Cart();
int userid = (int)session.getAttribute("Userid1");
List<FoodItems> rs = cartDaoimpl.fetchCart(userid);
%>

<table>
<tbody>
	   <tr>
         <%int count=0;
         for(FoodItems showFoodItems : rs){
    	 %>
                    <td>
                        <table id="foodtable">
                            <tbody>
                                <tr>
                                    <td><img src="image/<%=showFoodItems.getFood_image()%>" alt="foodimage"></td>    
                                    <td>
                                  	    <div class="names">Food name   :<%=showFoodItems.getFood_name() %></span><br>
                                        Food Price :<%=showFoodItems.getPrice() %>  </span><br>
                                        <button><a href = "orderfoods.jsp?fname=<%=showFoodItems.getFood_name()%>&resid=<%=showFoodItems.getRestaurant_id()%>">Buy</a></button>
                                        <button><a href = "removeCartserv?itemId=<%=showFoodItems.getItem_id()%>">Remove Item</a></button></div>    
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
</html>