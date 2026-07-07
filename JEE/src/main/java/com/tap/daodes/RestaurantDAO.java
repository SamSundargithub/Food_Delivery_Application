package com.tap.daodes;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {

	void addRestaurant(Restaurant rest);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant rest);
	void deleteRestaurant(int restuarantId);
	List<Restaurant> getAllRestaurants();
}
