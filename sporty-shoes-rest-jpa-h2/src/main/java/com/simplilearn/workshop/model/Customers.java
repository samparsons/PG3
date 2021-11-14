package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_customers")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Customers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotNull @Size(min=2,message="Name should have at least 2 characters")
	@Column(name = "name")
	private String name;
	@NotNull @Size(min=5,message="Phone should have at least 5 characters")
	@Column(name = "phone")
	private String phone;
	@NotNull @Email(message = "Email field is required")
	@Column(name = "email")
	//you can use a regex @Email(message = "Email field is required", regexp="{regex}")
	private String email;
	
	@NotNull @Size(min=2,message = "Username should have at least 2 characters")
	@Column(name = "username")
	private String username;
	
	@NotNull @Size(min=2,message = "Password should have at least 2 characters")
	@Column(name = "password")
	private String password;
	
	/*
	 * @OneToMany(mappedBy="customer",cascade=CascadeType.ALL) private
	 * List<Purchases> purchases;
	 */
	
	public Customers() {
		super();
	}
	
	public Customers(Integer id, @NotNull @Size(min = 2, message = "Name should have at least 2 characters") String name,
			@NotNull @Size(min = 5, message = "Phone should have at least 5 characters") String phone,
			@NotNull @Email(message = "Email field is required") String email,
			@NotNull @Size(min = 2, message = "Username should have at least 2 characters") String username,
			@NotNull @Size(min = 2, message = "Password should have at least 2 characters") String password) {
		super();
		this.id = id;
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
		return "Admins [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", username="
				+ username + ", password=" + password + "]";
	}
	
	
	
	
	

}
