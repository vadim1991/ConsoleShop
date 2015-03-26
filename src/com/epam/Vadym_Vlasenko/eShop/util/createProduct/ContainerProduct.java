package com.epam.Vadym_Vlasenko.eShop.util.createProduct;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class ContainerProduct {

    private static final String[] PRODUCT_NAMES = {"ring", "earrings"};

    private Map<String, CreateProduct> container;

    public ContainerProduct() {
        container = new HashMap<>();
        init();
    }

    private void init() {
        int index = 0;
        container.put(PRODUCT_NAMES[index++],new CreateRing());
        container.put(PRODUCT_NAMES[index++],new CreateEarrings());
    }

    public CreateProduct getCreateProduct(String nameProduct) {
        String name = nameProduct.toLowerCase();
        return container.get(name);
    }

}
