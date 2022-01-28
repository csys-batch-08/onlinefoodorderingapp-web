<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Registeration</title>
<style>
*{
			margin:0;
			padding:0;
		}
       ul{
        background-color: rgba(180, 228, 230, 0.5);
        font-weight: 700;
        }
        li{
            list-style:none;
 			padding: 28px 18px;
        }
        li a{
            text-decoration: none;
            color:black;
        }
        aside{
        	float:left;
        	margin-right: 70px;
        }
body{
      background-image: url("image/restaurantbackground.jpg");
      background-size: 1400px 780px;
    }
.input
{
    width: 100%;
    padding:3px 0;
    margin:3px 0;
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
td, th{
   	padding: 10px;
}
.set1{
        	height:250px;
        	width:510px;
        	margin-left: 400px;
       }
       .button{
        	padding:7px 220px;
        	border : 1px solid #2f4f4f;
        	background-color:#2f4f4f;
        	border-radius:4px;
        	color: white;
        	cursor:pointer;
        }
         button:hover {
 			 opacity: 0.8;
		}


</style>
</head>
<body>
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

	<div class="set1">
    <form action="restaurantdetail" method = "post">
            <h3>Restaurant Regitration</h3>
            <div class="details1">
                <label for="restaurantname">Restaurant name</label>
                <input type="text" name="restaurantname" class="input" pattern="[A-Za-z]{4,}" required><br><br>
                <label for="area">Area</label>
                <input type="text" name="area" class="input" pattern="[0-9A-Za-z]{5,}" required><br><br>
                <label for="city">City</label>
                <input type="text" name="city" class="input" pattern="[A-Za-z]{4,}" required><br><br>
                <label for="pincode">Pincode</label>
                <input type="text" name="pincode" class="input" pattern="[0-9]{6}" required><br><br>
                <label for="landline">Landline Nunber at restaurant</label>
                <input type="phone" name="landlineno" class="input" pattern="[1-5]{4}+[5-9]{6}" required><br><br>
                <label for="name">Owner Name</label>
                <input type="text" name="ownername" class="input" pattern="[A-Za-z]{3,}" required><br><br>
                <h4>Mark open hours</h4>
                <input type="radio" name="time" value="7am to 10pm" required>
                <label for="">7am to 10pm</label>
                <input type="radio" name="time" Value="8am to 10pm" required>
                <label for="">10pm to 7am</label>
                <input type="radio" name="time" Value="9am to 10pm" required>
                <label for="">7am to 10pm & 10pm to 7am</label><br><br>
                <label for="email">Email address</label>
                <input type="email" name="email" class="input" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+{8,15}" required><br><br>
                <label for="password">Password</label>
                <input type="password" name="password" class="input" pattern="[A-Za-z0-9]{8,10}" required><br><br>
                <label for="image">Image</label>
                <input type="file" name="image" class="input" required><br><br>           
            </div>
    <button class="button">Next</button>
    </form>
    </div>
</body>
</html>