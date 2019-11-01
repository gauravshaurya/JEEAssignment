package com.portal.daosimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.portal.daos.CustomerDao;
import com.portal.models.Customer;
import com.portal.utility.ConnectionProvider;

public class CustomerDaoImpl implements CustomerDao {
	
	Connection conn=ConnectionProvider.getConn();
	
	@Override
	public boolean registerCustomer(Customer cObj) {
		try {
		PreparedStatement ps=conn.prepareStatement("insert into CustomerTab values(customerseq.nextval,?,?,?,?,?,'customer')");
		ps.setString(1, cObj.getCustomerName());
		ps.setString(2, cObj.getGender());
		ps.setString(3, cObj.getEmail());
		ps.setString(4, cObj.getPassword());
		ps.setString(5, cObj.getCity());
		
		int i=ps.executeUpdate();
		if(i!=0) {
			return true;
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Customer loginCustomer(int customerId, String password) {
		try {
		PreparedStatement ps=conn.prepareStatement("select * from CustomerTab where CustomerId=? and Password=?");
		ps.setInt(1,customerId);
		ps.setString(2, password);
		
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			Customer cObj=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			return cObj;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from CustomerTab where role='customer'");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Customer cObj=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				customerList.add(cObj);
				
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}

}
