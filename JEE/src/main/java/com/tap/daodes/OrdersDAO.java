package com.tap.daodes;

import java.util.List;

import com.tap.model.Orders;

public interface OrdersDAO {

	 void addOrder(Orders ord);
	 Orders getOrder(int order_id);
	 void updateOrder(Orders ord);
	 void deleteOrder(int order_id);
	 List<Orders> getAllOrders();
 
}
