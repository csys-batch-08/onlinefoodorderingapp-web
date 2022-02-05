package com.onlinefoodorder.model;

import java.util.Objects;

public class FoodItems {
		private int restaurantId;
		private String foodName;
		private String cuisineName;
		private String description;
		private double price;
		private String foodImage;
		private int itemId;
		private String foodStatus;
		private String restaurantName;
		public String getRestaurantName() {
			return restaurantName;
		}
		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		public String getFoodStatus() {
			return foodStatus;
		}
		public void setFoodStatus(String foodStatus) {
			this.foodStatus = foodStatus;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public int getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(int restaurantId) {
			this.restaurantId = restaurantId;
		}
		public String getFoodName() {
			return foodName;
		}
		public void setFoodName(String foodName) {
			this.foodName = foodName;
		}
		public String getCuisineName() {
			return cuisineName;
		}
		public void setCuisineName(String cuisineName) {
			this.cuisineName = cuisineName;
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
		public String getFoodImage() {
			return foodImage;
		}
		public void setFoodImage(String foodImage) {
			this.foodImage = foodImage;
		}
		
		public FoodItems(int restaurantId, String foodName, String cuisineName, String description, double price, String foodImage) {
			super();
			this.restaurantId = restaurantId;
			this.foodName = foodName;
			this.cuisineName = cuisineName;
			this.description = description;
			this.price = price;
			this.foodImage = foodImage;
		}
		public FoodItems(int restaurantId,int itemId, String foodName, String cuisineName, String description, double price, String foodImage, String restaurantName) {
			super();
			this.restaurantId = restaurantId;
			this.foodName = foodName;
			this.cuisineName = cuisineName;
			this.description = description;
			this.price = price;
			this.foodImage = foodImage;
			this.itemId = itemId;
			this.restaurantName=restaurantName;
		}
		public FoodItems(int restaurantId,int itemId, String foodName, String cuisineName, String description, double price, String foodImage) {
			super();
			this.restaurantId = restaurantId;
			this.foodName = foodName;
			this.cuisineName = cuisineName;
			this.description = description;
			this.price = price;
			this.foodImage = foodImage;
			this.itemId = itemId;
		}
		@Override
		public int hashCode() {
			return Objects.hash(cuisineName, description, foodName, price, restaurantId);
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
			return Objects.equals(cuisineName, other.cuisineName) && Objects.equals(description, other.description)
					&& Objects.equals(foodName, other.foodName)
					&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
					&& restaurantId == other.restaurantId;
		}
		public FoodItems() {
			super();
		}
		@Override
		public String toString() {
			return "FoodItems [restaurantId=" + restaurantId + ", foodName=" + foodName + ", cuisineName=" + cuisineName
					+ ", description=" + description + ", price=" + price + ", foodImage=" + foodImage + ", itemId="
					+ itemId + ", foodStatus=" + foodStatus + ", restaurantName=" + restaurantName + "]";
		}
		
		
}
