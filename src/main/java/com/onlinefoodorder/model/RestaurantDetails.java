package com.onlinefoodorder.model;

import java.util.Objects;

public class RestaurantDetails 
{
	private int restaurantId;
	private String restaurantName;
	private String area;
	private String city;
	private int pincode;
	private long restaurantLandlineNo;
	private String ownerName;
	private String operationalHours;
	private String email;
	private String password;
	private String restaurantImages;
	private String restaurantStatus;
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantStatus() {
		return restaurantStatus;
	}
	public void setRestaurantStatus(String restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public long getRestaurantLandlineNo() {
		return restaurantLandlineNo;
	}
	public void setRestaurantLandlineNo(long restaurantLandlineNo) {
		this.restaurantLandlineNo = restaurantLandlineNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOperationalHours() {
		return operationalHours;
	}
	public void setOperationalHours(String operationalHours) {
		this.operationalHours = operationalHours;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRestaurantImages() {
		return restaurantImages;
	}
	public void setRestaurantimage(String restaurantImages) {
		this.restaurantImages = restaurantImages;
	}
	public RestaurantDetails(String restaurantName, String area, String city, int pincode, long restaurantLandlineNo,
			String ownerName, String operationalHours, String email, String password, String restaurantImages) {
		super();
		this.restaurantName = restaurantName;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.restaurantLandlineNo = restaurantLandlineNo;
		this.ownerName = ownerName;
		this.operationalHours = operationalHours;
		this.email = email;
		this.password = password;
		this.restaurantImages = restaurantImages;
	}
	public RestaurantDetails(int restaurantId, String restaurantName, String area, String city, int pincode, long restaurantLandlineNo,
			String ownerName, String operationalHours, String email, String password, String restaurantImages,
			String restaurantStatus) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.area = area;
		this.city = city;
		this.pincode = pincode;
		this.restaurantLandlineNo = restaurantLandlineNo;
		this.ownerName = ownerName;
		this.operationalHours = operationalHours;
		this.email = email;
		this.password = password;
		this.restaurantImages = restaurantImages;
		this.restaurantStatus = restaurantStatus;
	}
	public RestaurantDetails() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(area, city, email, operationalHours, ownerName, password, pincode, restaurantLandlineNo,
				restaurantName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestaurantDetails other = (RestaurantDetails) obj;
		return Objects.equals(area, other.area) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(operationalHours, other.operationalHours)
				&& Objects.equals(ownerName, other.ownerName) && Objects.equals(password, other.password)
				&& pincode == other.pincode && restaurantLandlineNo == other.restaurantLandlineNo
				&& Objects.equals(restaurantName, other.restaurantName);
	}
	@Override
	public String toString() {
		return "RestaurantDetails [restaurant_name=" + restaurantName + ", area=" + area + ", city=" + city
				+ ", pincode=" + pincode + ", restaurant_landline_no=" + restaurantLandlineNo + ", owner_name="
				+ ownerName + ", operational_hours=" + operationalHours + ", email=" + email + ", password="
				+ password + "]";
	}
	
}
