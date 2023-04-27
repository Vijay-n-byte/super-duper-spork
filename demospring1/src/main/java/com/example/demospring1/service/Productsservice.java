package com.example.demospring1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.purchasedproducts;
import com.example.demospring1.entities.size;

import com.example.demospring1.repository.Productsrepo1;

@Service
public class Productsservice {
	
	@Autowired
	private Productsrepo1 pr;

    public void addproducts(Products p) {
		pr.addproduct(p);
	}
    
    public void updateproducts(Products p) {
    	pr.updateproduct(p);
	}
    
    public void deleteproducts(int p) {
		pr.deleteById(p);
		System.out.print("deleted");
	}
    
    public List<Products> getall(){
    	
    	return pr.getall();
    }
    
    public Products getoneproduct(int h){
    	
    	return pr.findproduct(h);
    }
    
     
   public List<Products> getsortedshoe(String gender){
    	
	   return pr.getsortedshoes(gender);
    	
    }
    public List<Object[]> getpro(int k) {
    	return pr.getproductsmarked(k);
    }
    
    public Long getprice(int m) {
    	return pr.gettotalprice(m);
    }
  
    
   
	
}
