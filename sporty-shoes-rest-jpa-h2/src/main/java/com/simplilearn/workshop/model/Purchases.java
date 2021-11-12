package com.simplilearn.workshop.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_purchases")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Purchases {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer purchaseId;
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Customers customer;
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Products product;

	@Column(name = "purchase_date")
	private Date purchaseDate;
		
	public Purchases(@NotNull Customers customer, @NotNull Products product) {
		super();
		this.customer = customer;
		this.product = product;
		this.purchaseDate = setDate();
	}

	public Purchases() {
		super();
	}
	
	private Date setDate() {
		long now = new Date().getTime();
		Date today =  new Date(now);
		return today;
	}
	
	
	

}
