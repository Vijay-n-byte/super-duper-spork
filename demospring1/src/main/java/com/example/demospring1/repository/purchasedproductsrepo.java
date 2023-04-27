package com.example.demospring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demospring1.entities.ppkey;
import com.example.demospring1.entities.purchasedproducts;

public interface purchasedproductsrepo extends JpaRepository<purchasedproducts,ppkey>{

}
