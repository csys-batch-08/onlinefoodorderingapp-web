<%@page import="java.sql.ResultSet"%>
<%@page import="com.onlinefoodorder.model.FoodItems"%>
<%@page import="com.onlinefoodorder.daoimpl.FoodItemsDaoimpl"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter Foods by foodname</title>
<style>
*style{
	margin:0;
	padding:0;
}
body{
	font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, .5);
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
      font-size: 17px;
  }
  li a{
      text-decoration: none;
      color:white;
      display:block;
      padding-right: 7px;
      padding-left: 7px;
  }
  li button{
      margin-right: 600px;
  }
  .text{
        margin-right: 20px;
  }
	img
	{
		height:230px;
		width:280px;
		overflow:hidden;
		padding-top:60px;
		padding-bottom:33px;
	}
	.names{
		position : relative;
		top:160px;
		left: -280px;
	}
	.table{
		padding-left: 70px;
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
        <li><input type="text" class="text"></li>
        <li><button>search</button></li>
        <li><a href="showfoods.jsp">Foods</a></li>
        <li><a href="showrestaurant.jsp">Restaurants</a></li>
        <li><a href="showcart.jsp">Cart</a></li>
        <li><a href="walletrecharge.jsp">Wallet</a></li>
        <li><a href="userprofile.jsp">User profile</a></li>
    </ul>
</div>
<%
	FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
	String foodnames = session.getAttribute("foodname").toString();
	List<FoodItems> foodItemList = fooditemdao.filterbyfoodname(foodnames);
		
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
                                    <td><img src="image/<%=showFoodItems.getFood_image()%>" alt="foodimage"></td>    
                                    <td>
                                     <div class="names"><%=showFoodItems.getFood_name() %><br>
                                     Food Price :<%=showFoodItems.getPrice() %><br>
                                     <button><a href = "addcartserv?fname=<%=showFoodItems.getFood_name()%>&resid=<%=showFoodItems.getRestaurant_id()%>">Add to cart</a></button></div>
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
</body>