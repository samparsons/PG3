package com.simplilearn.workshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping(path="/")
	public String greeting() {
		return "Hello World";
	}

}
