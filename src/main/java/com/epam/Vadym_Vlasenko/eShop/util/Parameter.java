package com.epam.Vadym_Vlasenko.eShop.util;

import java.lang.annotation.*;

/**
 * Created by Vadym_Vlasenko on 25.03.2015.
 */

@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Parameter {
    String parameter();
}
