package com.webcustomertracker.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webcustomertracker.spring.entity.Customer;

// apply to dao implementatiion
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", 
															Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save or update the customer
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// retrieve from database using the primary key
		Customer customer = currentSession.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query<Customer> query = currentSession.createQuery("delete from Customer where id=:customerId");
		
		query.setParameter("customerId", id);
		query.executeUpdate();
				
		
	}

}
