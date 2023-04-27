package com.example.demospring1.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Component
@Entity
public class size {
	
	@Id
	private int s;
	
	
	@ManyToMany(mappedBy="s")
	private List<Products> p;


	public int getS() {
		return s;
	}


	public void setS(int s) {
		this.s = s;
	}


	public List<Products> getP() {
		return p;
	}


	public void setP(List<Products> p) {
		this.p = p;
	}


	@Override
	public String toString() {
	//	return "[s=" + s + "]";
		return "s="+s;
		
	}




	
	

}
