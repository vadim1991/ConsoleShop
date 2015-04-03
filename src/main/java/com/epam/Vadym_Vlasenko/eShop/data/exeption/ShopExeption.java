package com.epam.Vadym_Vlasenko.eShop.data.exeption;

/**
 * Created by Vadym_Vlasenko on 01.04.2015.
 */
public class ShopExeption extends RuntimeException {

    public ShopExeption() {
    }

    public ShopExeption(String message) {
        super(message);
    }

    public ShopExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ShopExeption(Throwable cause) {
        super(cause);
    }
}
