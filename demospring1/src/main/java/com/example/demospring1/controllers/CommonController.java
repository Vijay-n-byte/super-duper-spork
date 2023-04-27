package com.example.demospring1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.purchase;
import com.example.demospring1.repository.adminrepo;
import com.example.demospring1.service.Customersservice;
import com.example.demospring1.service.Productsservice;
import com.example.demospring1.service.purchaseservice;
import com.example.demospring1.service.sizeservice;

@Controller

public class CommonController {

	@Autowired
	private purchase p;
	
	@Autowired
	private Productsservice ps;
	
	@Autowired
	private Customersservice cs;
	
	@Autowired
	private sizeservice ss;
	
	
	@Autowired
	private purchaseservice pur;
	@Autowired
	private adminrepo ar;
	
	
	 public ModelAndView home() {
			ModelAndView l=new ModelAndView("home.html");
			return l;
		}
	 
 
 @RequestMapping(value="/home")
	 public ModelAndView gethome() {
		ModelAndView l=home();
		List<Products> p=ps.getall();
		l.addObject("loop",p);
		return l;
	}
}
