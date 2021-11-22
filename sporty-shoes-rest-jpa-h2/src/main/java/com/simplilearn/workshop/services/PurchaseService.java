package com.simplilearn.workshop.services;

import java.util.Date;
import java.util.List;

import com.simplilearn.workshop.model.Purchases;

public interface PurchaseService {
	
	
	public List<Purchases> getPurchases();
	List<Purchases> getByPurchasedDateAndProductId(Date date,Integer productId,String category);
	public Purchases savePurchase(Purchases thePurchase);
	public Purchases getPurchase(Integer theId);
	public void deletePurchase(Integer theId);

}
