<%@page import="com.onlinefoodorder.model.User"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recharge Wallet</title>
    <style>
    *style{
	margin:0;
	padding:0;
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
  form{
    color:black;
    font-size: 15px;
    border-radius: 5px;
    margin : 70px 490px;
    padding: 7px 7px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, .5);
}
form a{
    text-decoration: none;
    color:blue;
    margin-left: 3px;
}
.input
{
	margin-left: 10px;
    width: 100%;
    margin:5px 5px;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom: 1.5px solid black;
    outline:none;
    background: transparent;
}
  body{
    background-image: url("image/indexbackground.jpeg");
    color: white;
    background-repeat: no-repeat;
    background-size: cover;
}
.button{
        	padding:10px 28px;
        		
        }
.button1{
        	padding:10px 60px;
        	margin-left: 9px;
        }
 button{
 			border: 1px solid transparent;
        	background-color:rgba(226, 226, 17, 0.685);
        	border-radius:4px;
        	display: inline-flex;
        	cursor: pointer; 
        	font-weight: bold;
 }
 button a{
      		text-decoration: none;
      		color:black;
}
button:hover{
  			opacity: 0.8;	
  			background-color:rgba(219, 194, 51, 0.664);
}
</style>
</head>
<body>

<h2>Welcome ${username}</h2>

<form action="rechargewallet" method="post">
       <h2>Recharge Your Wallet..</h2><br>

         <input type="hidden" name="email" value="${emailid}"><br><br>
                 
         <label for="cardnumber">Card Number</label><br>
         <input type="text" class="input" name="cardnumber" pattern ="[1-9]{16}" required><br><br>
                 
         <label for="cvv">CVV</label><br>
         <input type="text" class="input" name="cvv" pattern="[1-9]{3}" required><br><br>
         
         <label for="Amount">Amount</label><br>
         <input type="text" class="input" name="amount" pattern="[1-9][0-9]+" maxlength="5" required><br><br>
         <button class="button1"><a href="showfoodsservlet">Back</a></button> 
         <button class="button">Recharge Wallet</a></button>
    </form>
</body>
</html>

