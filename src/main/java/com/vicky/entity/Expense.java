package com.vicky.entity;

//import java.sql.Date;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "EXPENSE")
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "TRANTYPE")
	private String tranType;

	@Column(name = "CATEGORY")
	private String category;

	@Column(name = "SUBCATEGORY")
	private String subCategory;

	@Column(name = "AMOUNT")
	private Double amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	
	public Expense(Integer id, Date date, String tranType, String category, String subCategory, Double amount) {
		super();
		this.id = id;
		this.date = date;
		this.tranType = tranType;
		this.category = category;
		this.subCategory = subCategory;
		this.amount = amount;
	}

	public Expense() {
		super();
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", date=" + date + ", tranType=" + tranType + ", category=" + category
				+ ", subCategory=" + subCategory + ", amount=" + amount + "]";
	}
	
	

}
