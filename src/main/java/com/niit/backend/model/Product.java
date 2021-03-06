package com.niit.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="Product") // if the class name and table name is different
@Component
public class Product {

	@Id
	private String id;

	@Column(name="name")
	private String name;
	
	private double price;
	
	private String Description;
	
	@javax.persistence.Transient
	private MultipartFile file;

	private String category_id;

	private String supplier_id;
	

	@ManyToOne
	@JoinColumn(name = "category_id",updatable=false,insertable =false, nullable=false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable =false, nullable=false)
	private Supplier supplier;
		
	
	 public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
   
   
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

}