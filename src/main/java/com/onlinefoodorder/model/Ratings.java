package com.onlinefoodorder.model;

import java.util.Objects;

public class Ratings {
	private int rating_id;
	private int user_id;
	private int restaurant_id;
	private double rating;
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Ratings(int user_id, int restaurant_id, double rating) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.rating = rating;
	}
	public Ratings(int rating_id, int user_id, int restaurant_id, double rating) {
		super();
		this.rating_id = rating_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.rating = rating;
	}
	public Ratings() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(rating, rating_id, restaurant_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ratings other = (Ratings) obj;
		return Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating) && rating_id == other.rating_id
				&& restaurant_id == other.restaurant_id && user_id == other.user_id;
	}
	@Override
	public String toString() {
		return "Ratings [rating_id=" + rating_id + ", user_id=" + user_id + ", restaurant_id=" + restaurant_id
				+ ", rating=" + rating + "]";
	}
	
}
