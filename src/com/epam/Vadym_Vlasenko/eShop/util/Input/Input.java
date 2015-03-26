package com.epam.Vadym_Vlasenko.eShop.util.Input;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public interface Input {

    int enterInt(String message, int max);

    double enterDouble(String message,int min, int max);

    String enterString(String message);

}
