package com.epam.Vadym_Vlasenko.eShop.entity;

import com.epam.Vadym_Vlasenko.eShop.util.Parameter;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Material;

public class Ring extends Jewel {

    private static final long serialVersionUID = 1L;
    private double size;
    private Insert insert;

    public Ring() {
        super();
    }

    public Ring(int id, int price, String title, String description,
                double weight, double size, Material material, Insert insert) {
        super(id, price, title, description, weight, material);
        this.size = size;
        this.insert = insert;
    }

    public double getSize() {
        return size;
    }

    @Parameter(parameter = "size", parameterType = "double")
    public void setSize(double size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.size = size;
    }

    public Insert getInsert() {
        return insert;
    }

    @Parameter(parameter = "insert", parameterType = "enum")
    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((insert == null) ? 0 : insert.hashCode());
        long temp;
        temp = Double.doubleToLongBits(size);
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
        Ring other = (Ring) obj;
        if (insert != other.insert)
            return false;
        if (Double.doubleToLongBits(size) != Double
                .doubleToLongBits(other.size))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ring [id=" + getId() + ", size=" + size + ", insert=" + insert + ", title=" + getTitle()
                + ", price=" + getPrice() + "]";
    }

}
