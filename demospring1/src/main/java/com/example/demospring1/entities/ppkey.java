package com.example.demospring1.entities;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import jakarta.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
@Component
public class ppkey implements Serializable{
	
    private int productno;
    private int purchaseno;
	public ppkey() {
		super();
	}
	public ppkey(int productno, int purchaseno) {
		super();
		this.productno = productno;
		this.purchaseno = purchaseno;
	}
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getPurchaseno() {
		return purchaseno;
	}
	public void setPurchaseno(int purchaseno) {
		this.purchaseno = purchaseno;
	}
	
	
	
}

