package com.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.customer.model.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) { //review input params 
		// TODO Auto-generated method stub
		return customerRepository.save(customer); 
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		// TODO Auto-generated method stub
		customer.setFirstName(customer.getFirstName());
		customer.setLastName(customer.getLastName());
		
		
		
		return null;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		
	}

	
	}


