package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Customer;
import com.simplilearn.workshop.proxy.CustomerServiceRestProxy;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerServiceRestProxy customerServiceRestProxy;
	
	@GetMapping(path = "/customers/list")
	public ModelAndView listOfCustomers() {
		List<Customer> customers = customerServiceRestProxy.retrieveCustomers(); // invoking another microservice - the rest service customer-service-rest
		//customers.forEach(e-> System.out.println(e.getName()));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-customers"); // logical name
		modelAndView.addObject("customers",customers);
		return modelAndView;
	}
	
	@GetMapping(path = "/customers/showFormForAdd")
	public ModelAndView showFormForAddCustomer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer-form"); // logical name
		Customer theCustomer = new Customer();
		modelAndView.addObject("customer",theCustomer);
		return modelAndView;
	}
	
	@PostMapping(path="/customers/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/customers/list"); // logical name
		customerServiceRestProxy.createCustomer(theCustomer);
		return modelAndView;
	}
	
}
