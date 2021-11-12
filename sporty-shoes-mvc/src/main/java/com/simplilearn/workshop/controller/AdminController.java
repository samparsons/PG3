package com.simplilearn.workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Admin;
import com.simplilearn.workshop.proxy.AdminServiceRestProxy;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceRestProxy adminServiceRestProxy;
	
	@GetMapping(path = "/admins/list")
	public ModelAndView listOfAdmins() {
		List<Admin> admins = adminServiceRestProxy.retrieveAdmins(); // invoking another microservice - the rest service admin-service-rest
		//admins.forEach(e-> System.out.println(e.getName()));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-admins"); // logical name
		modelAndView.addObject("admins",admins);
		return modelAndView;
	}
	
	@GetMapping(path = "/admins/showFormForAdd")
	public ModelAndView showFormForAddAdmin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin-form"); // logical name
		Admin theAdmin = new Admin();
		modelAndView.addObject("admin",theAdmin);
		return modelAndView;
	}
	
	@GetMapping(path = "/admins/showFormForUpdate")
	public ModelAndView showFormForUpdateAdmin(@ModelAttribute("adminId") Integer theId ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin-form"); // logical name
		Admin theAdmin = adminServiceRestProxy.retrieveAdmin(theId);
		modelAndView.addObject("admin",theAdmin);
		adminServiceRestProxy.updateAdmin(theId, theAdmin);
		return modelAndView;
	}
	
	@PostMapping(path="/admins/saveAdmin")
	public ModelAndView saveAdmin(@ModelAttribute("admin") Admin theAdmin) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admins/list"); // logical name
		adminServiceRestProxy.createAdmin(theAdmin);
		return modelAndView;
	}
	
	@GetMapping(path="/admins/delete")
	public ModelAndView deleteAdmin(@ModelAttribute("adminId") Integer theId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admins/list"); // logical name
		adminServiceRestProxy.deleteAdmin(theId);
		return modelAndView;
	}
}
