package com.tap.model;

public class Menu {

	private int menu_id;
	private int restaurant_id;
	private String item_name;
	private String description;
	private float price;
	
	public Menu() {
		
	}
	
	

	public Menu(int menu_id, int restaurant_id, String item_name, String description, float price) {
		super();
		this.menu_id = menu_id;
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
	}

	public Menu(int restaurant_id, String item_name, String description, float price) {
		super();
		this.restaurant_id = restaurant_id;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", restaurant_id=" + restaurant_id + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + "]";
	}
	
	
}
