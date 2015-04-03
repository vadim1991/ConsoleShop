package com.epam.Vadym_Vlasenko.eShop.util.create.reflection;

import com.epam.Vadym_Vlasenko.eShop.data.exeption.ShopExeption;
import com.epam.Vadym_Vlasenko.eShop.entity.Product;
import com.epam.Vadym_Vlasenko.eShop.entity.Insert;
import com.epam.Vadym_Vlasenko.eShop.entity.Material;
import com.epam.Vadym_Vlasenko.eShop.ui.localization.Localizator;
import com.epam.Vadym_Vlasenko.eShop.util.input.Inputer;
import com.epam.Vadym_Vlasenko.eShop.util.Parameter;
import com.epam.Vadym_Vlasenko.eShop.util.create.create_with_command.ProductCreator;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vadym_Vlasenko on 25.03.2015.
 */
public class ReflectionCreator implements ProductCreator {

    private Localizator localizator;

    private static final Logger LOG = Logger.getLogger(ReflectionCreator.class);
    private static final String NAME_PACKAGE_ENTITY = "com.epam.Vadym_Vlasenko.eShop.entity.";

    private String nameClass;

    public ReflectionCreator(String nameClass, Localizator localizator) {
        this.nameClass = nameClass;
        this.localizator = localizator;
    }

    private List<Object> getSourceParameter(Inputer input, Class[] types, Method method) {
        String begin_message = localizator.getValue("enter");
        String parameter = method.getAnnotation(Parameter.class).parameter();
        String param = localizator.getValue(parameter);
        List<Object> paramList = new ArrayList<>();
        for (Class type : types) {
            String message = begin_message + " " + param;
            if (int.class == type) {
                paramList.add(input.getInt(message, 100));
            }
            if (double.class == type) {
                paramList.add(input.getDouble(message, 1, 10));
            }

            if (String.class == type) {
                paramList.add(input.getString(message));
            }
            if (Insert.class == type) {
                int insert = (input.getInt(param, 3));
                paramList.add(Insert.choose(insert));
            }
            if (Material.class == type) {
                int material = input.getInt(param, 2);
                paramList.add(Material.choose(material));
            }
        }
        return paramList;
    }

    private Product createPrivate(Inputer input) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName(NAME_PACKAGE_ENTITY + nameClass);
        Object object = clazz.newInstance();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Parameter.class)) {
                try {
                    method.invoke(object, getSourceParameter(input, method.getParameterTypes(), method).toArray());
                } catch (IllegalAccessException e) {
                    LOG.error(e);
                    throw new ShopExeption(e);
                } catch (InvocationTargetException e) {
                    LOG.error(e);
                    throw new ShopExeption(e);
                }
            }
        }
        return (Product) object;
    }

    /**
     * Method to create an object using reflection
     * @param input type of {@code Product} parameters input
     * @return {@code Product} instance
     */
    @Override
    public Product create(Inputer input) {
        Product product;
        try {
            product = createPrivate(input);
        } catch (Exception e) {
            LOG.error(e);
            throw new ShopExeption(e);
        }
        return product;
    }

}
