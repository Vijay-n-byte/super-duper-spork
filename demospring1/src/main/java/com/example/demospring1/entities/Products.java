package com.example.demospring1.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Data
@Entity
@Component
@NamedQueries(value= {@NamedQuery(name="sortbycategory",query="select p from Products p where category =:a")})
//@NamedNativeQuery(name="sortbycategory",query="select * from products where category =?",resultClass=Products.class)
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productno;
	private String productname;
	private String description;
	private int cost;
	private String category;
/*	
	@Lob
	@Column(length=80000)
	private byte[] img;*/
	
	private String img;
	 
	@ManyToMany
	private List<size> s;

	public Products() {
		super();
	}

	public Products(String productname, String description, int cost, String category, String img, List<size> s) {
		super();
		this.productname = productname;
		this.description = description;
		this.cost = cost;
		this.category = category;
		this.img = img;
		this.s = s;
	}

	public int getProductno() {
		return productno;
	}

	public void setProductno(int productno) {
		this.productno = productno;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<size> getS() {
		return s;
	}

	public void setS(List<size> s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return "Products [productno=" + productno + ", productname=" + productname + ", description=" + description
				+ ", cost=" + cost + ", category=" + category + ", img=" + img + ", s=" + s + "]";
	}

	
	
	
	
	
	

}
