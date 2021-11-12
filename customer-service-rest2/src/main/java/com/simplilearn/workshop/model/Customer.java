package com.simplilearn.workshop.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	private Integer id;
	@NotNull @Size(min=2,message="Name should have at least 2 characters")
	private String name;
	@NotNull @Size(min=5,message="Phone should have at least 5 characters")
	private String phone;
	@NotNull @Email(message = "Email field is required")
	//you can use a regex @Email(message = "Email field is required", regexp="{regex}")
	private String email;
	
	
	
	
	public Customer(Integer id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}
	
	

}
