package com.onlinefoodorder.model;

public class Cart {
	int cartid;
	int user_id;
	int item_id;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
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
	public Cart(int cartid, int user_id, int item_id) {
		super();
		this.cartid = cartid;
		this.user_id = user_id;
		this.item_id = item_id;
	}
	public Cart() {
		super();
	}
	
}
