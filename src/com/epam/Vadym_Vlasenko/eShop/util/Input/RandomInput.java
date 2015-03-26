package com.epam.Vadym_Vlasenko.eShop.util.Input;

import java.util.Random;

import static com.epam.Vadym_Vlasenko.eShop.util.Util.*;

/**
 * Created by Vadym_Vlasenko on 24.03.2015.
 */
public class RandomInput implements Input {

    private static final char A = 97;
    private static final char Z = 122;
    private static final int SIZE = 32;
    private static final int SIZE_TITLE = 5;


    @Override
    public int enterInt(String message, int max) {
        Random random = new Random();
        print(message);
        int result = random.nextInt(max);
        print(Integer.toString(result));
        return result;
    }

    @Override
    public double enterDouble(String message, int min, int max) {
        Random random = new Random();
        print(message);
        double result = 0;
        while (result < min) {
            result = random.nextInt(max) - 0.5;
        }
        print(Double.toString(result));
        return result;
    }

    @Override
    public String enterString(String message) {
        print(message);
        Random random = new Random();
        String result = "";
        String alphabet = toCreateAlphabet();
        for (int i = 0; i < SIZE_TITLE; i++) {
            result += alphabet.charAt(random.nextInt(SIZE));
        }
        print(result);
        return result;
    }

    private String toCreateAlphabet() {
        char[] alphabet = new char[SIZE];
        int index = 0;
        for (char i = A; i <= Z; i++) {
            alphabet[index++] += i;
        }
        return new String(alphabet);
    }

}
