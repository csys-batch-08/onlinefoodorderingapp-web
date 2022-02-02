<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang = "en">
<head>
<meta charset="ISO-8859-1">
<title>Insert Food Quantity</title>
<style>
*{
	margin:0;
	padding:0;
}
body{
    background-image: url("image/background2.jpeg");
    color: black;
    background-repeat: no-repeat;
    background-size: 1370px 700px;
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
    padding: 30px 29px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(221, 228, 236, 0.3);
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
        	padding:7px 104px;
        	border : 1px solid #2f4f4f;
        	background-color:rgba(210, 211, 163, 0.664);
        	border-radius:4px;
        	color: white;
        	cursor: pointer;
        }
        button:hover {
 			 opacity: 0.8;
		}
</style>
</head>
<body>
<div class="t1">
<div class="set1">
<form action="orderfood" method="post">

	<label for="quantity">Food Quantity</label><br>
	<input type="number" name="quantity" class="input" pattern="[1-9][0-9]+" maxlength="3" required><br>
	<input type="hidden" name="number" value="<c:out value="${restaurantId}"></c:out>">
	<input type="hidden" name="foodname" value='<c:out value="${foodname}"></c:out>'>
	<br><button type="submit" class="button">Order</button>
</form>
</div>
</div>
</body>
</html>