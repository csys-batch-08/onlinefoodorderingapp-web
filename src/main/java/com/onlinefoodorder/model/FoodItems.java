package com.onlinefoodorder.model;

import java.util.Objects;

public class FoodItems {
		private int restaurant_id;
		private String food_name;
		private String cuisine_name;
		private String description;
		private double price;
		private String food_image;
		private int item_id;
		private String food_status;
		public String getFood_status() {
			return food_status;
		}
		public void setFood_status(String food_status) {
			this.food_status = food_status;
		}
		public int getItem_id() {
			return item_id;
		}
		public void setItem_id(int item_id) {
			this.item_id = item_id;
		}
		public int getRestaurant_id() {
			return restaurant_id;
		}
		public void setRestaurant_id(int restaurant_id) {
			this.restaurant_id = restaurant_id;
		}
		public String getFood_name() {
			return food_name;
		}
		public void setFood_name(String food_name) {
			this.food_name = food_name;
		}
		public String getCuisine_name() {
			return cuisine_name;
		}
		public void setCuisine_name(String cuisine_name) {
			this.cuisine_name = cuisine_name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getFood_image() {
			return food_image;
		}
		public void setFood_image(String food_image) {
			this.food_image = food_image;
		}
		
		public FoodItems(int restaurant_id, String food_name, String cuisine_name, String description, double price, String food_image) {
			super();
			this.restaurant_id = restaurant_id;
			this.food_name = food_name;
			this.cuisine_name = cuisine_name;
			this.description = description;
			this.price = price;
			this.food_image = food_image;
		}
		public FoodItems(int restaurant_id,int item_id, String food_name, String cuisine_name, String description, double price, String food_image) {
			super();
			this.restaurant_id = restaurant_id;
			this.food_name = food_name;
			this.cuisine_name = cuisine_name;
			this.description = description;
			this.price = price;
			this.food_image = food_image;
			this.item_id = item_id;
		}
		@Override
		public int hashCode() {
			return Objects.hash(cuisine_name, description, food_name, price, restaurant_id);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			FoodItems other = (FoodItems) obj;
			return Objects.equals(cuisine_name, other.cuisine_name) && Objects.equals(description, other.description)
					&& Objects.equals(food_name, other.food_name)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& restaurant_id == other.restaurant_id;
		}
		public FoodItems() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return String.format("%-7s%-10s%-9s%-9s%-9s", restaurant_id, food_name, cuisine_name, description, price);
		}
		
		
}
