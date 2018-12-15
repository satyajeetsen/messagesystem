package com.java.product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Product {

	private String name;
	private double price;



	Map<String,Double> itempricemap = new HashMap<String,Double>();


	public Product(){

	}
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public Map<String, Double> getItempricemap() {
		return itempricemap;
	}

	public void setItempricemap(Map<String, Double> itempricemap) {
		this.itempricemap = itempricemap;
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

	@Override
	public String toString() {
		return "Product{" +
				"name='" + name + '\'' +
				", price=" + price +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product)) return false;
		Product product = (Product) o;
		return Double.compare(product.price, price) == 0 &&
				name.equals(product.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name,price);
	}
}