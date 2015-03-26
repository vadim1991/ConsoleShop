package com.epam.Vadym_Vlasenko.eShop.util.Input;

import com.epam.Vadym_Vlasenko.eShop.util.Util;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class ConsoleInput implements Input {
    @Override
    public int enterInt(String message, int max) {
        return Util.enterInt(message);
    }

    @Override
    public double enterDouble(String message, int min,int max) {
        return Util.enterDouble(message);
    }

    @Override
    public String enterString(String message) {
        return Util.enterString(message);
    }
}
