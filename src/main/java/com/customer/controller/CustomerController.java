package com.customer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.customer.model.Customer;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {

	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("allcutomerlist", customerService.getAllCustomers());
		return "home";
	}
	
	@PostMapping("/addnew")
	public String addNewCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "newcustomer";
	}
	
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		 customerService.saveCustomer(customer);
		 return "redirect:/";
	}
	@GetMapping("/showCustomerUpdate/{id}")
	public String updateCustomer(@PathVariable(value = "id") long id, Model model) {
		Customer customer = customerService.getById(id);
		model.addAttribute("customer", customer);
		return "update";
	}
	
	public String deleteCustomer(@PathVariable(value = "id") long id) {
		customerService.deleteById(id);
		
		return "redirect:/";
	}
}
