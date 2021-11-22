package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.simplilearn.workshop.model.Customers;
import com.simplilearn.workshop.proxy.CustomerServiceRestProxy;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerServiceRestProxy customerServiceRestProxy;
		
	@GetMapping(path = "/customers/list")
	public ModelAndView listOfCustomers() {
		List<Customers> customers = customerServiceRestProxy.retrieveCustomers(); // invoking another microservice - the rest service 
		//customers.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-customers"); // logical name
		modelAndView.addObject("customers",customers);
		modelAndView.addObject("customer",new Customers());
		return modelAndView;
	}
	
	@GetMapping(path = "/customers/searchbynameasc")
	public ModelAndView searchByCustomersAsc(@ModelAttribute("name") String name ) {
		List<Customers> customerList = customerServiceRestProxy.getByNameAsc(name); // invoking another microservice - the rest service 
		//customers.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-customers"); // logical name
		modelAndView.addObject("customerList",customerList);
		modelAndView.addObject("customers",new Customers());
		return modelAndView;
	}
	
	@GetMapping(path = "/customers/searchbynamedesc")
	public ModelAndView searchByCustomersDesc(@ModelAttribute("name") String name ) {
		List<Customers> customers = customerServiceRestProxy.getByNameDesc(name); // invoking another microservice - the rest service 
		//customers.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/customers/list"); // logical name
		modelAndView.addObject("customers",customers);
		return modelAndView;
	}
	
	
	
	@GetMapping(path = "/customers/showFormForAdd")
	public ModelAndView showFormForAddCustomer() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer-form"); // logical name
		Customers theCustomer = new Customers();
		modelAndView.addObject("customer",theCustomer);
		return modelAndView;
	}
	
	@GetMapping(path = "/customers/showFormForUpdate")
	public ModelAndView showFormForUpdateCustomer(@ModelAttribute("customerId") Integer theId ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customer-form"); // logical name
		Customers theCustomer = customerServiceRestProxy.retrieveCustomer(theId);
		modelAndView.addObject("customer",theCustomer);
		customerServiceRestProxy.updateCustomer(theId, theCustomer);
		return modelAndView;
	}
	
	@PostMapping(path="/customers/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customers theCustomer) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/customers/list"); // logical name
		customerServiceRestProxy.createCustomers(theCustomer);
		return modelAndView;
	}
	
	@GetMapping(path="/customers/delete")
	public ModelAndView deleteCustomer(@ModelAttribute("customerId") Integer theId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/customers/list"); // logical name
		customerServiceRestProxy.deleteCustomer(theId);
		return modelAndView;
	}
}
