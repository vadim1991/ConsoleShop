package com.epam.Vadym_Vlasenko.eShop.util.create.create_with_chain;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;

/**
 * Created by Вадим on 24.03.2015.
 */
public abstract class ProductCreatorWithChain {

    private ProductCreatorWithChain productCreator;
    private Inputer input;

    public ProductCreatorWithChain(ProductCreatorWithChain createProduct, Inputer input) {
        this.productCreator = createProduct;
        this.input = input;
    }

    public Product execute(String productName) {
        Product product = null;
            if (check(productName)) {
                product = this.create(input);
            } else {
                if (productCreator != null) {
                product = productCreator.execute(productName);
            }
        }
        return product;
    }

    public abstract Product create(Inputer input);

    public abstract boolean check(String productName);

}
