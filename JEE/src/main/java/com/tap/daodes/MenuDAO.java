package com.tap.daodes;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDAO {

	void addMenu(Menu m);
	Menu getMenu(int menu_id);
	public List<Menu> getAllMenusByRestaurant(int restaurant_id);
	void updateMenu(Menu m);
	void deleteMenu(int menu_id);
	List<Menu> getAllMenus();
}
