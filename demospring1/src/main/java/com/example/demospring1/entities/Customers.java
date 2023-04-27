package com.example.demospring1.entities;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@Component


@NamedQueries(value= {@NamedQuery(name="getbyusername",query="select p from Customers p where username=:a")})
public class Customers {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custid;
	private String name;
	private String address;
	private String phonenumber;
	private String adhaarno;
	private String username;
	private String password;

	public Customers( String name, String address, String phonenumber, String adhaarno, String username,
			String password) {
		super();
		this.name = name;
		this.address = address;
		this.phonenumber = phonenumber;
		this.adhaarno = adhaarno;
		this.username = username;
		this.password = password;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdhaarno() {
		return adhaarno;
	}
	public void setAdhaarno(String adhaarno) {
		this.adhaarno = adhaarno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customers [custid=" + custid + ", name=" + name + ", address=" + address + ", phonenumber="
				+ phonenumber + ", adhaarno=" + adhaarno + ", username=" + username + ", password=" + password + "]";
	}
	public Customers() {
		super();
	}
	
	


	
	
}
