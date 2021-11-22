package com.simplilearn.workshop.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_purchases")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Purchases {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer purchaseId;
	
	@Column(name = "product_id")
	private Integer productId;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	
	@Column(name = "purchase_date")
	private String purchaseDate;
	
	@Transient
	private List<Categories> categories;
	
	@Transient
	private Double price;
	
	
	public Purchases() {
		super();
	}
	
	public Purchases(Integer purchaseId, Integer productId, Integer customerId, String purchaseDate,
			List<Categories> categories, Double price) {
		super();
		this.purchaseId = purchaseId;
		this.productId = productId;
		this.customerId = customerId;
		this.purchaseDate = purchaseDate;
		this.categories = categories;
		this.price = price;
	}



	public Integer getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	private String setDate() {
		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
		long now = new Date().getTime();
		Date date =  new Date(now);
		String formatted = targetFormat.format(date);
		return formatted;
	}
	
	
	

}
