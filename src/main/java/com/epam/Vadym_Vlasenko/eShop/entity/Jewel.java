package com.epam.Vadym_Vlasenko.eShop.entity;

import com.epam.Vadym_Vlasenko.eShop.util.Parameter;

public abstract class Jewel extends Product {

	private static final long serialVersionUID = 1L;
	private Material material;
	private String title;
	private String description;
	private double weight;

	protected Jewel() {
		super();
	}

	protected Jewel(int id, int price, String title, String description,
			double weight, Material material) {
		super(id, price);
		this.material = material;
		this.title = title;
		this.description = description;
		this.weight = weight;
	}

	public Material getMaterial() {
		return material;
	}

	@Parameter(parameter = "material")
	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getTitle() {
		return title;
	}

	@Parameter(parameter = "title")
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	@Parameter(parameter = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	@Parameter(parameter = "weight")
	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		long temp;
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jewel other = (Jewel) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (material != other.material)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (Double.doubleToLongBits(weight) != Double
				.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Jewel [material=" + material + ", title=" + title
				+ ", description=" + description + ", weight=" + weight + "]";
	}

}
