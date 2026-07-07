package com.tap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.daodes.UserDAO;
import com.tap.model.User;
import com.tap.utility.DBConnection;

public class UserDAOImpl implements UserDAO {

	// Once the connection is established used for all methods
	
	private static final String INSERT = "Insert into User(username,password,email,address,"
			+ "role,createDate, LastloginDate) VALUES(?,?,?,?,?,?,?)";
	
	private static final String SELECT = "Select * from user where userId = ?"; 
	
	private static final String SELECT_EMAIL = "Select * from user where email = ?"; 
	
	private static final String UPDATE = "Update user set username = ?, password = ?, email = ?, address = ?, role = ?, LastloginDate = ? where userId = ? ";
	
	private static final String DELETE = "Delete from user where userId = ?";
	
	private static final String SELECT_ALL = "Select * from user"; 
	
	@Override
	public int addUser(User user) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getRole());
			stmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
			stmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			
			int i = stmt.executeUpdate();
			return i;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public User getUser(int userId) {
		
		Connection con  = DBConnection.getConnection();
		User u = null; 
		try {
		PreparedStatement pstmt = con.prepareStatement(SELECT);
			
			pstmt.setInt(1,userId);
			ResultSet res = pstmt.executeQuery(); 
			
			while(res.next()) {
				int id = res.getInt("userId");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp LastloginDate = res.getTimestamp("LastloginDate");
				String number = res.getString("number");
				
				u = new User(id, username, password, email, address, role, number, createDate, LastloginDate);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	@Override
	public User getUserByEmail(String email) {
		
		Connection con  = DBConnection.getConnection();
		User u = null; 
		try {
		PreparedStatement pstmt = con.prepareStatement(SELECT_EMAIL);
			
			pstmt.setString(1,email);
			ResultSet res = pstmt.executeQuery(); 
			
			while(res.next()) {
				String mail = res.getString("email");
				String username = res.getString("username");
				String password = res.getString("password");
				String address = res.getString("address");
				String role = res.getString("role");
				String number = res.getString("number");
				
				u = new User(username, password, mail, address, role, number);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void updateUser(User user) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getRole());
			pstmt.setTimestamp(6,new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(7, user.getUserId());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteUser(int userId) {
		Connection con = DBConnection.getConnection();
		
		try {
			PreparedStatement pstmt =  con.prepareStatement(DELETE);
			
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		
		List<User> list = new ArrayList<User>();
		Connection con = DBConnection.getConnection();
		try {			
			Statement stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(SELECT_ALL);
			
			while(res.next()) {
				int userId = res.getInt("userId");
				String username = res.getString("username");
				String password = res.getString("password");
				String email = res.getString("email");
				String address = res.getString("address");
				String role = res.getString("role");
				Timestamp createDate = res.getTimestamp("createDate");
				Timestamp LastloginDate = res.getTimestamp("LastloginDate");
				String number = res.getString("number");
				
				User u = new User(userId, username, password, email, address, role, number, createDate, LastloginDate);
				list.add(u);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	
}
