package com.tap.model;

import java.sql.Timestamp;

public class Orders {

	private int order_id;
	private int user_id;
	private int restaurant_id;
	private Timestamp order_date;
	private double total_amount;
	
	
	public Orders() {
		
	}


	


	public Orders(int user_id, int restaurant_id, Timestamp order_date, double total_amount) {
		super();
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
	}





	public Orders(int order_id, int user_id, int restaurant_id, Timestamp order_date, double total_amount) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurant_id = restaurant_id;
		this.order_date = order_date;
		this.total_amount = total_amount;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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


	public Timestamp getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}


	public double getTotal_amount() {
		return total_amount;
	}


	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}


	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", user_id=" + user_id + ", restaurant_id=" + restaurant_id
				+ ", order_date=" + order_date + ", total_amount=" + total_amount + "]";
	}
	
	
	
}
