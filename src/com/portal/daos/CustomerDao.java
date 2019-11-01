package com.portal.daos;

import java.util.List;
import com.portal.models.Customer;

public interface CustomerDao {
	
	public boolean registerCustomer(Customer cObj);
	public Customer loginCustomer(int customerId,String password);
	public List<Customer> getAllCustomers();
}
