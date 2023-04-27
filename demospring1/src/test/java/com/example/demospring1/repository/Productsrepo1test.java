package com.example.demospring1.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Productsrepo1test {
	@Autowired
	private Productsrepo1 pr;

	@Test
	void test() {
	
		Long u=pr.gettotalprice(1);
		assertEquals(1900,u);
	}

}
