package com.webcustomertracker.spring.service;

import java.util.List;

import com.webcustomertracker.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int id);
}
