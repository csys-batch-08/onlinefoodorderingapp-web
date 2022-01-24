<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Food Items</title>
	<link rel="stylesheet" href="fooditems.css">
</head>
<body>
<aside>
<ul>
        <li><a href="viewuser.jsp">View all users</a></li>
        <li><a href="inactiveuser.jsp">Inactive users</a></li>
        <li><a href="restaurantdetails.jsp">Register Restaurant & foods</a></li>
        <li><a href="addfooditems.jsp">Add Food Items</a></li>
        <li><a href="viewrestaurant.jsp">View all Restaurant details</a></li> 
        <li><a href="updaterestaurant.jsp">Edit Restaurant</a></li>
        <li><a href="deleterestaurant.jsp">Delete Restaurant</a></li>
        <li><a href="deletefooditem.jsp">Delete Food Items</a></li>
        <li><a href="viewfoods.jsp">View food details</a></li>
</ul>
</aside>
<div class="set1">
 
    <form action = "foodorderserv" method = "post"> 
    <h2>Outlet type & Timing</h2><br>  
            <label for ="foodname">Food name</label>
            <input type="text" class="input" name ="foodname" pattern="[A-Za-z]{4,}" required><br><br>
            <label for="cuisine">Select cuisine types</label><br><br>
            <input type="radio" class="food" name ="cuisine" value="Indian" required>
            <label for="cuisine">Indian</label>
            <input type="radio" class="food" name ="cuisine" value="Chinese" required>
            <label for="cuisine">Chinese</label>
            <input type="radio" class="food" name ="cuisine" value="Italian" >
            <label for="cuisine">Italian</label><br><br>
            <input type="radio" class="food"name ="cuisine" value="French">
            <label for="cuisine">French</label>
            <input type="radio" class="food" name ="cuisine" value="Spanish">
            <label for="cuisine">spanish</label>
            <input type="radio" class="food" name ="cuisine" value="Turkish">
            <label for="cuisine">Turkish</label><br><br>
            <input type="radio" class="food" name ="cuisine" value="Thai">
            <label for="cuisine">Thai</label>
            <input type="radio" class="food" name ="cuisine" value="Moroccan">
            <label for="cuisine">Moroccan</label>
            <input type="radio" class="food" name ="cuisine" value="Turkish">
            <label for="cuisine">Turkish</label><br><br>
            <label for="description">Description</label>
            <input type="text" class="input" name="description" pattern="[A-Za-z]{4,}" required><br><br>
            <label for="price">Price</label>
            <input type="text" class="input" name="price" pattern="[1-9][0-9]+" maxlength="4" required>
            <label for="image">Image</label>
            <input type="file" name="foodimage" class="input" required><br><br>
            <button class="button">Next</button>
    </form>
    </div>
</body>
</html>