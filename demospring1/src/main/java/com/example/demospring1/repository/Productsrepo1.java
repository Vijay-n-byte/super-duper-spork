package com.example.demospring1.repository;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospring1.entities.Products;
import com.example.demospring1.entities.purchasedproducts;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class Productsrepo1 {
	
	@Autowired
	private EntityManager em;
	
	public void addproduct(Products p) {
		
		em.persist(p);
	}
	public void deleteById(int j) {
		em.remove(findproduct(j));
	}
	
	
    public void updateproduct(Products p) {
   
		em.merge(p);
	}
    public Products findproduct(int p) {
		
		return em.find(Products.class,p);
	}
    
    
	
	
	public List<Products> getall(){
	String g="select * from products";
	Query q=	em.createNativeQuery(g, Products.class);
  	
	List<Products> l=q.getResultList();
  	return l;
  	
  }
	
	public List<Products> getsortedshoes(String h){
		
		//type 1:named native query
	/*	Query q=em.createNamedQuery("sortbycategory", Products.class);
		q.setParameter(1, h);
		List<Products> l=q.getResultList();
		System.out.print(q.getResultList());
	  	return l;*/
		
		//type 2:named jpql query
		Query q=em.createNamedQuery("sortbycategory", Products.class);
		q.setParameter("a", h);
		List<Products> l=q.getResultList();
		return l;
		
	//type 3:create native query
	/*	String g="select * from products where category= ? ";
		Query q=	 em.createNativeQuery(g, Products.class);
		q.setParameter(1, h);
		List l=q.getResultList();
		System.out.print(l);
	  	return l;
	  	*/
	  	
	  	
	  }
	
	
	public List<Object[]> getproductsmarked(int y) {
		System.out.println(y);
		System.out.print("kkkkkkkkkk");
		Query m=em.createQuery("select p.productname ,p.description,pp.cost,pp.quantity from purchasedproducts pp inner join Products p on p.productno=pp.k.productno and pp.k.purchaseno=:sep");
		m.setParameter("sep", y);
		//m.setParameter(1, y);
		List<Object[]> l=m.getResultList();
//select p.productname ,p.description,pp.cost,pp.quantity from purchasedproducts pp inner join products p on p.productno=pp.productno and pp.purchaseno=2;
	  	return  l;
	}
	

	
	
	public Long gettotalprice(int j) {		
		Query q=em.createQuery("select sum(p.cost*p.quantity) from purchasedproducts p where p.k.purchaseno=:a", purchasedproducts.class);
		q.setParameter("a", j);
		Long l=(Long) q.getSingleResult();
		return l;
	}
	
//	select sum(cost*quantity) from purchasedproducts where purchaseno=54;
}
