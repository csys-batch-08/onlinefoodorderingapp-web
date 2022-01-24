<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>My Orders</title>
</head>
<style>
	table{
		margin-right:400px;
		width: 30%;
	}
	
</style>
<body>

<% int uid = (int)session.getAttribute("Userid1");
   OrderFoodsDaoimpl orderfood = new OrderFoodsDaoimpl(); 
   FoodItemsDaoimpl fooditemdao = new FoodItemsDaoimpl();
   
   List<Orderfoods> orderlist = new ArrayList<Orderfoods>();
   orderlist = orderfood.userViewOrder(uid);
  
	 
   String username = (String)session.getAttribute("username");
   String fname = (String)session.getAttribute("foodname1");%>
<div class ="t1">
<h3><b>My Orders</b></h3>
<div class="t2">
<div class="container mt-1">
<table class="table table-striped table-dark">
	<thead>
	<tr>
  		<th >S.no</th>
		<th>Item Id</th>
		<th>Quantity</th>
		<th>Total Price</th>
		<th>Order Date</th>
		<th>Status</th>
		<th>Cancel order</th>
	</tr>
	</thead>
	<br><br>
<tbody>
<%
int i = 0;
for (Orderfoods userViewOrder: orderlist ) {
i++;
%>
<tr>

<td><%=i%></td>


<%-- <td> <%=fooditemdao.findFoodname(userViewOrder.getItem_id())%></td> --%>
<td> <%=userViewOrder.getItem_id() %></td>
<td> <%=userViewOrder.getQuantity() %></td>
<td> <%=userViewOrder.getTotal_price() %></td>
<td> <%=userViewOrder.getOrder_date() %></td>
<td> <%=userViewOrder.getOrder_status()%></td>

<td><a href="Cancelorderserv?orderid=<%=userViewOrder.getOrder_id()%>"><button>Cancel</button></a></td>
</tr>

<%
}
%>
</tbody>
</table>
</div>
</div>
</div>
</body>
</html>