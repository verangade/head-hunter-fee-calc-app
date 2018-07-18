package com.testsoft.feecalc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="head_hunter")
public class HeadHunter {

	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private int phone;
	
	
	
	public HeadHunter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HeadHunter(Long id, String firstName, String lastName, int phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "HeadHunter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ "]";
	}
	
	
	
	
}
