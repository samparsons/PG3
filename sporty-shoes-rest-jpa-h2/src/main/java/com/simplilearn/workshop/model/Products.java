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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tbl_products")
@JsonIgnoreProperties(value={"handler","hibernateLazyInitializer","fieldHandler"})
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	@NotNull @Size(min=2,message="Name should have at least 2 characters")
	@Column(name = "product_name")
	private String name;
	
	@NotNull @Size(min=2,message="Description should have at least 2 characters")
	@Column(name = "product_description")
	private String description;
	
	@NotNull @Size(min=2,message="Price should have at least 2 values")
	@Column(name = "product_price")
	private String price;
	
	@NotNull @Size(min=2,message="Path should have at least 2 characters")
	@Column(name = "img_url")
	private String imgPathURL;

	@Column(name = "category_names")
	@OneToMany(targetEntity=Categories.class,mappedBy="product",cascade=CascadeType.ALL)
	private List<Categories> categoryNames; 
	
	@Column(name = "purchases_made")
	@OneToMany(targetEntity=Purchases.class,mappedBy="product",cascade=CascadeType.ALL)
	private List<Purchases> purchases; 
	
	public Products(@NotNull @Size(min = 2, message = "Name should have at least 2 characters") String name,
			@NotNull @Size(min = 2, message = "Description should have at least 2 characters") String description,
			@NotNull @Size(min = 2, message = "Price should have at least 2 values") String price,
			@NotNull @Size(min = 2, message = "Path should have at least 2 characters") String imgPathURL) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgPathURL = imgPathURL;
		categoryNames = new ArrayList<Categories>();
		purchases = new ArrayList<Purchases>();
	}
	
	public Products() {
		super();
	}
	public List<Purchases> getPurchases() {
		return purchases;
	}
	public void setPurchases(Purchases purchase) {
		purchases.add(purchase);
	}
	public void setImgPathURL(String imgPathURL) {
		this.imgPathURL = imgPathURL;
	}
	
	public String getImgPathURL() {
		return imgPathURL;
	}

	public List<Categories> getCategories() {
		return categoryNames;
	}
	public void setCategories(Categories category) {
		categoryNames.add(category);
	}
	
	public void setAllCategories(ArrayList<Categories> categories) {
		this.categoryNames = categories;
	}
	
	public Integer getId() {
		return productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [id=" + productId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imgPathURL=" + imgPathURL + ", categories=" + categoryNames + ", purchases=" + purchases + "]";
	}
}
