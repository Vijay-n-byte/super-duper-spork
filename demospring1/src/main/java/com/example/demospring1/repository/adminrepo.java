package com.example.demospring1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demospring1.entities.admin;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class adminrepo {
	
	@Autowired
	private EntityManager em;
	
    public admin findadmin(String p) {
		
		return em.find(admin.class, p);
	}
    
   public void updateadmin(admin p) {
		em.merge(p);
	}
    
    
	

}
