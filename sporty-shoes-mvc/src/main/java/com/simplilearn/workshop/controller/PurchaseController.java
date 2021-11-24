package com.simplilearn.workshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.workshop.model.Purchases;
import com.simplilearn.workshop.proxy.CategoryServiceRestProxy;
import com.simplilearn.workshop.proxy.PurchaseServiceRestProxy;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseServiceRestProxy purchaseServiceRestProxy;
	
	@Autowired
	private CategoryServiceRestProxy categoryServiceRestProxy;
	
	@GetMapping(path = "/purchases/list")
	public ModelAndView listOfPurchases() {
		List<Purchases> purchases = purchaseServiceRestProxy.retrievePurchases(); // invoking another microservice - the rest service 
		//purchases.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-purchases"); // logical name
		modelAndView.addObject("purchases",purchases);
		return modelAndView;
	}
	
	@GetMapping(path = "/purchases/showFormForAdd")
	public ModelAndView showFormForAddPurchase() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("purchase-form"); // logical name
		Purchases thePurchase = new Purchases();
		modelAndView.addObject("purchase",thePurchase);
		return modelAndView;
	}
	
	@GetMapping(path = "/purchases/searchByDateAndCategory")
	public ModelAndView searchByDateAndCategory(@RequestParam("date") String date,@RequestParam("category") String category ) {
		//System.out.println("Purchase Controller");
		//System.out.println(date);
		//System.out.println(category);
		List<Purchases> purchases = purchaseServiceRestProxy.getByPurchasedDate(date,category);
		//purchases.forEach(e-> System.out.println(e));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-purchases"); // logical name
		modelAndView.addObject("purchases",purchases);
		return modelAndView;
	}
	
	@GetMapping(path = "/purchases/showFormForUpdate")
	public ModelAndView showFormForUpdatePurchase(@ModelAttribute("purchaseId") Integer theId ) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("purchase-form"); // logical name
		Purchases thePurchase = purchaseServiceRestProxy.retrievePurchase(theId);
		modelAndView.addObject("purchase",thePurchase);
		purchaseServiceRestProxy.updatePurchase(theId, thePurchase);
		return modelAndView;
	}
	
	@PostMapping(path="/purchases/savePurchase")
	public ModelAndView savePurchase(@ModelAttribute("purchase") Purchases thePurchase) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/purchases/list"); // logical name
		purchaseServiceRestProxy.createPurchases(thePurchase);
		return modelAndView;
	}
	
	@GetMapping(path="/purchases/delete")
	public ModelAndView deletePurchase(@ModelAttribute("purchaseId") Integer theId) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/purchases/list"); // logical name
		purchaseServiceRestProxy.deletePurchase(theId);
		return modelAndView;
	}
}
