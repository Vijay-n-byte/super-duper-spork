package com.example.demospring1.controllers;


import java.util.Base64;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demospring1.dto.Logindto;
import com.example.demospring1.dto.Productsdto;
import com.example.demospring1.entities.Customers;
import java.util.Map;
import java.util.Optional;

import javax.imageio.ImageIO;

import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.admin;
import com.example.demospring1.entities.purchase;
import com.example.demospring1.entities.size;
import com.example.demospring1.repository.adminrepo;
import com.example.demospring1.service.Customersservice;
import com.example.demospring1.service.Productsservice;
import com.example.demospring1.service.purchaseservice;
import com.example.demospring1.service.sizeservice;

@Controller
@SessionAttributes({"cus","yep","total"})
public class webcontroller {
	
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

	

    
    @RequestMapping(value="/adminlogin")
	 public ModelAndView adminlogin() {
		ModelAndView l=new ModelAndView("login.html");
		return l;
	}
    
    @RequestMapping(value="/home/sort")
	 public ModelAndView getsortedproducts1(@ModelAttribute(name="category") String prod) {
		ModelAndView l=new ModelAndView("home.html");
		System.out.println(ps.getsortedshoe(prod));
		List<Products> p=ps.getsortedshoe(prod);
		l.addObject("loop",p);
		return l;
	}
    
    @PostMapping(value="/home/sort1")
	 public String getsortedproductsuserhome(@ModelAttribute(name="category") String prod,Model l) {
	//	System.out.println(ps.getsortedshoe(prod));
		List<Products> p=ps.getsortedshoe(prod);
	//	l.addObject("loop",p);
		l.addAttribute("loop",p);
		return "userhome";
	}

    @PostMapping(value="/userhome")
	 public String verify(@ModelAttribute(name="lool") Customers c,Model m)  {
   	Customers y=cs.getonecustomer(c.getUsername());
   	m.addAttribute("cus", y.getCustid());
   	List<Products> p=ps.getall();
		m.addAttribute("loop", p);
		m.addAttribute("yep", y.getName());
   	return "userhome";
	}
    
 
    
    @RequestMapping(value="/home/signup")
	 public ModelAndView customersignup() {
		ModelAndView l=new ModelAndView("customersign.html");
		return l;
	}
  
    @RequestMapping(value="/products/loginpage")
	 public ModelAndView customersignupk(@ModelAttribute(name="cust") Customers c) {
		ModelAndView l=new ModelAndView("login.html");
		cs.addcustomers(c);
		return l;
		
	}
    
    @PostMapping(value="/products/logged")
	 public String customersigned(@RequestParam("username") String i,@RequestParam("password") String j,Model m) {
		ModelAndView l=new ModelAndView("login.html");
		Customers y=cs.getonecustomer(i);
		if(y!=null && j.equals(y.getPassword())) {
			System.out.print("available");
			m.addAttribute("cus", y.getCustid());
	    	List<Products> p=ps.getall();
			m.addAttribute("loop", p);
			m.addAttribute("yep", y.getName());
			return "userhome";
			
			
		}
		else {
			System.out.println("notavaialable");
			String ll="Credentials incorrect";
			m.addAttribute("loo", ll);
			return "login";
		}
	}
    
    
    @PostMapping(value="/admin/login")
	 public String adminsigned(@RequestParam("username") String i,@RequestParam("password") String j,Model m) {
		ModelAndView l=new ModelAndView("login.html");
		admin a=ar.findadmin(i);
		if(a!=null && j.equals(a.getPassword())) {
			return "redirect:/adminhome";
			
			
		}
		else {
			System.out.println("notavaialable");
			String ll="Credentials incorrect";
			m.addAttribute("loo", ll);
			return "login";
		}
	}
  
    
    @RequestMapping(value="/purchasedetails")
	 public String getpurchaseinfo(Model m) {
		System.out.print("jjjjjjjjjj");
		List<Object[]>p=pur.getpurchasedetails1();
		m.addAttribute("loo", p);
		return "purchase";
	}
    
    
    
    
    @PostMapping(value="/home/addtocart/{model}")
	 public String addproducttocart(@PathVariable("model") int h,@RequestParam("qua") int j,Model m)  {
    //v->customerno ,h->product no,j->quantity
   	int v=(int) m.getAttribute("cus");
    pur.saveproducts(v,h,j);
    String u=(String) m.getAttribute("yep");
    List<Products> p=ps.getall();
	m.addAttribute("loop", p);
	return "userhome";
	}
    
 
    
    @PostMapping(value="/home/cart")
	    public String cart(Model m)  {
   	    int v=(int) m.getAttribute("cus");
   	    System.out.println("a");
   	    p=pur.findpurchasebycustomerid(v);
   	    System.out.println("hhhhhhhhh");
   	    System.out.println(p);
   	    if(p==null) {
   	    	List<Object[]> l=null;
   	        m.addAttribute("car",l); 
   	    }
   	    else {
   	    	int y=p.getPurchaseid();
   	    	List<Object[]> l=ps.getpro(y);
   	        m.addAttribute("car",l);  
   	        m.addAttribute("total", ps.getprice(y));
   	    }
   	 return "cartdetails";
	}
    
    @PostMapping(value="/home/transaction")
	 public String transaction(Model m)  {
		return "transaction";
	}
    
    @PostMapping(value="/home/transaction/done")
	 public String transuccess(Model m)  {
   	int v=(int) m.getAttribute("cus");
   	Long vv=(Long) m.getAttribute("total");
   	LocalDateTime k=LocalDateTime.now();
   	p=pur.findpurchasebycustomerid(v);
   	p.setTotalcost(vv);
   	p.setD(k);
   	p.setPaymentstatus(1); 
   	pur.updatepurchaseone(p);
   	System.out.print(p);
	return "success";
	}
    
    @PostMapping(value="/userhomeagain")
	 public String userhomeredirect(Model m)  {
  	int v=(int) m.getAttribute("cus");
  	String v1=(String) m.getAttribute("yep");
	List<Products> p=ps.getall();
	m.addAttribute("loop", p);
	m.addAttribute("yep", v1);
	return "userhome";
	}
}
