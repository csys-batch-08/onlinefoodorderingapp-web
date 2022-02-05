<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Ratings</title>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-image: url("assets/image/background2.jpeg");
	color: black;
	background-repeat: no-repeat;
	background-size: 1370px 700px;
}

.input {
	width: 100%;
	padding: 4px 0;
	margin: 4px 0;
	border-left: 0;
	border-top: 0;
	border-right: 0;
	border-bottom: 1.5px solid black;
	outline: none;
	background: transparent;
	color: white;
}

form {
	color: black;
	font-size: 14px;
	border-radius: 5px;
	padding: 30px 29px;
	font-weight: bold;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: rgba(221, 228, 236, 0.3);
}

.set1 {
	height: 200px;
	width: 300px;
	margin-left: 400px;
}

.t1 {
	border: 1px solid transparent;
	padding-top: 100px;
	padding-left: 110px;
}

.button {
	padding: 7px 43.5px;
	border: 1px solid #2f4f4f;
	background-color: rgba(210, 211, 163, 0.664);
	border-radius: 4px;
	color: white;
	display: inline-flex;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

button a {
	text-decoration: none;
	font-weight: bold;
	color: black;
}
</style>
</head>
<body>

<div class="t1">
<div class="set1">

<form action="rating" method="get">
	<label for="text">Restaurant name</label><br><br>
	<input type="text" name="restaurantname" class="input" id="txt" pattern="[A-Za-z]{5,}" required>
	<label for="rating">Ratings</label><br><br>
	<input type="text" name="rating" class="input" id="txt" pattern="[0-5]" required><br><br>
	<div class="btn"><button class="button">Add</button>
	<button class="button">Back</button></div>
</form>

</div>
</div>
</body>
</html>