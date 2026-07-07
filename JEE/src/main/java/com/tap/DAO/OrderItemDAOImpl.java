package com.tap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.daodes.OderItemDAO;
import com.tap.model.OrdItem;
import com.tap.utility.DBConnection;

public class OrderItemDAOImpl implements OderItemDAO{

	private static final String INSERT = "Insert into Orders( order_id, menu_id, quantity, subtotal)"
			+ "values(order_id = ?, menu_id = ?, quantity = ?, subtotal = ?";
	
	private static final String UPDATE = "Update Orders set quantity = ?, subtotal = ? where order_item_id = ?";
	
	private static final String SELECT = "Select order_id, menu_id, quantity, subtotal from Orders where order_item_id = ?";
	
	private static final String DELETE = "Delete Orders where order_item_id = ?";
	
	private static final String SELECT_ALL = "Select * from Orders";

	@Override
	public void addOrderItem(OrdItem ordIt) {
		
	try {
	Connection con = DBConnection.getConnection();
	PreparedStatement pstmt = con.prepareStatement(INSERT);	
		pstmt.setInt(1, ordIt.getOrder_id());
		pstmt.setInt(2, ordIt.getMenu_id());
		pstmt.setInt(3, ordIt.getQuantity());
		pstmt.setFloat(4, ordIt.getSubtotal());
		
		pstmt.executeUpdate();
		System.out.println("Updated...");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}

	@Override
	public OrdItem getOrdItem(int order_item_id) {
		Connection con = DBConnection.getConnection();
		OrdItem ordIt = null;
		try {
			
			PreparedStatement pstmt = con.prepareStatement(SELECT);
			pstmt.setInt(1, order_item_id);
			pstmt.executeUpdate();
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				
				int id = res.getInt("order_id");
				int menu = res.getInt("menu_id");
				int quant = res.getInt("quantity");
				int sub = res.getInt("subtotal");
				
				ordIt = new OrdItem(id,menu,quant,sub);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ordIt;
	}

	@Override
	public void updateOrdItem(OrdItem ordIt) {
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, ordIt.getQuantity());
			pstmt.setFloat(2, ordIt.getSubtotal());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrdItem(int order_item_id) {
		
		Connection con = DBConnection.getConnection();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, order_item_id);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrdItem> getAllOrdItem() {
		Connection con = DBConnection.getConnection();
		List<OrdItem> list = new ArrayList<OrdItem>();
		OrdItem ordIt = null;
		
		try {
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery(SELECT_ALL);
			
			while(res.next()) {
				int item_id = res.getInt("order_item_id");
				int order_id = res.getInt("item_id");
				int menu_id = res.getInt("menu_id");
				int quantity = res.getInt("quantity");
				float sub = res.getFloat("subtotal");
				
				ordIt = new OrdItem(item_id, order_id, menu_id, quantity, sub);
				list.add(ordIt);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
