package com.epam.Vadym_Vlasenko.eShop.util.input;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public enum InputType {

    Console, Random;

    public static InputType chooseInput(int index) {
        InputType inputType = null;
        switch (index) {
            case 1:
                inputType = InputType.Console;
                break;
            case 2:
                inputType = InputType.Random;
                break;
        }
        return inputType;
    }

}
