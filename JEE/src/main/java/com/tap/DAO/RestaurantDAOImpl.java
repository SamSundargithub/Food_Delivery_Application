package com.tap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.daodes.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.utility.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO{

	
	
	private static final String INSERT = "Insert into Restaurant(restaurant_name, location, phone) Values("
			+ "restaurant_name = ?, location = ?, phone = ?)";
	
	private static final String SELECT = "Select restaurant_name, location, phone, address, rating, cuisine_type from Restaurant where restaurant_id = ?";
	
	private static final String UPDATE = "Update Restaurant set address = ?, phone= ? from Restaurant where restaurant_id = ?";
	
	private static final String DELETE = "Delete from Restaurant where restaurant_id = ?";
	
	private static final String SELECT_ALL = "Select * from Restaurant";
	
	
	@Override
	public void addRestaurant(Restaurant rest) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		
		try {
		  	PreparedStatement pstmt = con.prepareStatement(INSERT);
		  	pstmt.setString(1, rest.getRestaurant_name());
		  	pstmt.setString(2, rest.getLocation());
		  	pstmt.setString(3, rest.getPhone());
		  	
		  	pstmt.executeUpdate();
		  	System.out.println("Inserted...");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurant_id) {
		Connection con = DBConnection.getConnection();
		Restaurant rest = null;
		
		try {
		  PreparedStatement pstmt = con.prepareStatement(SELECT);
		  pstmt.setInt(1, restaurant_id);
		  
		  ResultSet res = pstmt.executeQuery();
		  
		  while(res.next()) {
			 
			  String name = res.getString("restaurant_name");
			  String loc = res.getString("location");
			  String ph = res.getString("phone");
			  String ad = res.getString("address");
			  float rating = res.getFloat("rating");
			  String cuisine = res.getString("cuisine_type");
			  
			  rest = new Restaurant(name, loc, ph, ad, rating, cuisine);
		  }
		}
		catch(Exception e) {
			e.printStackTrace();		
		}
		return rest;
	}

	@Override
	public void updateRestaurant(Restaurant rest) {
		Connection con = DBConnection.getConnection();
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, rest.getAddress());
			pstmt.setString(2, rest.getPhone());
			pstmt.setInt(3,rest.getRestaurant_id());
			
			pstmt.executeUpdate();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restuarantId) {
		Connection con = DBConnection.getConnection();
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, restuarantId);
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		List<Restaurant> list = new ArrayList<Restaurant>();
		Connection con = DBConnection.getConnection();
		
		Restaurant rest = null;
		try {
			Statement pstmt = con.createStatement();
			ResultSet res = pstmt.executeQuery(SELECT_ALL);
			
			while(res.next()) {
				int id = res.getInt("restaurant_id");
				String name = res.getString("restaurant_name");
				String loc = res.getString("location");
				String ph = res.getString("phone");
				String ad = res.getString("address");
				float rating = res.getFloat("rating");
				String cuisine = res.getString("cuisine_type");
				
				rest = new Restaurant(id, name, loc, ph, ad, rating, cuisine);
				list.add(rest);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
