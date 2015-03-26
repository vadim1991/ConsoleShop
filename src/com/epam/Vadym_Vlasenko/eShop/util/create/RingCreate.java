package com.epam.Vadym_Vlasenko.eShop.util.create;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Material;
import com.epam.Vadym_Vlasenko.eShop.entity.Ring;
import com.epam.Vadym_Vlasenko.eShop.util.Input.Input;
import com.epam.Vadym_Vlasenko.eShop.util.Util;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

/**
 * Created by Вадим on 24.03.2015.
 */
public class RingCreate extends AbstractCreateProduct {

    public RingCreate(AbstractCreateProduct createProduct, Input input) {
        super(new EarringsCreator(createProduct,input), input);
    }

    @Override
    public Product create(Input input) {
        print("You want to add the new Ring");
        int id = input.enterInt("Enter the id", 100);
        String title = input.enterString("Enter the title");
        int price = input.enterInt("Enter the price", 10000);
        double weight = input.enterDouble("Enter the weight", 0, 10);
        double size = input.enterDouble("Enter the size", 15, 23);
        String description = input.enterString("Enter the description");
        print("Select material");
        print("0  -  WhiteGold");
        print("1  -   RedGold");
        print("2  -    Silver");
        int material = input.enterInt("", 2);
        print("Select insert");
        print("0  -     None");
        print("1  -    Diamond");
        print("2  -    Fianit");
        print("3  -    Emerald");
        int insert = input.enterInt("", 3);
        Ring ring = new Ring(id, price, title, description, weight, size,
                Material.choose(material), Insert.choose(insert));
        Util.print("You added new Ring");
        return ring;
    }

    @Override
    public boolean check(String productName) {
        return ("ring".equalsIgnoreCase(productName));
    }
}
