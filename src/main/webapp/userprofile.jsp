<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.User"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.UserDaoimpl"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
<style>
*{
	margin:0;
	padding:0;
}
body{
    background-image: url("image/indexbackground.jpeg");
    color: white;
    background-repeat: no-repeat;
    background-size: cover;
}		
.detail{
	border: 1px solid rgba(221, 228, 236, 0.363);
	color:black;
    font-size: 14px;
    border-radius: 5px;
    padding: 40px 30px;
    font-weight:bold;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: rgba(255, 255, 128, 0.5);
    margin: 100px 500px;
		}
 .button{
 			padding:7px 50px;
        	border : 1px solid transparent;
        	background-color:rgba(226, 226, 17, 0.685);
        	border-radius:4px;
        	color: white;
        	cursor: pointer;
        	display : inline-flex;
        	margin-left: 7px;
        }
 button:hover {
 			 opacity: 0.8;
		}
button a{
      text-decoration: none;
      color:white;
      font-size:15px;
  }
  h3{
  	text-align : center;
  }
</style>
</head>
<body>

<% 		
   int customerid = (int)session.getAttribute("Userid1");
   UserDaoimpl userdao = new UserDaoimpl();
   List<User> userList = new ArrayList<User>();
   userList = userdao.currentuserprofile(customerid);
%>
<div class ="t1">
<div class="t2">
<%
	int i = 0;
	for (User currentuserprofile: userList ) {
	i++;
%>

<div class="detail">
<h3><b>My Profile</b></h3><br><br><br>
<p>User name       :<%=currentuserprofile.getUser_name()%></p><br>
<p>Phone Number    :<%=currentuserprofile.getPhone_no()%></p><br>
<p>Address         : <%=currentuserprofile.getAddress()%></p><br>
<p>Email address   :<%=currentuserprofile.getEmail_address()%></p><br>
<p>Wallet          : <%=currentuserprofile.getWallet()%></p><br><br>
<button class="button"><a href="showfoods.jsp">Back</a></button>
<button class="button"><a href="updateuser.jsp">Edit</a></button>
</div>


<%
}
%>
</div>
</div>
</body>
</html>