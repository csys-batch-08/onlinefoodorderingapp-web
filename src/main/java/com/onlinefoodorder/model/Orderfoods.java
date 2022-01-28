package com.onlinefoodorder.model;

import java.time.LocalDate;
import java.util.Objects;

public class Orderfoods 
{
	private int orderId;
	private int userId;
	private int itemId;
	private int quantity;
	private double totalPrice;
	private LocalDate orderDate;
	private String orderStatus;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Orderfoods(int orderId, int userId, int itemId, int quantity, double totalPrice, LocalDate orderDate,
			String orderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}
	public Orderfoods(int userId, int itemId, int quantity, double totalPrice) {
		super();
		this.userId = userId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public Orderfoods(int orderId,int userId, int itemId, int quantity, double totalPrice, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public Orderfoods() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(itemId, quantity, totalPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orderfoods other = (Orderfoods) obj;
		return itemId == other.itemId && quantity == other.quantity
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice)
				&& userId == other.userId;
	}
	@Override
	public String toString() {
		return "user_id = " + userId + " item_id = " + itemId + " quantity = " + quantity + " total_price = " + totalPrice;
	}
	
}

