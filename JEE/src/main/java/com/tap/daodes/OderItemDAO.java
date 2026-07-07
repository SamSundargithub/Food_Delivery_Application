package com.tap.daodes;

import java.util.List;

import com.tap.model.OrdItem;

public interface OderItemDAO {

	 void addOrderItem(OrdItem ordIt);
	 OrdItem getOrdItem(int order_item_id);
	 void updateOrdItem(OrdItem ordIt);
	 void deleteOrdItem(int order_item_id);
	 List<OrdItem> getAllOrdItem();
}
