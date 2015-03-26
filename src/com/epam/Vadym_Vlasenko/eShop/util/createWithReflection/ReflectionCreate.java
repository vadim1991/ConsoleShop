package com.epam.Vadym_Vlasenko.eShop.util.createWithReflection;

import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.jewel.Material;
import com.epam.Vadym_Vlasenko.eShop.util.Input.Input;
import com.epam.Vadym_Vlasenko.eShop.util.Parameter;
import com.epam.Vadym_Vlasenko.eShop.util.createProduct.CreateProduct;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym_Vlasenko on 25.03.2015.
 */
public class ReflectionCreate implements CreateProduct {

    private static final String BEGIN_MESSAGE = "Enter the ";
    private static final String NAME_PACKAGE_ENTITY = "com.epam.Vadym_Vlasenko.eShop.entity.";

    private String name_class;

    public ReflectionCreate(String name_class) {
        this.name_class = name_class;
    }

    private List<Object> getSourceParameter(Input input, Class[] types, Method method) {
        String param = method.getAnnotation(Parameter.class).parameter();
        String paramType = method.getAnnotation(Parameter.class).parameterType();
        List<Object> paramList = new ArrayList<>();
        for (Class type : types) {
            if ("int".equals(paramType)) {
                paramList.add(input.enterInt(BEGIN_MESSAGE + param, 100));
            }
            if ("double".equals(paramType)) {
                paramList.add(input.enterDouble(BEGIN_MESSAGE + param, 1,10));
            }
            if ("String".equals(paramType)) {
                paramList.add(input.enterString(BEGIN_MESSAGE + param));
            }
            if ("enum".equals(paramType)) {
                if ("insert".equals(param)) {
                    int insert = (input.enterInt(param, 3));
                    paramList.add(Insert.choose(insert));
                }
                if ("material".equals(param)) {
                    int material = input.enterInt(param, 2);
                    paramList.add(Material.choose(material));
                }
            }
        }
        return paramList;
    }

    private Product createPrivate(Input input) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(NAME_PACKAGE_ENTITY + name_class);
        Object object = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Parameter.class)) {
                try {
                    method.invoke(object, getSourceParameter(input, method.getParameterTypes(), method).toArray());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return (Product) object;
    }

    @Override
    public Product create(Input input) {
        Product product = null;
        try {
           product = createPrivate(input);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return product;
    }

}
