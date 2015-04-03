package com.epam.Vadym_Vlasenko.eShop.command;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.service.IService;
import com.epam.Vadym_Vlasenko.eShop.util.Util;
import com.epam.Vadym_Vlasenko.eShop.util.create.create_with_chain.ProductCreatorWithChain;
import com.epam.Vadym_Vlasenko.eShop.util.create.create_with_chain.RingCreator;
import com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command.ContainerProduct;
import com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command.ProductCreator;
import com.epam.Vadym_Vlasenko.eShop.util.create.reflection.ReflectionCreator;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.*;

public class AddProductCommand implements Command {

    private ContainerProduct containerProduct = new ContainerProduct();
    private ProductCreatorWithChain createProduct;
    private static final String MESSAGE = "You haven`t product with this name!!!";

    @Override
    public void execute(IService service) {
        print("You want to add the new Product");
        String productTitle = Util.getString("Enter the title of product");
        print("Select method of add product : ");
        print("1 - with command");
        print("2 - with chain");
        print("3 - with reflection");
        int indexOfMethod = getInt("");

        //with command
        if (indexOfMethod == 1) {
            ProductCreator createProduct = containerProduct.getCreateProduct(productTitle);
            Product product = createProduct.create(service.getInput());
            service.addNewProduct(product);
        }

        // with chain
        if (indexOfMethod == 2) {
            createProduct = new RingCreator(createProduct, service.getInput());
            Product product = createProduct.execute(productTitle);
            if (product != null) {
                service.addNewProduct(product);
            } else {
                printError(MESSAGE);
            }
        }

        //with reflection
        if (indexOfMethod == 3) {
            ReflectionCreator reflectionCreate = new ReflectionCreator(productTitle, service.getLocalizator());
            Product product = reflectionCreate.create(service.getInput());
            if (product != null) {
                service.addNewProduct(product);
            } else {
                printError(MESSAGE);
            }
        }

        print("You added new product");
    }

}
