package com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public interface ProductCreator {

    Product create(Inputer input);

}
