package com.tap.model;

import java.sql.Timestamp;

public class User {

	private int userId;
	private String username;
	private String password;
	private String email;
	private String address;
	private String role;
	private String number;
	private Timestamp createDate;
	private Timestamp LastloginDate;
	
	public User() {
		
	}
	
	
		
	public User(int userId, String username, String password, String email, String address, String role, String number,
			Timestamp createDate, Timestamp lastloginDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
		this.number = number;
		this.createDate = createDate;
		LastloginDate = lastloginDate;
	}
		
		public User(String username, String password, String email, String address, String role, String number) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.address = address;
			this.role = role;
			this.number = number;
		}


		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Timestamp getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Timestamp createDate) {
			this.createDate = createDate;
		}

		public Timestamp getLastloginDate() {
			return LastloginDate;
		}

		public void setLastloginDate(Timestamp LastloginDate) {
			this.LastloginDate = LastloginDate;
		}

		
		public String getNumber() {
			return number;
		}


		public void setNumber(String number) {
			this.number = number;
		}


		
		@Override
		public String toString() {
			return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", address=" + address + ", role=" + role + ", number=" + number + ", createDate=" + createDate
					+ ", LastloginDate=" + LastloginDate + "]";
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getUserId() {
			return userId;
			
		}
		
		

}
