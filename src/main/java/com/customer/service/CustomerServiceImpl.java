package com.customer.service;

import java.util.List;
import java.util.Optional;

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
	public Customer getById(Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		Customer customer = null;
		if (optional.isPresent())
			customer = optional.get();
		else throw new RuntimeException(
				"Customer not found : " + id);
		return customer; 
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

}
