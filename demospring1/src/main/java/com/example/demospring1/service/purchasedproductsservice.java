package com.example.demospring1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring1.entities.purchasedproducts;
import com.example.demospring1.repository.purchasedproductsrepo;

@Service
public class purchasedproductsservice {
	
	@Autowired
	private purchasedproductsrepo ppr;
	
	public void addelement(purchasedproducts pp) {
		ppr.save(pp);
		
	}

}
