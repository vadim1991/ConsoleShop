package com.epam.Vadym_Vlasenko.eShop.util.input;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public interface Inputer {

    int getInt(String message, int max);

    double getDouble(String message, int min, int max);

    String getString(String message);

}
