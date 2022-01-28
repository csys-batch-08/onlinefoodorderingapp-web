package com.onlinefoodorder.model;

public class Cart {
	int cartId;
	int userId;
	int itemId;
	public int getCartId() {
		return cartId;
	}
	public void setCartid(int cartId) {
		this.cartId = cartId;
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
	public Cart(int cartId, int userId, int itemId) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.itemId = itemId;
	}
	public Cart() {
		super();
	}	
}
