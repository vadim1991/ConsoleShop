package com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.Material;
import com.epam.Vadym_Vlasenko.eShop.entity.Ring;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;
import com.epam.Vadym_Vlasenko.eShop.util.Util;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.print;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class RingCreator implements ProductCreator {

    @Override
    public Product create(Inputer input) {
        print("You want to add the new Ring");
        int id = input.getInt("Enter the id", 100);
        String title = input.getString("Enter the title");
        int price = input.getInt("Enter the price", 10000);
        double weight = input.getDouble("Enter the weight", 0, 10);
        double size = input.getDouble("Enter the size", 15, 23);
        String description = input.getString("Enter the description");
        print("Select material");
        print("0  - " + Material.WHITE_GOLD);
        print("1  - " + Material.RED_GOLD);
        print("2  - " + Material.SILVER);
        int material = input.getInt("", 2);
        print("Select insert");
        print("0  - " + Insert.NONE);
        print("1  - " + Insert.DIAMOND);
        print("2  - " + Insert.FIANIT);
        print("3  - " + Insert.EMERALD);
        int insert = input.getInt("", 3);
        Ring ring = new Ring(id, price, title, description, weight, size,
                Material.choose(material), Insert.choose(insert));
        Util.print("You added new Ring");
        return ring;
    }
}
