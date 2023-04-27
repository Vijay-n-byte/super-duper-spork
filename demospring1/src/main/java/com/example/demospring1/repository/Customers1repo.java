package com.example.demospring1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospring1.entities.Customers;
import com.example.demospring1.entities.Products;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
@Transactional
public class Customers1repo {

	@Autowired
	private EntityManager em;
	
	public void addcustomer(Customers c) {
		System.out.println("added");
		em.persist(c);
	}
	
	public Customers getcustomer(String h) {
		Customers l;
		try {
		Query q=em.createNamedQuery("getbyusername", Customers.class);
		q.setParameter("a", h);
	
		l=(Customers) q.getSingleResult();
		}
		catch(Exception e) {
			l=null;
		}
		return l;	
	}
	
	public Customers getbyid(int g) {
		return em.find(Customers.class,g );
	}
	
	public List<Customers> getall() {
		List<Customers> l;
		try {
		Query q=em.createQuery("select e from Customers e", Customers.class);
		l=q.getResultList();
		}
		catch(Exception e) {
			l=null;
		}
		return l;	
	}
	
	
	
}
