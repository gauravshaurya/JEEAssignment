package com.portal.models;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String gender,email,password,city,role;
	
	public Customer() {
		
	}
	
	
	public Customer(int customerId, String customerName, String gender, String email, String password, String city,
			String role) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.city = city;
		this.role = role;
	}

	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", city=" + city + ", role=" + role + "]";
	}
	
	

}
