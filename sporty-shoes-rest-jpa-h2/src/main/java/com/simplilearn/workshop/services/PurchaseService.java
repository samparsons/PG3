package com.simplilearn.workshop.services;

import java.util.Date;
import java.util.List;

import com.simplilearn.workshop.model.Purchases;

public interface PurchaseService {
	
	
	public List<Purchases> getPurchases();
	List<Purchases> getByPurchasedDate(String date);
	public Purchases savePurchase(Purchases thePurchase);
	public Purchases getPurchase(Integer theId);
	public void deletePurchase(Integer theId);

}
