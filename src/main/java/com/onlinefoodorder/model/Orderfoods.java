package com.onlinefoodorder.model;

import java.time.LocalDate;
import java.util.Objects;

public class Orderfoods 
{
	private int order_id;
	private int user_id;
	private int item_id;
	private int quantity;
	private double total_price;
	private LocalDate order_date;
	private String order_status;
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public Orderfoods(int order_id, int user_id, int item_id, int quantity, double total_price, LocalDate order_date,
			String order_status) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.order_date = order_date;
		this.order_status = order_status;
	}
	public Orderfoods(int user_id, int item_id, int quantity, double total_price) {
		super();
		this.user_id = user_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.total_price = total_price;
	}
	public Orderfoods(int order_id,int user_id, int item_id, int quantity, double total_price, LocalDate order_date) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.total_price = total_price;
		this.order_date = order_date;
	}
	public Orderfoods() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(item_id, quantity, total_price, user_id);
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
		return item_id == other.item_id && quantity == other.quantity
				&& Double.doubleToLongBits(total_price) == Double.doubleToLongBits(other.total_price)
				&& user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "user_id = " + user_id + " item_id = " + item_id + " quantity = " + quantity + " total_price = " + total_price;
	}
	
}

