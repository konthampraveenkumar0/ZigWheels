package com.zigwheels.models;

public class Bike 
{
	private String Name;
	private String Exp_date;
	private double price;
	
	public Bike(String name,double price, String exp_date) {
		
		Name = name;
		Exp_date = exp_date;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Bike [Name=" + Name + ", Exp_date=" + Exp_date + ", price=" + price + "]";
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getExp_date() {
		return Exp_date;
	}
	public void setExp_date(String exp_date) {
		Exp_date = exp_date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
