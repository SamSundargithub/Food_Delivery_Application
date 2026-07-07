package com.tap.model;

public class OrdItem {

	private int order_item_id;
	private int order_id;
	private int menu_id;
	private int quantity;
	private float subtotal;
	
	
	public OrdItem() {
		
	}


	public OrdItem(int order_id, int menu_id, int quantity, float subtotal) {
		super();
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public OrdItem(int order_item_id, int order_id, int menu_id, int quantity, float subtotal) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.menu_id = menu_id;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}


	public int getOrder_item_id() {
		return order_item_id;
	}


	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}


	@Override
	public String toString() {
		return "OrdItem [order_item_id=" + order_item_id + ", order_id=" + order_id + ", menu_id=" + menu_id
				+ ", quantity=" + quantity + ", subtotal=" + subtotal + "]";
	}
	
	
	
}
