package com.example.demospring1.dto;

public class Productsdto {
	private int productno;
	private String productname;
	private String description;
	private int cost;
	private String category;
	public Productsdto(int productno,String productname, String description, int cost, String category) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.description = description;
		this.cost = cost;
		this.category = category;
	}
	public Productsdto() {
		super();
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
	}

	@Override
	public String toString() {
		return "Productsdto [productno=" + productno + ", productname=" + productname + ", description=" + description
				+ ", cost=" + cost + ", category=" + category + "]";
	}
}
