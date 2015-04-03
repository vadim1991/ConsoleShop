package com.epam.Vadym_Vlasenko.eShop.entity;

import com.epam.Vadym_Vlasenko.eShop.util.Parameter;

import java.io.Serializable;

public abstract class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int price;
	private static final int DEFAULT_PRICE = 0;

	protected Product() {
		this.price = DEFAULT_PRICE;
	}

	protected Product(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@Parameter(parameter = "id")
	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("ID must be greater than zero");
		}
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	@Parameter(parameter = "price")
	public void setPrice(int price) {
		if (price < 0) {
			throw new IllegalArgumentException(
					"Price must be greater than zero");
		}
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + (int) (price ^ (price >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", price=" + price + "]";
	}

}
