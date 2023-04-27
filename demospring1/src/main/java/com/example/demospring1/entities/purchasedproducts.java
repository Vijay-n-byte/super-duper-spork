package com.example.demospring1.entities;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AssociationOverrides;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
@Component
public class purchasedproducts {
	
	@EmbeddedId
	private ppkey k;
	private int quantity;
	private int cost;
	public purchasedproducts(ppkey k, int quantity, int cost) {
		super();
		this.k = k;
		this.quantity = quantity;
		this.cost = cost;
	}
	public purchasedproducts() {
		super();
	}
	public ppkey getK() {
		return k;
	}
	public void setK(ppkey k) {
		this.k = k;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "purchasedproducts [k=" + k + ", quantity=" + quantity + ", cost=" + cost + "]";
	}
	
	
	
	
}
