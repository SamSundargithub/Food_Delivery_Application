package com.tap.model;

public class Restaurant {
	
	private int restaurant_id;
	private String restaurant_name;
	private String location;
	private String phone;
	private String address;
	private float rating;
	private  String cuisine_type;
	
	public Restaurant() {
		
	}
	
	public Restaurant(int restaurant_id, String restaurant_name, String location, String phone, String address,
			float rating, String cuisine_type) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.location = location;
		this.phone = phone;
		this.address = address;
		this.rating = rating;
		this.cuisine_type = cuisine_type;
	}




	public Restaurant(String restaurant_name, String location, String phone, String address, float rating,
			String cuisine_type) {
		super();
		this.restaurant_name = restaurant_name;
		this.location = location;
		this.phone = phone;
		this.address = address;
		this.rating = rating;
		this.cuisine_type = cuisine_type;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getCuisine_type() {
		return cuisine_type;
	}


	public void setCuisine_type(String cuisine_type) {
		this.cuisine_type = cuisine_type;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name + ", location="
				+ location + ", phone=" + phone + ", address=" + address + ", rating=" + rating + ", cuisine_type="
				+ cuisine_type + "]";
	}



	
}
