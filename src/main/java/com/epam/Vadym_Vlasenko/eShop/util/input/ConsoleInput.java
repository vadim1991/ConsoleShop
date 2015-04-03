package com.epam.Vadym_Vlasenko.eShop.util.input;

import com.epam.Vadym_Vlasenko.eShop.util.Util;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class ConsoleInput implements Inputer {
    @Override
    public int getInt(String message, int max) {
        return Util.getInt(message);
    }

    @Override
    public double getDouble(String message, int min, int max) {
        return Util.getDouble(message);
    }

    @Override
    public String getString(String message) {
        return Util.getString(message);
    }
}
