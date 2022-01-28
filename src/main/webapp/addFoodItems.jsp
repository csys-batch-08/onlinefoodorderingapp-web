<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food Items</title>
<head>
<style>
*{
	margin:0;
	padding:0;
}
body{
      background-image: url("image/restaurantbackground.jpg");
      background-size: 1400px 630px;
    }
ul{
     background-color: rgba(180, 228, 230, 0.5);
     font-weight: 700;
  }
.input
{
    width: 100%;
    padding:4px 0;
    margin:4px 0;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom: 1.5px solid black;
    outline:none;
    background: transparent;
}
form{
    color:black;
    font-size: 14px;
    border-radius: 5px;
    padding: 30px 20px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(180, 228, 230, 0.5);
} 
li{
     list-style:none;
	padding: 25.7px 18px;
}
li a{
     text-decoration: none;
     color:white;
}
td, th{
   	padding: 10px;
}
aside{
   	float:left;
   	margin-right: 30px;
}
.set1{
        	height:200px;
        	width:300px;
        	margin-left: 400px;
     }
     .t1{
        	border :1px solid transparent;
        	padding-top: 180px;
        	padding-left:110px;
        }
     .button{
        	padding:7px 120px;
        	border : 1px solid #2f4f4f;
        	background-color:#2f4f4f;
        	border-radius:4px;
        	color: white;
        	cursor: pointer;
        }
     button:hover {
 			 opacity: 0.8;
		}
        
</style>
</head>
<aside>
<ul>
       <li><a href="ViewAlluserServ">View users & Search User</a></li>
       <li><a href="inactiveUser.jsp">Inactive users</a></li>
       <li><a href="restaurantDetails.jsp">Register Restaurant</a></li>
       <li><a href="addFoodItems.jsp">Add Food Items</a></li>
       <li><a href="ViewrestaurantServ">View all Restaurant details</a></li> 
       <li><a href="updateRestaurant.jsp">Edit Restaurant</a></li>
       <li><a href="deleteRestaurant.jsp">Inactive Restaurant</a></li>
       <li><a href="ViewFoodsServ">View food details</a></li>
       <li><a href="ViewOrderServ">View Orders</a>
        
</ul>
</aside>
<div class="t1">
<div class="set1">
<body>
<form action="addfoods" method="post">
		<lable for="email">Enter Restaurant emailid to add food Items</lable>
		<input type="email" name="emailid" class="input"><br><br>
		<button class="button">Go</button>
</form>
</div>
</div>
</body>
</html>