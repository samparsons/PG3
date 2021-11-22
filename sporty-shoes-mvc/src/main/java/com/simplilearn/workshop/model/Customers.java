package com.simplilearn.workshop.model;

public class Customers {
	private Integer id;
	private String name;
	private String phone;
	//you can use a regex @Email(message = "Email field is required", regexp="{regex}")
	private String email;
	private String username;
	private String password;
	//private List<Purchases> purchases; 
	
	public Customers() {
		super();
	}
	
	public Customers(String name, String phone, String email, String username, String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		//purchases = new ArrayList<Purchases>();
	}
	
	/*
	 * public List<Purchases> getPurchasees() { return purchases; }
	 * 
	 * public void setPurchasees(Purchases purchase) { purchases.add(purchase); }
	 */

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
		return "Customers [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	

	
	
	
	
	
	

}
