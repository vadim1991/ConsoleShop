package com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class ContainerProduct {

    private static final String[] PRODUCT_NAMES = {"ring", "earrings"};

    private Map<String, ProductCreator> container;

    public ContainerProduct() {
        container = new HashMap<>();
        init();
    }

    private void init() {
        int index = 0;
        container.put(PRODUCT_NAMES[index++],new RingCreator());
        container.put(PRODUCT_NAMES[index++],new EarringsCreator());
    }

    public ProductCreator getCreateProduct(String nameProduct) {
        String name = nameProduct.toLowerCase();
        return container.get(name);
    }

}
