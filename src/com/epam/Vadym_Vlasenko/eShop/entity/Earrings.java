package com.epam.Vadym_Vlasenko.eShop.entity;

import com.epam.Vadym_Vlasenko.eShop.util.Parameter;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Material;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class Earrings extends Jewel {

    private Insert insert;

    public Earrings() {
        super();
    }

    public Earrings(int id, int price, String title, String description, double weight, Material material, Insert insert) {
        super(id, price, title, description, weight, material);
        this.insert = insert;
    }

    public Insert getInsert() {
        return insert;
    }

    @Parameter(parameter = "insert", parameterType = "enum")
    public void setInsert(Insert insert) {
        this.insert = insert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Earrings earrings = (Earrings) o;

        if (insert != earrings.insert) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (insert != null ? insert.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Earrings{ id=" + getId() + " , price=" + getPrice() + " , title=" + getTitle() +
                " ,insert=" + insert +
                '}';
    }
}
