package com.example.demospring1.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demospring1.entities.size;

import com.example.demospring1.repository.sizerepo;

@SpringBootTest
class sizetest {

	@Autowired
	private sizeservice s;
	
	@Autowired
	private size t;
	@Autowired
	private sizerepo sr;
	
	@Test
	void test() {
		t.setS(7);
		s.addsize(t);
		//assertEquals("SIX",t.getS());
	}

}
