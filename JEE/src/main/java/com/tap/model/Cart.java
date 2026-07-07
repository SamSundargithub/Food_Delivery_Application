package com.tap.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {

        items = new HashMap<>();

    }

    public Map<Integer, CartItem> getItems() {

        return items;

    }

    public void addItem(CartItem citem) {

        int menuId = citem.getMenuId();

        if(items.containsKey(menuId)) {

            CartItem existingItem = items.get(menuId);

            existingItem.setQuantity(existingItem.getQuantity() + citem.getQuantity());

        }
        else {

            items.put(menuId, citem);

        }

    }

    public void updateItem(int menuId, int quantity) {

        if(items.containsKey(menuId)) {

            if(quantity > 0) {

                items.get(menuId).setQuantity(quantity);

            }
            else {

                items.remove(menuId);

            }

        }

    }

    public void removeItem(int menuId) {

        items.remove(menuId);

    }

}