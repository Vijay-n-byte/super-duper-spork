package com.example.demospring1.controllers;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demospring1.dto.Productsdto;
import com.example.demospring1.entities.Customers;
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

public class AdminController {

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
	
	@RequestMapping(value="/adminhome")
	 public String getproductlist(Model l) {
		
			List<Products> p=ps.getall();
			l.addAttribute("loop", p);
			System.out.println("aaa");
			return "kooo";
	}
	
	@RequestMapping(value="/adminhome/customers")
	 public String getcustomerslist(Model l) {
		
			List<Customers> p=cs.getallcust();
			l.addAttribute("loop", p);
			System.out.println("aaa");
			return "customers";
	}
	
	

	@PostMapping(value="/deleteproducts/{id}")
	 public String deleteproducts(@PathVariable("id") int i,Model l) {
		 ps.deleteproducts(i);
			return "redirect:/adminhome";
	}
	
	
	
	@RequestMapping(value="/adminhome/addproducts")
	 public String addproducts(Model m) {
		
		m.addAttribute("loo", new Productsdto());
			return "addproducts";
	}
	
	@PostMapping(value="/adminhome/addproducts/added")
	 public String addedproducts(@ModelAttribute("loo") Productsdto pd ,@RequestParam("image") MultipartFile f,Model j) throws IOException {
		
		System.out.print(pd);
		Products pp=new Products();
		pp.setProductname(pd.getProductname());
		pp.setDescription(pd.getDescription());
		pp.setCategory(pd.getCategory());
		pp.setCost(pd.getCost());
		if(!f.isEmpty()) {
			byte[] y=f.getBytes();
			
			String ii=Base64.getEncoder().encodeToString(y);
		    String h="data:image/jpeg;base64,"+ii;
		    
			System.out.println(h);
			pp.setImg(h);
		}
		ps.addproducts(pp);
	
		return "redirect:/adminhome/addproducts";
	}

	
	@PostMapping(value="/setproductsize/{id}")
	 public String setsize(@PathVariable("id") int i,@RequestParam("size") int k,Model l) {
		System.out.print("jjjjjjjjj");
		Products t=ps.getoneproduct(i);
		Optional<size> r=ss.getsize(k);
		size e;
		if(r.isEmpty()) {
			e=new size();
			e.setS(k);
			ss.addsize(e);
		}
		else {
			e=r.get();
		}
		t.getS().add(e);
		ps.addproducts(t);
		return "redirect:/adminhome";
	}
	
	@PostMapping(value="/updateproducts/{id}")
	 public String updateproducts(@PathVariable("id") int i,Model l) {
		System.out.print("jjjjjjjjj");
		Products n=ps.getoneproduct(i);
		Productsdto ptd=new Productsdto();
		ptd.setProductno(n.getProductno());
		ptd.setProductname(n.getProductname());
		ptd.setCost(n.getCost());
		ptd.setDescription(n.getDescription());
		ptd.setCategory(n.getCategory());
		System.out.println(ptd);
		l.addAttribute("pp", ptd);
		//l.addAttribute("pl", new Productsdto());
		return "updateproduct";
	}
	
	@PostMapping(value="/adminhome/updateproducts/updated")
	 public String updatedproducts(@ModelAttribute("pl") Productsdto pd ,@RequestParam("image") MultipartFile f,Model j) throws IOException {
		
		System.out.print(pd);
		System.out.println("ooooooooooooooooo");
		System.out.println(pd.getProductno());
		
		Products pp=ps.getoneproduct(pd.getProductno());
		pp.setProductname(pd.getProductname());
		pp.setDescription(pd.getDescription());
		pp.setCategory(pd.getCategory());
		pp.setCost(pd.getCost());
		if(!f.isEmpty()) {
			byte[] y=f.getBytes();
			System.out.print(y.length);
		//	pp.setImg(y);
		}
		ps.updateproducts(pp);
		return "redirect:/adminhome";
	}
	
	
	@RequestMapping(value="/chengepassword")
	 public ModelAndView adminpasswordchange() {
		ModelAndView l=new ModelAndView("adminpass.html");
		admin a=ar.findadmin("admin");
		l.addObject("loo", a);
		return l;
	}
   
   @PostMapping(value="/admin/changepass")
	 public String adminpasswordchanged(@RequestParam("newpass") String j) {
		System.out.print("jjjjjjjjjj");
		admin a=ar.findadmin("admin");
		a.setPassword(j);
		ar.updateadmin(a);
		return "redirect:/adminhome";
	}

}
