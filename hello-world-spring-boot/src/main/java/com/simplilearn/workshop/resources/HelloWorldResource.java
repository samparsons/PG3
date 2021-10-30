package com.simplilearn.workshop.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * @Controller public class HellowWorldResource {
 * 
 * @RequestMapping(path="/hello", method=RequestMethod.GET)
 * public @ResponseBody String hello() { return "Hello World!"; }
 * 
 * }
 */

//below is the preferred method as it is cleaner.

@RestController
public class HelloWorldResource {
	  @GetMapping(path="/hello")
	 public String hello(@RequestParam(value="name",defaultValue="World") String name  ) { 
		  return String.format("Hello "+name); 
	 }
}