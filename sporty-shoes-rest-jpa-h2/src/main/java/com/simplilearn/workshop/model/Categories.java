package com.simplilearn.workshop.model;

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
@Table(name="tbl_categories")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Categories {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;
	
	
	@NotNull
	@Column(name = "product_id")
	private Integer productId;
	
	@NotNull
	@Column(name = "category_name")
	private String categoryName;
	
	public Categories() {
		super();
	}
	
	public Categories(Integer categoryId, @NotNull Integer productId, @NotNull String categoryName) {
		super();
		this.categoryId = categoryId;
		this.productId = productId;
		this.categoryName = categoryName;
	}
	
	public Categories(@NotNull Integer productId, @NotNull String categoryName) {
		super();
		this.productId = productId;
		this.categoryName = categoryName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getCategory() {
		return categoryName;
	}

	public void setCategory(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getId() {
		return categoryId;
	}

	public void setId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	

}
