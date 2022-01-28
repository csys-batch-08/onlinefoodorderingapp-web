package com.onlinefoodorder.model;

import java.util.Objects;

public class Ratings {
	private int ratingId;
	private int userId;
	private int restaurantId;
	private double rating;
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public Ratings(int userId, int restaurantId, double rating) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}
	public Ratings(int ratingId, int userId, int restaurantId, double rating) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.rating = rating;
	}
	public Ratings() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(rating, ratingId, restaurantId, userId);
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
		return Double.doubleToLongBits(rating) == Double.doubleToLongBits(other.rating) && ratingId == other.ratingId
				&& restaurantId == other.restaurantId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Ratings [rating_id=" + ratingId + ", user_id=" + userId + ", restaurant_id=" + restaurantId
				+ ", rating=" + rating + "]";
	}
	
}
