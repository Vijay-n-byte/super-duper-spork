package com.example.demospring1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospring1.entities.Customers;
import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.purchase;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class purchaserepo {
	
	@Autowired
	private EntityManager em;
	
	public void addpurchase(purchase p) {
		
		em.persist(p);
		
		
	}
	
   public void updatepurchase(purchase p) {
		
		em.merge(p);
		
		
	}
	
    public void updateproduct(purchase p) {
		System.out.print("done with image");
		em.merge(p);
	}
   
 //   @SuppressWarnings(value = { "" })
	public purchase findpurchasebycustid(int u) {
		try {
		Query q=em.createQuery("select e from purchase e where e.c.custid=:a and e.paymentstatus=0", purchase.class);
		q.setParameter("a", u);
		purchase f=(purchase) q.getSingleResult();
		return f;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	//select * from purchase where c_custid= ? and paymentstatus=0
	
	public List<Object[]> getpurchasedetails() {
		System.out.print("kkkkkkkkkk");
		Query m=em.createQuery("select p.purchaseid,p.d,p.c.custid,pp.k.productno,pp.cost,pp.quantity from purchase p inner join purchasedproducts pp on p.purchaseid=pp.k.purchaseno and p.paymentstatus=1");
		try {
		List<Object[]> l=m.getResultList();
		System.out.println(l);
		return  l;
		}
		catch(Exception e) {
			
			return null;
		}
	}
//	 select p.purchaseid,p.d,p.c,pp.k.productno,pp.cost,pp.quantity from purchase p ,purchasedproducts pp where p.purchaseid=pp.purchaseno;
	//select p.productname ,p.description,pp.cost,pp.quantity from purchasedproducts pp inner join Products p on p.productno=pp.k.productno and pp.k.purchaseno=:sep
}
