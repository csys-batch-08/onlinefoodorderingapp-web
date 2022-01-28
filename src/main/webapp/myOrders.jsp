<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.onlinefoodorder.model.*"%>
<%@page import="java.util.*"%>
<%@page import="com.onlinefoodorder.daoimpl.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<c:set var="i" value="0"/>
	<c:forEach items="${orderList}" var="orderlist">
	<c:set var="i" value="${i+1}"/>
<tr>

<%-- <td> <%=fooditemdao.findFoodname(userViewOrder.getItem_id())%></td> --%>
<td>${i}</td>
<td>${orderlist.itemId}</td>
<td>${orderlist.quantity}</td>
<td>${orderlist.totalPrice}</td>
<td>${orderlist.orderDate}</td>
<td>${orderlist.orderStatus}</td>

<td><a href="Cancelorderserv?orderid=${orderlist.orderId}"><button>Cancel</button></a></td>
</tr>

</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</body>
</html>