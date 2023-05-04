package com.bth3.laptop;

import java.util.Date;

public class Laptop {
	private int id;
	private String name;
	private Date date;
	private String brand;
	private boolean sold;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public boolean isSold() {
		return sold;
	}
	public void setSold(boolean sold) {
		this.sold = sold;
	}
	public Laptop(int id, String name, Date date, String brand, boolean sold) {
		this.id = id;
		this.name = name;
		this.date = date;
		this.brand = brand;
		this.sold = sold;
	}
	public Laptop() {
		super();
		
	}


}
