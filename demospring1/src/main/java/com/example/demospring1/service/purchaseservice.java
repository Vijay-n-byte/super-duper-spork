package com.example.demospring1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.ppkey;
import com.example.demospring1.entities.purchase;
import com.example.demospring1.entities.purchasedproducts;
import com.example.demospring1.repository.Productsrepo1;
import com.example.demospring1.repository.purchaserepo;

@Service
public class purchaseservice {
	@Autowired
	private Productsservice i;
	@Autowired
	private purchasedproductsservice pps;
	@Autowired
	private purchasedproducts pp;
	
	@Autowired
	private ppkey k;
	
	@Autowired
	private purchaserepo pr;
	
	@Autowired
	private purchase p;
	
	
	@Autowired
	private Customersservice cs;

    public void addpurchaseone(purchase p) {
		pr.addpurchase(p);
	}
	
    public void updatepurchaseone(purchase p) {
		pr.updatepurchase(p);
	}
    
 /*   public purchase findpurchasebycustomerid(int c) {
    	System.out.println("aa");
    	p=pr.findpurchasebycustid(c);
   // 	System.out.println(p);
    	if(p==null) {
    	//	purchase p=new purchase();
    	 //	p.setC(cs.getbycustomid(c));
    	//	pr.addpurchase(p);	
    		return null;
    	}
    	System.out.println("aaaa");
    	return p;
    }*/
/*	public void saveproducts(int c,int m,int n) {
		p=findpurchasebycustomerid(c);
		System.out.println(p);
		if(p==null) {
			System.out.println("nimmilhello");
			purchase p=new purchase();
			System.out.println("hello11");
    	 	p.setC(cs.getbycustomid(c));
    	 	p.setTotalcost((long) 0);
    	 	System.out.print(p);
    		pr.addpurchase(p);
    		System.out.print("hello33");
		}
		Products pj=i.getoneproduct(m); 
		System.out.print(pj);
		k.setProductno(m);
		k.setPurchaseno(p.getPurchaseid());
		pp.setK(k);
		pp.setQuantity(n);
		pp.setCost(pj.getCost());
		pps.addelement(pp);
	}
	*/
	
	public void saveproducts(int c,int m,int n) {
		purchase p1=findpurchasebycustomerid(c);
		if(p1==null) {
			p1=new purchase();
			p1.setC(cs.getbycustomid(c));
			pr.addpurchase(p1);
			//create new purchase
		}
		//add products into the purchase object
		Products pj=i.getoneproduct(m); 
		ppkey p2=new ppkey(m,p1.getPurchaseid());
		purchasedproducts p3=new purchasedproducts(p2,n,pj.getCost());
		pps.addelement(p3);
		
	}
	public purchase findpurchasebycustomerid(int c) {
		System.out.println("testing");
   // 	System.out.println(pr.findpurchasebycustid(c));
    	return pr.findpurchasebycustid(c);
    }
	
	public List<Object[]> getpurchasedetails1(){
		return pr.getpurchasedetails();
	}

}
