package com.example.demospring1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demospring1.entities.Customers;

public interface Customersrepo extends JpaRepository<Customers,Integer> {

}
