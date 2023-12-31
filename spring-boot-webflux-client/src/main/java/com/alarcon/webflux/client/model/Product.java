package com.alarcon.webflux.client.model;

import java.util.Date;

import io.micrometer.common.lang.NonNull;

public class Product {
	private String id;
	
	@NonNull
	private String name;
	@NonNull
	private Double price;
	
	private Date createAt;
	private String photo;
	@NonNull
	private Category category;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", createAt=" + createAt + ", photo="
				+ photo + ", category=" + category + "]";
	}

	
}
