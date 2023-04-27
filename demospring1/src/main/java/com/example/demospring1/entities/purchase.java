package com.example.demospring1.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Component
public class purchase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int purchaseid;
	
	@Nullable
	private Long totalcost;
	@Nullable
	private int paymentstatus;
	
	private LocalDateTime d;
	
	@ManyToOne
	@JoinColumn
	private Customers c;

	public purchase() {
		super();
	}

	public purchase(Long totalcost, int paymentstatus, LocalDateTime d, Customers c) {
		super();
		this.totalcost = totalcost;
		this.paymentstatus = paymentstatus;
		this.d = d;
		this.c = c;
	}

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public Long getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(Long totalcost) {
		this.totalcost = totalcost;
	}

	public int getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public LocalDateTime getD() {
		return d;
	}

	public void setD(LocalDateTime d) {
		this.d = d;
	}

	public Customers getC() {
		return c;
	}

	public void setC(Customers c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "purchase [purchaseid=" + purchaseid + ", totalcost=" + totalcost + ", paymentstatus=" + paymentstatus
				+ ", d=" + d + ", c=" + c + "]";
	}
	
	

	
	

}
