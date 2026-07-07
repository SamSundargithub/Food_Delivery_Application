package com.tap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.daodes.MenuDAO;
import com.tap.model.Menu;
import com.tap.utility.DBConnection;

public class MenuDAOImpl implements MenuDAO {
	
	
	private static final String INSERT =
			"INSERT INTO menu(restaurant_id,item_name,description,price) VALUES(?,?,?,?)";
	
	private static final String SELECT = "Select * from Menu where menu_id = ?";
	
	private static final String UPDATE = "Update menu set item_name = ?, description = ?, price = ? where menu_id = ?";
	
	private static final String DELETE =
			"DELETE FROM menu WHERE menu_id = ?";
	
	private static final String SELECT_ALL = "Select * from menu";
	
	private static final String SELECT_REST ="Select * from menu where restaurant_id =?"; 

	@Override
	public void addMenu(Menu m) {
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			
				 pstmt.setInt(1, m.getRestaurant_id());
				 pstmt.setString(2, m.getItem_name());
				 pstmt.setString(3, m.getDescription());
				 pstmt.setFloat(4, m.getPrice());
				
				pstmt.executeUpdate();
				System.out.println("Data Inserted...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menu_id) {
		Connection con = DBConnection.getConnection();
		Menu m = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT);
			pstmt.setInt(1, menu_id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int menuid = res.getInt("menu_id");
				int id = res.getInt("restaurant_id");
				String name = res.getString("item_name");
				String description = res.getString("description");
				float price = res.getFloat("price");
				
				m = new Menu(menuid, id, name, description, price);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	@Override
	public  List<Menu> getAllMenusByRestaurant(int restaurant_id) {
		
		Menu m = null;
		Connection con = DBConnection.getConnection();
		List<Menu> list = new ArrayList<Menu>();
		try {

	        PreparedStatement pstmt = con.prepareStatement(SELECT_REST);

	        pstmt.setInt(1, restaurant_id);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int id = res.getInt("menu_id");
				String name = res.getString("item_name");
				String description = res.getString("description");
				float price = res.getFloat("price");
				
				m = new Menu(id, restaurant_id, name, description, price);
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void updateMenu(Menu m) {
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, m.getItem_name());
			pstmt.setString(2, m.getDescription());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setInt(4, m.getMenu_id());
			
			pstmt.executeUpdate();
			System.out.println("Updated......  ");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteMenu(int menu_id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, menu_id);
			
			pstmt.executeUpdate();
			System.out.println("Deleted...");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Menu m = null;
		List<Menu> list = new ArrayList<Menu>();
		try {
			Statement pstmt = con.createStatement();
			
			ResultSet res = pstmt.executeQuery(SELECT_ALL);
			while(res.next()) {
				int id = res.getInt("menu_id");
				int rest_id = res.getInt("restaurant_id");
				String name = res.getString("item_name");
				String description = res.getString("description");
				float price = res.getFloat("price");
				
				m = new Menu(id,rest_id, name, description, price);
				list.add(m);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
		
	}
	
	
}
