package com.tap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.daodes.OrdersDAO;
import com.tap.model.Orders;
import com.tap.utility.DBConnection;

public class OrderDAOImpl implements OrdersDAO {

	private static final String INSERT = "Insert into Orders( user_id, restaurant_id, order_date, total_amount)"
			+ "values( user_id = ?. restaurant_id = ?, order_date = ?, total_amount = ?)";
	
	private static final String SELECT = "Select user_id, restaurant_id, order_date, total_amount from Orders where order_id = ?";
	
	private static final String UPDATE = "Update Orders set total_amount = ? where order_id = ?";
	
	private static final String DELETE = "Delete Orders where order_id = ?";
	
	private static final String SELECT_ALL = "Select * from Orders";

	@Override
	public void addOrder(Orders ord) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, ord.getOrder_id());
			pstmt.setInt(2, ord.getRestaurant_id());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setDouble(4, ord.getTotal_amount());
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Orders getOrder(int order_id) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.getConnection();
		Orders ord = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(SELECT);
			pstmt.setInt(1, order_id);
			
			pstmt.executeUpdate();
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int id = res.getInt("user_id");
				int rid = res.getInt("restaurant_id");
				Timestamp date = res.getTimestamp("order_date");
				double tot_amt = res.getDouble("total_amount");
				
				ord = new Orders(id,rid,date,tot_amt);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ord;
		
	}

	@Override
	public void updateOrder(Orders ord) {
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setDouble(1, ord.getTotal_amount());
			pstmt.setInt(2, ord.getOrder_id());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int order_id) {
		
		Connection con = DBConnection.getConnection();
		try {
			
			PreparedStatement pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, order_id);
			
			pstmt.executeUpdate();
			System.out.println("Deleted....");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Orders> getAllOrders() {
		
		Connection con = DBConnection.getConnection();
		Orders ord = null;
		List<Orders> list = new ArrayList<Orders>();
		
		try {
			
			Statement pstmt = con.createStatement();
	
			ResultSet res = pstmt.executeQuery(SELECT_ALL);
			
			while(res.next()) {
				int oid = res.getInt("order_id");
				int id = res.getInt("user_id");
				int rid = res.getInt("restaurant_id");
				Timestamp date = res.getTimestamp("order_date");
				double tot_amt = res.getDouble("total_amount");
				
				ord = new Orders(oid,id,rid,date,tot_amt);
				list.add(ord);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
