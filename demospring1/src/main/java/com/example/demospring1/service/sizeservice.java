package com.example.demospring1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demospring1.entities.size;

import com.example.demospring1.repository.sizerepo;
@Component
@Service
public class sizeservice {
	
	@Autowired
	private sizerepo sr;
	
	public void addsize(size s) {
		sr.save(s);
	}
	public Optional<size> getsize(int s) {
		return sr.findById(s);
	//	return sr.getById(s);
	}
	
	

}
