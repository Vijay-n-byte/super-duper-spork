package com.example.demospring1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demospring1.entities.Customers;
import com.example.demospring1.repository.Customers1repo;
import com.example.demospring1.repository.Customersrepo;

@Service
public class Customersservice {
	
	@Autowired
	private Customers1repo cr;
	
	public void addcustomers(Customers c) {
		cr.addcustomer(c);
	}
	public Customers getonecustomer(String c) {
		return cr.getcustomer(c);
	}
	
	public Customers getbycustomid(int y) {
		return cr.getbyid(y);
	}
	
	public List<Customers> getallcust() {
		return cr.getall();
	
	}
	

}
