package com.epam.Vadym_Vlasenko.eShop.util.create;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.util.Input.Input;

/**
 * Created by Вадим on 24.03.2015.
 */
public abstract class AbstractCreateProduct {

    private AbstractCreateProduct nextCreateProduct;
    private Input input;

    public AbstractCreateProduct(AbstractCreateProduct createProduct, Input input) {
        this.nextCreateProduct = createProduct;
        this.input = input;
    }

    public Product execute(String productName) {
        Product product = null;
            if (check(productName)) {
                product = this.create(input);
            } else {
                if (nextCreateProduct != null) {
                product = nextCreateProduct.execute(productName);
            }
        }
        return product;
    }

    public abstract Product create(Input input);

    public abstract boolean check(String productName);

}
