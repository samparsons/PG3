package com.simplilearn.workshop.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.model.Purchases;
import com.simplilearn.workshop.repository.PurchaseRepository;

@Service(value="purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public List<Purchases> getPurchases() {
		// TODO Auto-generated method stub
		return purchaseRepository.findAll();
	}
	
	@Override
	public List<Purchases> getByPurchasedDateAndProductId(Date date,Integer productId,String category) {
		// TODO Auto-generated method stub
		return purchaseRepository.findByPurchaseDateAndProductIdOrCategory(date,productId,category);
	}
	


	@Override
	public Purchases savePurchase(Purchases thePurchase) {
		// TODO Auto-generated method stub
		return purchaseRepository.save(thePurchase);
	}

	@Override
	public Purchases getPurchase(Integer theId) {
		// TODO Auto-generated method stub
		return purchaseRepository.getById(theId);
	}

	@Override
	public void deletePurchase(Integer theId) {
		// TODO Auto-generated method stub
		purchaseRepository.deleteById(theId);
	}
	
	

}
